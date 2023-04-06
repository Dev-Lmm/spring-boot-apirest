package com.devlmm.spring.apirest.models.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name="privileges")
@RequiredArgsConstructor
public class Privilege implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_privileges",joinColumns = @JoinColumn(name = "privilege_id"), inverseJoinColumns = @JoinColumn(name = "user_id"), uniqueConstraints = {@UniqueConstraint(columnNames = {"privilege_id", "user_id"})})
    private List<User> users;

    @Override
    public String toString() {
        return "Privilege{id="+this.id+",name="+this.name+"}";
    }
}
