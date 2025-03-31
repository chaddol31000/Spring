package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.time.*;

@Controller
public class SampleController3 {
  // 숫자를 입력받아 제곱해서 출력 : 3을 입력하면 9를 출력
  // 자바는 get 따로 post 따로 작성함
  // 주소를 2단으로 표현
  @GetMapping("/square/input")
  public ModelAndView squareinput() {
    return new ModelAndView("square/input");
  }
// 여기 써있는 Mapping 페이지는 타임리프주소임
  @PostMapping("/square/output")
  // a = int request.form.get(a) 와 같은 것 ↓
  public ModelAndView squareoutput(int a) {
      int result = a * a;
      return new ModelAndView("square/output").addObject("result", result);
  }

  // 이름과 태어난 년도를 입력하면 "홍길동 님은 15살" 출력
  // get, post 는 서로 오버로딩인 관계
  @GetMapping("/age")
  public ModelAndView age() {
    return new ModelAndView("age/input");
  }

  @PostMapping("/age")
  public ModelAndView age(String name,int birthYear) {
    int thisYear = LocalDate.now().getYear();
    int age = thisYear - birthYear;
    String message = name + "님은 " + age + "살입니다";
    return new ModelAndView("age/output").addObject("message", message);
  }

  // /add | get - 숫자 2개 입력 받기 | post - 덧셈한 결과 출력

  @GetMapping("/add")
  public ModelAndView add() {
    return new ModelAndView("add/input");
  }

  @PostMapping("/add")
  public ModelAndView age(int num1, int num2) {
    int result = num1 + num2;
    String message2 = "덧셈한 결과 : " + result;
    return new ModelAndView("add/output").addObject("message2", message2);
  }
}
