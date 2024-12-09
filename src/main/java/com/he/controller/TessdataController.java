package com.he.controller;

import com.he.service.TesseractService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author He
 * @version 1.0
 * @Date 2024/11/26 21:30
 * @Desc 图像OCR识别
 */
@RestController("/tessdata")
public class TessdataController {


    @Resource
    private TesseractService tesseractService;


    @Operation(description = "图像识别文字")
    @PostMapping("/textOCR")
    public String textOcr(MultipartFile file) {
        return tesseractService.getImageText(file);
    }

}
