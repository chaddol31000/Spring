package com.example.demo.controller;

import jakarta.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.util.*;

@Controller
public class SampleController4 {
  // GET 방식 | /numbers/list : 루트 페이지(합계, 평균 출력)
  // GET 방식 | /numbers/add : 숫자 추가 화면
  // POST 방식 | /numbers/add : 숫자 추가하고 루트 페이지로 이동

  // 정수를 저장하는 ArrayList 를 생성
  // 자바에서 참조변수는 항상 부모
  private List<Integer> numbers = new ArrayList<>();

  // numbers 에 값을 3개 추가 → 생성자는 스프링이 사용
  // 우리가 컨트롤러의 객체를 생성한 적이 있나? 없다 → @Controller 의 객체는 스프링이 생성 (제어의 역전)
  // 생성자 다음에 실행 (개발자 정의 초기화)
  @PostConstruct
  private void init() {
    numbers.add(10);
    numbers.add(20);
    numbers.add(30);
  }

  @GetMapping("/numbers/list")
  public ModelAndView list() {
    int sum = 0;
    for (Integer i : numbers) {
      sum += i;
    }
    double avg =(double)sum / numbers.size();
    return new ModelAndView("numbers/list").addObject("sum", sum)
        .addObject("avg", avg);
  }

  @PostMapping("numbers/add")
  public ModelAndView add(int num) {
    numbers.add(num);
    return new ModelAndView("redirect:/numbers/list");
  }
}

