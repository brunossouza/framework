package dev.valhalla.backend.services;

import dev.valhalla.backend.models.Album;
import dev.valhalla.backend.models.Picture;
import dev.valhalla.backend.repository.AlbumRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@AllArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final PictureService pictureService;

    public Iterable<Album> getAll(){
        return albumRepository.findAll();
    }

    public Album save(Album album) {
        return albumRepository.save(album);
    }

    public Album createAlbum(String title, List<MultipartFile> pictures) {
        Album album = new Album();
        album.setTitle(title);
        List<Picture> plist = pictureService.createPicturesList(pictures);
        album.setPictures(plist);
        return save(album);
    }

    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }
}
