package dev.valhalla.backend.models;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "picture")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonAutoDetect
public class Picture extends AbstractEntity{

    @Column(nullable = false)
    private String path;

    @Column
    private String extension;

    @Column
    private Long size;

}
