package com.blog.CrudOperation.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
public class User {
//self
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column(name = "user_name", length = 100,nullable = false)
    public String name;

    @Column(nullable = false)
    public String email;
    public String password;
    @Column(length = 500)
    public String about;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts=new ArrayList<>();
}
