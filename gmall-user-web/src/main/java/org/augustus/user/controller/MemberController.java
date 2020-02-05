package org.augustus.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.augustus.bean.UmsMember;
import org.augustus.bean.UmsMemberReceiveAddress;
import org.augustus.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LinYongJin
 * @date 2020/2/5 18:16
 */
@RestController
public class MemberController {

    @Reference
    private MemberService memberService;

    @GetMapping("/findAll")
    public List<UmsMember> findAll() {
        return memberService.findAll();
    }

    @GetMapping("/findReceiveAddress/{memberId}")
    public List<UmsMemberReceiveAddress> findReceiveAddress(@PathVariable String memberId) {
        return memberService.findMemberAddressByMemberId(Long.parseLong(memberId));
    }
}
