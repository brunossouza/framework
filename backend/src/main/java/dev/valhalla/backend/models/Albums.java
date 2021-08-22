package dev.valhalla.backend.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
public class Albums extends AbstractEntity{

    @Column
    private String title;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Pictures> pictures;

}
