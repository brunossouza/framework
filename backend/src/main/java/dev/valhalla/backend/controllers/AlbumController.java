package dev.valhalla.backend.controllers;

import dev.valhalla.backend.services.AlbumService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/album")
@AllArgsConstructor
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok(Optional.of(albumService.getAll()).orElse(Collections.emptyList()));
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE )//TODO: verificar problema
    public ResponseEntity save(@RequestBody String title, @RequestBody List<MultipartFile> pictures){
        System.out.println(title);
        pictures.forEach(p->System.out.println(p.getOriginalFilename()));
        return ResponseEntity.ok(albumService.createAlbum(title, pictures));
    }

    @DeleteMapping("/{album_id}")
    public ResponseEntity delete(@PathVariable("album_id") Long id){
        albumService.deleteAlbum(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
