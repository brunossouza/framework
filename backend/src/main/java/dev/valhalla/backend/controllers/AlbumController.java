package dev.valhalla.backend.controllers;

import dev.valhalla.backend.models.Albums;
import dev.valhalla.backend.services.AlbumService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/albums")
@AllArgsConstructor
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping
    public ResponseEntity getAlbums(){
        return ResponseEntity.ok(Optional.of(albumService.getAll()).orElse(Collections.emptyList()));
    }

    @PostMapping
    public ResponseEntity saveAlbum(@RequestParam("title") String title, @RequestParam("pictures") List<MultipartFile> pictures){
        return ResponseEntity.ok(albumService.createAlbum(title, pictures));
    }

}
