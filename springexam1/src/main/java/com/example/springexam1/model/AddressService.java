package com.example.springexam1.model;

import com.example.springexam1.dto.AddressDTO;

import java.util.List;

public interface AddressService {
    // 추가
    public void insertAddr(AddressDTO address);
    // 전체보기
    public List<AddressDTO> getAddrList();
    // 상세보기
    public AddressDTO getAddr(int num);
    // 수정
    public void updateAddr(AddressDTO address);
    // 삭제
    public void deleteAddr(int num);
    // 갯수
    public int countAddr();
}
