package dev.valhalla.backend.repository;

import dev.valhalla.backend.models.Picture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PicturesRepository extends CrudRepository<Picture, Long> {
}
