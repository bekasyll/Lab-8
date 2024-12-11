package com.example.searchphoto2.service;

import com.example.searchphoto2.model.Photo;
import com.example.searchphoto2.repository.PhotoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class PhotoService {

    private static final String UPLOAD_DIR = "src/main/resources/static/images/";

    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Photo uploadPhoto(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        Path filePath = Paths.get(UPLOAD_DIR + fileName);
        Files.write(filePath, file.getBytes());

        Photo photo = new Photo();
        photo.setFileName(fileName);
        photo.setImageLink("/images/" + fileName);
        return photoRepository.save(photo);
    }
}
