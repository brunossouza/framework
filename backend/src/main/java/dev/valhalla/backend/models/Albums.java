package dev.valhalla.backend.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

    @OneToMany
    private List<Pictures> pictures;

}
