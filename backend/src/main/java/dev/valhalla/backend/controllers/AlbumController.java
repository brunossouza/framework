package dev.valhalla.backend.controllers;

import dev.valhalla.backend.models.Albums;
import dev.valhalla.backend.services.AlbumService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/albums")
@AllArgsConstructor
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok(Optional.of(albumService.getAll()).orElse(Collections.emptyList()));
    }

    @PostMapping
    public ResponseEntity save(@RequestParam("title") String title, @RequestParam("pictures") List<MultipartFile> pictures){
        return ResponseEntity.ok(albumService.createAlbum(title, pictures));
    }

    @DeleteMapping("/{album_id}")
    public ResponseEntity delete(@PathVariable("album_id") Long id){
        albumService.deleteAlbum(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
