package com.example.searchphoto2.repository;

import com.example.searchphoto2.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
