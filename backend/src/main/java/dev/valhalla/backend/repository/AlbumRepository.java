package dev.valhalla.backend.repository;

import dev.valhalla.backend.models.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {
}
