package com.practice.calories.controller;

import com.practice.calories.model.Meal;
import com.practice.calories.model.User;
import com.practice.calories.repository.DishRepository;
import com.practice.calories.repository.MealRepository;
import com.practice.calories.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/meals")
public class MealController {
    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DishRepository dishRepository;

    @PostMapping
    public Meal createMeal(@RequestParam Long userId, @RequestBody List<Long> dishIds) {
        Meal meal = new Meal();
        meal.setUser(userRepository.findById(userId).orElseThrow());
        meal.setDishes(dishRepository.findAllById(dishIds));
        meal.setDate(LocalDate.now());
        return mealRepository.save(meal);
    }

    @GetMapping("/report")
    public Integer getDailyCalorieReport(@RequestParam Long userId, @RequestParam LocalDate date) {
        return mealRepository.getTotalCaloriesForDay(userId, date);
    }

    @GetMapping("/history")
    public List<Meal> getMealHistory(@RequestParam Long userId) {
        return mealRepository.findByUserIdAndDate(userId, LocalDate.now());
    }

    @GetMapping("/calorie-check")
    public boolean checkCalorieLimit(@RequestParam Long userId, @RequestParam LocalDate date) {
        Integer totalCalories = mealRepository.getTotalCaloriesForDay(userId, date);
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        return totalCalories != null && totalCalories <= user.getDailyCalorieIntake();
    }

}
