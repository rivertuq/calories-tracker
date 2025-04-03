package com.practice.calories.repository;

import com.practice.calories.model.Dish;
import com.practice.calories.model.Meal;
import com.practice.calories.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;


@DataJpaTest
public class MealRepositoryTest {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DishRepository dishRepository;

    @Test
    public void testGetTotalCaloriesForDay() {
        // Создаем пользователя
        User user = new User("Виктория", "vika52@mail.com", 25, 55.0, 170.0, "Поддержание");
        userRepository.save(user);

        // Создаем блюда
        Dish dish1 = new Dish("Гречневая Каша", 200, 5, 3, 30);
        Dish dish2 = new Dish("Яйцо", 80, 7, 5, 1);
        dishRepository.saveAll(List.of(dish1, dish2));

        // Создаем прием пищи
        Meal meal = new Meal();
        meal.setUser(user);
        meal.setDishes(List.of(dish1, dish2));
        meal.setDate(LocalDate.now());
        mealRepository.save(meal);

    }
}