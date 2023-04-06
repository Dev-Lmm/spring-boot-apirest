package com.devlmm.spring.apirest.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    @Column(length = 60)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_privileges",joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "privilege_id"), uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "privilege_id"})})
    private List<Privilege> privileges;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        privileges.forEach((privilege -> authorities.add(new SimpleGrantedAuthority(privilege.getName()))));

        return authorities;
    }

    @Override
    public String toString() {
        return "User{id=" + this.id + ",username='" + this.username + "',password=[SECRET],privileges=" + privileges.toString() + "}";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
