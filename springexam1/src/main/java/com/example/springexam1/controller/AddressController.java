package com.example.springexam1.controller;

import com.example.springexam1.dto.AddressDTO;
import com.example.springexam1.model.AddressServiceImpl;
import com.example.springexam1.model.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AddressController {
    @Autowired
    private AddressServiceImpl addressService;
    @GetMapping("ainsert")
    public String openAinsert() {
        return "/address/insert";
    }
    @GetMapping("alist")
    public String alist(@RequestParam(name="field", required = false) String field, @RequestParam(name="word", required = false) String word, Model model) {
        List<AddressDTO> alist;
        int count;

        if (word != null && !word.trim().isEmpty()) {
            alist = addressService.getAddrList(field, word);
            count = addressService.countAddr(field, word);
        } else {
            // 검색어 없으면 전체 조회
            alist = addressService.getAddrList();
            count = addressService.countAddr();
        }
        model.addAttribute("count",count);
        model.addAttribute("alist", alist);
        return "/address/list";
    }
    @PostMapping("ainsert")
    public String insertAinsert(@ModelAttribute AddressDTO address) {
        addressService.insertAddr(address);
        return "redirect:/alist";
    }
    @GetMapping("aview")
    public String aview(@RequestParam("num") int num, Model model) {
        model.addAttribute("addr", addressService.getAddr(num));
        return "/address/view";
    }
    @GetMapping("adelete")
    public String adelete(@RequestParam("num") int num){
        addressService.deleteAddr(num);
        return "redirect:/alist";
    }
    @PostMapping("aupdate")
    public String aupdate(@ModelAttribute AddressDTO addr) {
//        System.out.println(addr.getAddress());
        addressService.updateAddr(addr);
        return "redirect:/alist";
    }
    @GetMapping("atoUser")
    public String atoUser(@RequestParam("name") String name) {
        String query=addressService.atoUser(name);
        return "redirect:/pDetail?id=" + query;
    }
}
