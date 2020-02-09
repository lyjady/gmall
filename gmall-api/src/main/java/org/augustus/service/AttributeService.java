package org.augustus.service;

import org.augustus.bean.PmsBaseAttrInfo;

import java.util.List;

/**
 * @author LinYongJin
 * @date 2020/2/9 16:49
 */
public interface AttributeService {

    List<PmsBaseAttrInfo> attrInfoList(Integer catalog3Id);

    String saveAttrInfo(PmsBaseAttrInfo attrInfo);
}
