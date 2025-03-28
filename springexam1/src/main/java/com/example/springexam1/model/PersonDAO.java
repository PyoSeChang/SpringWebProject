package com.example.springexam1.model;

import com.example.springexam1.dto.Person;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class PersonDAO {
    @Autowired
    private SqlSession sqlMapper;
    public void dao_insert(Person person) {
        sqlMapper.insert("PersonMapper.personInsert", person);;
    }

    // 전체보기
    public List<Person> dao_list() {
        return sqlMapper.selectList("PersonMapper.personList");
    }
    // 전체보기 (검색 포함)
    public List<Person> dao_list(String mid, HashMap<String, String> map) {
        return sqlMapper.selectList(mid, map);
    }

    // 갯수 세기 (검색 미포함)
    public int dao_count() {
        return sqlMapper.selectOne("PersonMapper.personCount");
    }
    // 갯수 세기 (검색 포함)
    public int dao_count(String mid, HashMap<String, String> map) {
        return sqlMapper.selectOne(mid, map);
    }

    // 상세보기
    public Person findById(String id) {
        return sqlMapper.selectOne("PersonMapper.detailData", id);
    }

    // 업데이트
    public void dao_update(Person person) {
        sqlMapper.update("PersonMapper.updatePerson", person);
    }

    // 삭제하기
    public void dao_delete(String id) {
        sqlMapper.delete("PersonMapper.deletePerson", id);
    }

    public int dao_nametoAddr(String id) {
        return sqlMapper.selectOne("PersonMapper.nametoAddrData", id);
    }
}
