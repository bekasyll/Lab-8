package com.example.searchphoto2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import com.example.searchphoto2.model.Photo;
import com.example.searchphoto2.repository.PhotoRepository;
import com.example.searchphoto2.service.PhotoService;

@Controller
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/photos/upload")
    public String showUploadForm() {
        return "uploadForm";
    }

    @PostMapping("/photos/upload")
    public String uploadPhoto(MultipartFile file, Model model) {
        try {
            Photo photo = photoService.uploadPhoto(file);
            model.addAttribute("message", "Photo uploaded successfully: " + photo.getFileName());
        } catch (Exception e) {
            model.addAttribute("message", "Failed to upload photo: " + e.getMessage());
        }
        return "uploadForm";
    }
}
