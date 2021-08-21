package dev.valhalla.backend.repository;

import dev.valhalla.backend.models.Pictures;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PicturesRepository extends CrudRepository<Pictures, Long> {
}
