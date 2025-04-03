package com.practice.calories.repository;

import com.practice.calories.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {
    List<Meal> findByUserIdAndDate(Long userId, LocalDate date);

    @Query("SELECT SUM(d.calories) FROM Meal m JOIN m.dishes d WHERE m.user.id = :userId AND m.date = :date")
    Integer getTotalCaloriesForDay(@Param("userId") Long userId, @Param("date") LocalDate date);
}