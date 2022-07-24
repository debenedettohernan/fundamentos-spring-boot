package com.spring.fundamentos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post", nullable = false,unique = true)
    private Long id;
    @Column(name = "descripcion", length = 255)
    private String descripcion;

    public Post() {
    }

    public Post(String descripcion, User user) {
        this.descripcion = descripcion;
        this.user = user;
    }

    @ManyToOne
    @JsonBackReference
    private User user;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", user=" + user +
                '}';
    }
}
