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
@RequestMapping("/albums")
@AllArgsConstructor
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok(Optional.of(albumService.getAll()).orElse(Collections.emptyList()));
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
    public ResponseEntity save(@RequestParam("title") String title, @RequestParam("pictures") List<MultipartFile> pictures){
        return ResponseEntity.ok(albumService.createAlbum(title, pictures));
    }

    @DeleteMapping("/{album_id}")
    public ResponseEntity delete(@PathVariable("album_id") Long id){
        if(albumService.deleteAlbum(id)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
