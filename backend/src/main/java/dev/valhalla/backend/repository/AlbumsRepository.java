package dev.valhalla.backend.repository;

import dev.valhalla.backend.models.Albums;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumsRepository extends CrudRepository<Albums, Long> {
}
