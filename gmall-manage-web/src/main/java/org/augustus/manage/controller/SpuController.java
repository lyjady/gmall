package org.augustus.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.augustus.bean.PmsBaseSaleAttr;
import org.augustus.bean.PmsProductImage;
import org.augustus.bean.PmsProductInfo;
import org.augustus.service.SpuService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author LinYongJin
 * @date 2020/2/13 16:18
 */
@RestController
@CrossOrigin
public class SpuController {

    @Reference
    private SpuService spuService;

    @RequestMapping("/spuList")
    public List<PmsProductInfo> getProductInfoList(Long catalog3Id) {
        return spuService.getSpuList(catalog3Id);
    }

    @RequestMapping("/spuImageList")
    public List<PmsProductImage> getSpuImageList(Long spuId) {
        return spuService.getSpuImageList(spuId);
    }

    @RequestMapping("/baseSaleAttrList")
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return spuService.baseSaleAttrList();
    }

    @RequestMapping("/fileUpload")
    public String uploadImage(@RequestParam("file") MultipartFile multipartFile) {
        // TODO: 2020/2/13 保存到fastdfs
        return "https://m.360buyimg.com/babel/jfs/t5137/20/1794970752/352145/d56e4e94/591417dcN4fe5ef33.jpg";
    }

    @RequestMapping("/saveSpuInfo")
    public String saveSpuInfo(@RequestBody PmsProductInfo productInfo) {
        return spuService.saveSpuInfo(productInfo);
    }
}
