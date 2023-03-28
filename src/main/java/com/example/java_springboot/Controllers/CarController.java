package com.example.java_springboot.Controllers;

import com.example.java_springboot.dao.CarDAO;
import com.example.java_springboot.modules.Car;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CarController {
    private CarDAO carDAO;

    @GetMapping("/cars")
    public List<Car> getCars() {
        List<Car> all = carDAO.findAll();
        return all;
    }

    @GetMapping("/car/{id}")
    public Car getCarById(@PathVariable int id) {
        Car car = carDAO.findById(id).get();
        return car;
    }

    @PostMapping("/cars")
    public void save(@RequestBody Car car) {
        carDAO.save(car);
        return;
    }

    @DeleteMapping("/delete/car/{id}")
    public List<Car> delete(@PathVariable int id) {
        carDAO.deleteById(id);
        System.out.println(id);
        return carDAO.findAll();
    }

    @GetMapping("/cars/power/{powerValue}")
    public List<Car> getCarsByPower(@PathVariable int powerValue) {
        List<Car> carsByPower = carDAO.getCarsByPower(powerValue);
        return carsByPower;
    }
}
