package org.augustus.manage.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.augustus.bean.PmsBaseAttrInfo;
import org.augustus.bean.PmsBaseAttrValue;
import org.augustus.manage.mapper.PmsBaseAttrInfoMapper;
import org.augustus.manage.mapper.PmsBaseAttrValueMapper;
import org.augustus.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author LinYongJin
 * @date 2020/2/9 16:52
 */
@Service
@Component
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    private PmsBaseAttrInfoMapper attrInfoMapper;

    @Autowired
    private PmsBaseAttrValueMapper attrValueMapper;

    @Override
    public List<PmsBaseAttrInfo> attrInfoList(Integer catalog3Id) {
        return attrInfoMapper.findAttrInfoById(catalog3Id);
    }

    @Override
    public String saveAttrInfo(PmsBaseAttrInfo attrInfo) {
        try {
            attrInfoMapper.insertSelective(attrInfo);
            List<PmsBaseAttrValue> attrValueList = attrInfo.getAttrValueList();
            attrValueList.forEach(value -> {
                value.setAttrId(attrInfo.getId());
                attrValueMapper.insertSelective(value);
            });
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueList(Long attrId) {
        return attrValueMapper.getAttrValueList(attrId);
    }
}
