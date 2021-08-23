package dev.valhalla.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
public class User extends AbstractEntity{

    @NotEmpty
    private String name;

    @NotEmpty
    private String username;

    @NotEmpty
    @JsonIgnore
    private String password;

}
