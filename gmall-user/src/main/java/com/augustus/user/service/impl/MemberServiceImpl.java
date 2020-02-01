package com.augustus.user.service.impl;

import com.augustus.user.bean.UmsMember;
import com.augustus.user.bean.UmsMemberReceiveAddress;
import com.augustus.user.mapper.UmsMemberMapper;
import com.augustus.user.mapper.UmsMemberReceiveAddressMapper;
import com.augustus.user.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LinYongJin
 * @date 2020/2/1 16:53
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private UmsMemberMapper memberMapper;

    @Autowired
    private UmsMemberReceiveAddressMapper receiveAddressMapper;

    @Override
    public List<UmsMember> findAll() {
        return memberMapper.findAll();
    }

    @Override
    public UmsMember findById(Long id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UmsMemberReceiveAddress> findReceiveAddressById(Long id) {
        return receiveAddressMapper.findReceiveAddressByMemberId(id);
    }
}
