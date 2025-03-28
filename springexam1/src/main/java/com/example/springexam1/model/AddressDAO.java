package com.example.springexam1.model;

import com.example.springexam1.dto.AddressDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class AddressDAO {

    @Autowired
    private SqlSession sqlMapper;
    public void insertAddr(AddressDTO adto) {
        sqlMapper.insert("AddressMapper.insertData", adto);;
    }

    // 전체 리스트
    public List<AddressDTO> selectAll() {
        return sqlMapper.selectList("AddressMapper.listData");
    }
    // 검색 리스트
    public List<AddressDTO> selectAll(String mid, HashMap<String, String> map) {
        return sqlMapper.selectList(mid, map);
    }

    public int countAddress() {
        return sqlMapper.selectOne("AddressMapper.countData");
    }
    public int countAddress(String mid, HashMap<String, String> map) {
        return sqlMapper.selectOne(mid, map);
    }

    public AddressDTO selectAddressById(int num) {
        return sqlMapper.selectOne("AddressMapper.viewData", num);
    }
    public void deleteAddress(int num) {
        sqlMapper.delete("AddressMapper.deleteData", num);
    }
    public void updateAddress(AddressDTO adto) {
        sqlMapper.update("AddressMapper.updateData", adto);
    }
    public String findUser(String name) {
        return sqlMapper.selectOne("AddressMapper.findUserData", name);
    }


}
