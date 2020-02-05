package org.augustus.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.augustus.bean.UmsMember;
import org.augustus.bean.UmsMemberReceiveAddress;
import org.augustus.service.MemberService;
import org.augustus.user.mapper.UmsMemberMapper;
import org.augustus.user.mapper.UmsMemberReceiveAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author LinYongJin
 * @date 2020/2/5 18:06
 */
@Service
@Component
public class MemberServiceImpl implements MemberService {

    @Autowired
    private UmsMemberMapper memberMapper;

    @Autowired
    private UmsMemberReceiveAddressMapper memberReceiveAddressMapper;

    @Override
    public List<UmsMember> findAll() {
        return memberMapper.findAll();
    }

    @Override
    public List<UmsMemberReceiveAddress> findMemberAddressByMemberId(Long id) {
        return memberReceiveAddressMapper.findMemberAddressByMemberId(id);
    }
}
