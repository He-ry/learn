package com.he;

import jakarta.annotation.Resource;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;

import java.io.File;

@SpringBootTest
class LearnApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private ResourceLoader resourceLoader;

    @Test
    void testTextOCR() {
        Tesseract tesseract = new Tesseract();
        try {
            org.springframework.core.io.Resource resource = resourceLoader.getResource("classpath:tessdata");
            tesseract.setDatapath(resource.getFile().getPath());
            tesseract.setLanguage("chi_sim");
            File imageFile = new File("C:\\Users\\64272\\OneDrive\\图片\\1732629348327.png");
            String result = tesseract.doOCR(imageFile);
            System.out.println("识别结果: ");
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println("OCR 出错: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("文件加载出错: " + e.getMessage());
        }
    }

}
