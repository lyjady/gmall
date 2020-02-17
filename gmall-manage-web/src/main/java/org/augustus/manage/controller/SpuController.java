package org.augustus.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.augustus.bean.PmsBaseSaleAttr;
import org.augustus.bean.PmsProductImage;
import org.augustus.bean.PmsProductInfo;
import org.augustus.service.SpuService;
import org.csource.common.MyException;
import org.csource.fastdfs.StorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @Autowired
    private StorageClient storageClient;

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
    public String uploadImage(@RequestParam("file") MultipartFile multipartFile) throws IOException, MyException {
        // TODO: 2020/2/13 保存到fastdfs
        String filename = multipartFile.getOriginalFilename();
        System.out.println(filename.substring(filename.indexOf(".") + 1));
        String[] strings = storageClient.upload_file(multipartFile.getBytes(), filename.substring(filename.indexOf(".") + 1), null);
        return "http://192.168.0.110:8888/" + strings[0] + "/" + strings[1];
    }

    @RequestMapping("/saveSpuInfo")
    public String saveSpuInfo(@RequestBody PmsProductInfo productInfo) {
        return spuService.saveSpuInfo(productInfo);
    }
}
