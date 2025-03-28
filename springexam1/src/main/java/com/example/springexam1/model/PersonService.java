package com.example.springexam1.model;

import com.example.springexam1.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PersonService {
    // 추가
    @Autowired
    private PersonDAO personDAO;
    public void insert(Person person) {
        personDAO.dao_insert(person);
    }
    //전체보기 (검색 미포함)
    public List<Person> findAll() {
        return personDAO.dao_list();
    }
    //전체보기 (검색 포함)
    public List<Person> findAll(String field, String word) {
        HashMap<String, String> map = new HashMap<>();
        map.put("field", field);
        map.put("word", word);
        return personDAO.dao_list("searchList", map);
    }
    // 갯수 세기 (검색 포함)
    public int count(String field, String word) {
        HashMap<String, String> map = new HashMap<>();
        map.put("field", field);
        map.put("word", word);
        return personDAO.dao_count("searchCount", map);
    }
    // 갯수 세기(검색 아님)
    public int count() {
        return personDAO.dao_count();
    }
    //상세보기
    public Person findById(String id) {
        return personDAO.findById(id);
    }
    public void updatePerson(Person person) {
        personDAO.dao_update(person);
    }
    //삭제하기
    public void deletePerson(String id) {
        personDAO.dao_delete(id);
    }
    public int nametoAddr(String name) {
        return personDAO.dao_nametoAddr(name);
    }
}
