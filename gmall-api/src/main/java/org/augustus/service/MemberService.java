package org.augustus.service;

import org.augustus.bean.UmsMember;
import org.augustus.bean.UmsMemberReceiveAddress;

import java.util.List;

/**
 * @author LinYongJin
 * @date 2020/2/5 18:05
 */
public interface MemberService {

    List<UmsMember> findAll();

    List<UmsMemberReceiveAddress> findMemberAddressByMemberId(Long id);
}
