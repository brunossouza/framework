package dev.valhalla.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

}
