package com.example.springexam1.controller;

import com.example.springexam1.dto.Person;
import com.example.springexam1.model.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private PersonService personService;
    // 추가 폼으로 가기
    @GetMapping("pinsert")
    public String pinsert() {
        return "insert";
    }
    // 추가
    @PostMapping("pinsert")
    public String insertPost(@ModelAttribute Person person) {
        personService.insert(person);
        return "redirect:/plist";
    }
    // 전체 보기
    @GetMapping("plist")
    public String plist(
            @RequestParam(name= "field", required = false) String field,
            @RequestParam(name= "word", required = false) String word,
            Model model
    ) {
        List<Person> personList;
        int count;

        // word가 있고, 공백이 아니면 → 검색 모드
        if (word != null && !word.trim().isEmpty()) {
            personList = personService.findAll(field, word);
            count = personService.count(field, word);
        } else {
            // 검색어 없으면 전체 조회
            personList = personService.findAll();
            count = personService.count();
        }

        model.addAttribute("personList", personList);
        model.addAttribute("count", count);

        // 검색어 유지용(선택)
        model.addAttribute("field", field);
        model.addAttribute("word", word);

        return "list";  // list.jsp 로 이동
    }
    //상세 보기
    @GetMapping("pDetail")
    public String pDetail(@RequestParam("id") String id, Model model) {
        Person person=personService.findById(id);
        model.addAttribute("person", person);
        return "detail";
    }
    @PostMapping("deletePerson")
    public String deletePerson(@RequestParam("id") String id) {
        personService.deletePerson(id);
        return "redirect:/plist";
    }
    @GetMapping("/updatePersonForm")
    public String showUpdateForm(@RequestParam("id") String id, Model model) {
        Person person = personService.findById(id);
        model.addAttribute("person", person);
        return "update";  // 이건 update.jsp (뷰 이름)
    }

    @PostMapping("updatePerson")
    public String updatePerson(Person person){
        personService.updatePerson(person);
        return "redirect:/plist";
    }
    @GetMapping("nametoAddr")
    public String nametoAddr(@RequestParam("name") String name) {
        int query=personService.nametoAddr(name);
        return "redirect:/aview?num="+query;
    }



}
