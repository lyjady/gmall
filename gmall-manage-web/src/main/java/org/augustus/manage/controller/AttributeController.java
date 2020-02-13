package org.augustus.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.augustus.bean.PmsBaseAttrInfo;
import org.augustus.bean.PmsBaseAttrValue;
import org.augustus.service.AttributeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LinYongJin
 * @date 2020/2/9 16:54
 */
@RestController
@CrossOrigin
public class AttributeController {

    @Reference
    private AttributeService attributeService;

    @RequestMapping("/attrInfoList")
    public List<PmsBaseAttrInfo> attrInfoList(Integer catalog3Id) {
        return attributeService.attrInfoList(catalog3Id);
    }

    @PostMapping("/saveAttrInfo")
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo attrInfo) {
        return attributeService.saveAttrInfo(attrInfo);
    }

    @PostMapping("/getAttrValueList")
    public List<PmsBaseAttrValue> getAttrValueList(@RequestParam("attrId") Long attrId) {
        System.out.println(attrId);
        return attributeService.getAttrValueList(attrId);
    }
}
