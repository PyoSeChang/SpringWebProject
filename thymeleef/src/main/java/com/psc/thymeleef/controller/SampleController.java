package com.psc.thymeleef.controller;

import com.psc.thymeleef.dto.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class SampleController {
    @GetMapping("/hello")
    public void hello(Model model) {
        model.addAttribute("message", "Hello World");
    }
    @GetMapping("/arr")
    public void arrData(Model model) {
        List<String> list = Arrays.asList("a", "b", "c");
        model.addAttribute("list", list);
    }
    @GetMapping("/ex01")
    public void ex01() {

    }
    @GetMapping("/hello1")
    public void hello1(String name, int age, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);

    }
    @GetMapping("/hello2")
    public void hello2(String name, int age, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
    }
    @GetMapping("/hello3")
    public void hello3(@RequestParam(name="types") List<String> types, int age, Model model) {
        model.addAttribute("types", types);
        model.addAttribute("age", age);

    }

    @GetMapping("/ex02")
    public void ex02(Model model) {
        List<String> list = Arrays.asList("a", "b", "c");
        model.addAttribute("list", list);
        Map<String, Integer> maps = new HashMap<>();
        maps.put("홍길동", 80);
        maps.put("박경미", 75);
        maps.put("YoonYoSub", 85);
        model.addAttribute("maps", maps);

        SampleDTO sampleDTO = new SampleDTO();
        sampleDTO.setName("hong");
        sampleDTO.setAge(20);
        sampleDTO.setGender("Man");
        model.addAttribute("sampleDTO", sampleDTO);
    }

    @GetMapping("/layout_test")
    public void layout_test() {

    }

}
