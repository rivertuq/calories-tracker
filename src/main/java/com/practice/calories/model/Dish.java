package com.practice.calories.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Название не может быть пустым")
    private String name;

    @Positive(message = "Калорийность должна быть положительной")
    private int calories;

    private double proteins;
    private double fats;
    private double carbohydrates;

    public Dish() {}

    public Dish(String name, int calories, double proteins, double fats, double carbohydrates) {
        this.name = name;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Название не может быть пустым") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Название не может быть пустым") String name) {
        this.name = name;
    }

    @Positive(message = "Калорийность должна быть положительной")
    public int getCalories() {
        return calories;
    }

    public void setCalories(@Positive(message = "Калорийность должна быть положительной") int calories) {
        this.calories = calories;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }
}
