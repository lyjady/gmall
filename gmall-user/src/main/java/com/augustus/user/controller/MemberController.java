package com.augustus.user.controller;

import com.augustus.user.bean.UmsMember;
import com.augustus.user.bean.UmsMemberReceiveAddress;
import com.augustus.user.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LinYongJin
 * @date 2020/2/1 16:55
 */
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/findAll")
    public List<UmsMember> findAll() {
        return memberService.findAll();
    }

    @GetMapping("/findById/{id}")
    public UmsMember findMemberById(@PathVariable Long id) {
        return memberService.findById(id);
    }

    @GetMapping("/findReceiveAddressById/{id}")
    public List<UmsMemberReceiveAddress> findReceiveAddressById(@PathVariable Long id) {
        return memberService.findReceiveAddressById(id);
    }
}
