package dev.valhalla.backend.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "album")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Album extends AbstractEntity{

    @Column
    private String title;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Picture> pictures;

}
