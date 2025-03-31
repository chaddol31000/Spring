package com.example.demo.controller;

import jakarta.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.util.*;

@Controller
public class SampleController5 {

  private List<Double> numbers = new ArrayList<>();

  @PostConstruct
  private void init() {
    numbers.add (30.0);
    numbers.add (30.0);
    numbers.add (50.9);
  }

  @GetMapping("/doublelist/list")
  public ModelAndView list() {
    double sum = 0;
    for(double i:numbers) {
      sum += i;
    }
      double avg = sum / numbers.size();
      return new ModelAndView("doublelist/list").addObject("sum", sum)
          .addObject("avg", avg);
    }

  @PostMapping("doublelist/add")
  public ModelAndView add(double num) {
    numbers.add(num);
    return new ModelAndView("redirect:/doublelist/list");

  }
}
