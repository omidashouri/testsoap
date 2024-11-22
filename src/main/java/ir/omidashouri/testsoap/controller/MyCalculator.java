package ir.omidashouri.testsoap.controller;


import ir.omidashouri.testsoap.exception.DivideByZeroException;
import ir.omidashouri.testsoap.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/calculator")
public class MyCalculator {

    @Autowired
    public CalculatorService calculatorService;

    @PostMapping("/add/{a}/{b}")
    public String add(@PathVariable("a") int a, @PathVariable("b") int b) {
        return calculatorService.add(a, b) + "";
    }

    @PostMapping("/subtract/{a}/{b}")
    public String subtract(@PathVariable("a") int a, @PathVariable("b") int b) {
        return calculatorService.subtract(a, b) + "";
    }

    @PostMapping("/multiply/{a}/{b}")
    public String multiply(@PathVariable("a") int a, @PathVariable("b") int b) {
        return calculatorService.multiply(a, b) + "";
    }

    @PostMapping("/divide/{a}/{b}")
    public String divide(@PathVariable("a") int a, @PathVariable("b") int b) {
        if (b == 0) {
            throw new DivideByZeroException("Cannot divide by zero.");
        }
        return calculatorService.divide(a, b) + "";
    }

}
