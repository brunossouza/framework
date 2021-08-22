package dev.valhalla.backend.services;

import dev.valhalla.backend.models.Albums;
import dev.valhalla.backend.models.Pictures;
import dev.valhalla.backend.repository.AlbumsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@AllArgsConstructor
public class AlbumService {

    private final AlbumsRepository albumsRepository;
    private final PicturesService picturesService;

    public Iterable<Albums> getAll(){
        return albumsRepository.findAll();
    }

    public Albums save(Albums album) {
        return albumsRepository.save(album);
    }

    public Albums createAlbum(String title, List<MultipartFile> pictures) {
        Albums album = new Albums();
        album.setTitle(title);
        List<Pictures> plist = picturesService.createPicturesList(pictures);
        album.setPictures(plist);
        return save(album);
    }
}
