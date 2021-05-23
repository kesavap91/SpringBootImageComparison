package com.aws.imagecomparison.controller;

import com.aws.imagecomparison.config.CompareFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin
public class FaceController {

    @Value("${source_image}")
    public String UPLOADED_FOLDER;

    @Autowired
    private CompareFaces compareFaces;

    public FaceController(CompareFaces compareFaces) {
        this.compareFaces = compareFaces;
    }


    @GetMapping("/similarity")
    @ResponseBody
    public Object Similarity(@RequestParam(name = "image1") String image1, @RequestParam(name = "image2") String image2) throws IOException {
        return compareFaces.compareFaces(image1, image2);
    }

    @PostMapping("/compare")
    @ResponseBody
    public String fileUpload(@RequestParam("image1") MultipartFile file1, @RequestParam("image2") MultipartFile file2) {

        try {
            // Get the file1 and save it somewhere
            byte[] bytes1 = file1.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file1.getOriginalFilename());
            Files.write(path, bytes1);

            // Get the file2 and save it somewhere
            byte[] bytes2 = file2.getBytes();
            Path path2 = Paths.get(UPLOADED_FOLDER + file2.getOriginalFilename());
            Files.write(path2, bytes2);
            return compareFaces.compareFaces(file1.getOriginalFilename(), file2.getOriginalFilename()).toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}

