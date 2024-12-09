package com.he.service;

import jakarta.annotation.Resource;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author He
 * @version 1.0
 * @Date 2024/11/26 22:11
 * @Desc
 */
@Service
public class TesseractService {

    @Resource
    private ResourceLoader resourceLoader;

    public String getImageText(MultipartFile file) {
        Tesseract tesseract = new Tesseract();
        try {
            org.springframework.core.io.Resource resource = resourceLoader.getResource("classpath:tessdata");
            tesseract.setDatapath(resource.getFile().getPath());
            tesseract.setLanguage("chi_sim");
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            String result = tesseract.doOCR(bufferedImage);
            System.out.println("识别结果: ");
            return result;
        } catch (TesseractException e) {
            System.err.println("OCR 出错: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("文件加载出错: " + e.getMessage());
        }
        return "";
    }


}
