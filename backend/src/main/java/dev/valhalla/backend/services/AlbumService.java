package dev.valhalla.backend.services;

import dev.valhalla.backend.models.Album;
import dev.valhalla.backend.models.Picture;
import dev.valhalla.backend.models.User;
import dev.valhalla.backend.repository.AlbumRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final PictureService pictureService;
    private final UserService userService;

    public Iterable<Album> getAll(){
        return albumRepository.findAll();
    }

    public Album save(Album album) {
        return albumRepository.save(album);
    }

    public Album createAlbum(String title, List<MultipartFile> pictures) {
        Album album = new Album();
        album.setTitle(title);
        album.setUser(userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
        List<Picture> plist = pictureService.createPicturesList(pictures);
        album.setPictures(plist);
        return save(album);
    }

    public boolean deleteAlbum(Long id) {
        User user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Album album = albumRepository.findById(id).get();
        if(user.equals(album.getUser())) {
            pictureService.delete(album.getPictures());
            albumRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
