package dev.valhalla.backend.models;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "post")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Post extends AbstractEntity{

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String message;

}
