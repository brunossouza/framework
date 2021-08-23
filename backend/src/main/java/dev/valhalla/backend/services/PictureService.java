package dev.valhalla.backend.services;

import dev.valhalla.backend.models.Picture;
import dev.valhalla.backend.repository.PicturesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class PictureService {

    private final PicturesRepository picturesRepository;

    public Picture save(Picture picture){
        return picturesRepository.save(picture);
    }

    public List<Picture> createPicturesList(List<MultipartFile> pictures) {
        List<Picture> pictureList = new ArrayList<>();
        pictures.forEach(p -> {
            try {

                Picture picture = new Picture();
                picture.setExtension(p.getOriginalFilename().substring(p.getOriginalFilename().lastIndexOf(".")));
                picture.setPath(UUID.randomUUID().toString() + picture.getExtension());
                picture.setSize(p.getSize());

                if(!Files.exists(Path.of("uploads"))) Files.createDirectory(Path.of("uploads"));
                Files.copy(p.getInputStream(), Path.of("uploads",picture.getPath()));

                pictureList.add(save(picture));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return pictureList;
    }
}