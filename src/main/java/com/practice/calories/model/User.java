package com.practice.calories.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Имя не может быть пустым")
    private String name;

    @Email(message = "Некорректный email")
    @NotBlank(message = "Email обязателен")
    private String email;

    @NotNull(message = "Укажите возраст")
    @Min(value = 10, message = "Возраст должен быть не менее 10 лет")
    private Integer age;

    @NotNull(message = "Укажите вес")
    @Min(value = 30, message = "Вес должен быть не менее 30 кг")
    @Max(value = 250, message = "Вес должен быть не более 250 кг")
    private Double weight;

    @NotNull(message = "Укажите рост")
    @Min(value = 100, message = "Рост должен быть не менее 100 см")
    @Max(value = 250, message = "Рост должен быть не более 250 см")
    private Double height;

    @NotBlank(message = "Цель должна быть указана")
    private String goal;

    private double dailyCalorieIntake;

    public void calculateDailyCalorieIntake() {
        if (goal.equals("Похудение")) {
            dailyCalorieIntake = (10 * weight + 6.25 * height - 5 * age - 500);
        } else if (goal.equals("Набор массы")) {
            dailyCalorieIntake = (10 * weight + 6.25 * height - 5 * age + 500);
        } else {
            dailyCalorieIntake = (10 * weight + 6.25 * height - 5 * age);
        }
    }

    public User() {}

    public User(String name, String email, int age, double weight, double height, String goal) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.goal = goal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Имя не может быть пустым") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Имя не может быть пустым") String name) {
        this.name = name;
    }

    public @Email(message = "Некорректный email") @NotBlank(message = "Email обязателен") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Некорректный email") @NotBlank(message = "Email обязателен") String email) {
        this.email = email;
    }

    public @NotNull(message = "Возраст обязателен") @Min(value = 10, message = "Возраст должен быть не менее 10 лет") Integer getAge() {
        return age;
    }

    public void setAge(@NotNull(message = "Возраст обязателен") @Min(value = 10, message = "Возраст должен быть не менее 10 лет") Integer age) {
        this.age = age;
    }

    public @NotNull(message = "Вес обязателен") @Min(value = 30, message = "Вес должен быть не менее 30 кг") @Max(value = 300, message = "Вес должен быть не более 300 кг") Double getWeight() {
        return weight;
    }

    public void setWeight(@NotNull(message = "Вес обязателен") @Min(value = 30, message = "Вес должен быть не менее 30 кг") @Max(value = 300, message = "Вес должен быть не более 300 кг") Double weight) {
        this.weight = weight;
    }

    public @NotNull(message = "Рост обязателен") @Min(value = 100, message = "Рост должен быть не менее 100 см") @Max(value = 250, message = "Рост должен быть не более 250 см") Double getHeight() {
        return height;
    }

    public void setHeight(@NotNull(message = "Рост обязателен") @Min(value = 100, message = "Рост должен быть не менее 100 см") @Max(value = 250, message = "Рост должен быть не более 250 см") Double height) {
        this.height = height;
    }

    public @NotBlank(message = "Цель должна быть указана") String getGoal() {
        return goal;
    }

    public void setGoal(@NotBlank(message = "Цель должна быть указана") String goal) {
        this.goal = goal;
    }

    public double getDailyCalorieIntake() {
        return dailyCalorieIntake;
    }

    public void setDailyCalorieIntake(double dailyCalorieIntake) {
        this.dailyCalorieIntake = dailyCalorieIntake;
    }
}
