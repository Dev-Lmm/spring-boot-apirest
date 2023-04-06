package com.devlmm.spring.apirest.models.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name="roles")
@RequiredArgsConstructor
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "privilege_role",joinColumns = @JoinColumn(name = "rol_id"), inverseJoinColumns = @JoinColumn(name = "privilege_id"), uniqueConstraints = {@UniqueConstraint(columnNames = {"rol_id", "privilege_id"})})
    private List<Privilege> privileges;

    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;
}
