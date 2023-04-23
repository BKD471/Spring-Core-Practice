package com.example.todo.todomanager.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Arrays;
import java.util.logging.Logger;

@RestController
@RequestMapping("/file/upload")
public class FileController {

    // private static final long SerialVersionUID = 10l;

    Logger loger = Logger.getLogger(String.valueOf(LoggerFactory.class));

    @PostMapping("/single")
    public String upload(@RequestParam("image") MultipartFile file) throws IOException {
        loger.info("" + file.getName());
        loger.info("" + file.getContentType());
        loger.info("" + file.getSize() / 1024.0);
        loger.info("" + file.getOriginalFilename());


        InputStream inputStream = file.getInputStream();
        try (FileOutputStream fileOutputStream = new FileOutputStream("validan.jpg")) {
            byte[] data = new byte[inputStream.available()];
            fileOutputStream.write(data);
        } catch (Exception e) {

        }
        return "file.txt";
    }

    @PostMapping("/multiple")
    public String multipleFiles(@RequestParam("files") MultipartFile[] files) {

        Arrays.stream(files).forEach(file -> {
            loger.info(file.getName());
            loger.info(file.getContentType());
            loger.info("" + file.getSize() / 1024.0);
            System.out.println("****************************************************");
        });
        return "files.txt";
    }


    @GetMapping("/serve-image")
    public void serverImage(HttpServletResponse response) {
        try {
            InputStream inputStream = new FileInputStream("images/maroon.jpg");
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            StreamUtils.copy(inputStream, response.getOutputStream());
        } catch (Exception e) {

        }
    }
}
