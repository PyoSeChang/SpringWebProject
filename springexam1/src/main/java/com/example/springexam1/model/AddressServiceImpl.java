package com.example.springexam1.model;

import com.example.springexam1.dto.AddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDAO addressDAO;
    @Override
    public void insertAddr(AddressDTO address) {
        addressDAO.insertAddr(address);
    }

    @Override
    public List<AddressDTO> getAddrList() {
        return addressDAO.selectAll();
    }
    public List<AddressDTO> getAddrList(String field, String word) {
        HashMap<String,String> map = new HashMap<>();
        map.put("field",field);
        map.put("word",word);
        return addressDAO.selectAll("searchListData", map);
    }
    @Override
    public int countAddr() {
        return addressDAO.countAddress();
    }
    public int countAddr(String field, String word) {
        HashMap<String,String> map = new HashMap<>();
        map.put("field",field);
        map.put("word",word);
        return addressDAO.countAddress("searchCountData", map);
    }
    @Override
    public AddressDTO getAddr(int num) {
        return addressDAO.selectAddressById(num);
    }

    @Override
    public void updateAddr(AddressDTO address) {
        addressDAO.updateAddress(address);
    }

    @Override
    public void deleteAddr(int num) {
        addressDAO.deleteAddress(num);
    }


    public String atoUser(String name) {
        return addressDAO.findUser(name);
    }
}
