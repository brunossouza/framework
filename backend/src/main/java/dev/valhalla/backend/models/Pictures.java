package dev.valhalla.backend.models;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "picture")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pictures extends AbstractEntity{

    @Column
    @NotNull
    private String path;

    @Column
    private String extension;

    @Column
    private Long size;

}
