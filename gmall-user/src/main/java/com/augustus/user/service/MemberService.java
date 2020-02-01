package com.augustus.user.service;

import com.augustus.user.bean.UmsMember;
import com.augustus.user.bean.UmsMemberReceiveAddress;

import java.util.List;

/**
 * @author LinYongJin
 * @date 2020/2/1 16:52
 */
public interface MemberService {

    List<UmsMember> findAll();

    UmsMember findById(Long id);

    List<UmsMemberReceiveAddress> findReceiveAddressById(Long id);
}
