package web.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Car {
    private int id;
    private String model;
    private int age;
    private static List<Car> carList = List.of(new Car(1, "Toyota", 2004)
                , new Car(2, "Honda", 2020), new Car(3, "BMW", 2015)
                , new Car(4, "Audi", 2018), new Car(5, "Lada", 2003));

    public Car(int id, String model, int age) {
        this.id = id;
        this.model = model;
        this.age = age;
    }

    public Car() {
    }

    public static List<Car> getCarList(Integer a) {
        if (a == null) {
            return carList;
        } else {
            return carList.stream().limit(a).toList();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
