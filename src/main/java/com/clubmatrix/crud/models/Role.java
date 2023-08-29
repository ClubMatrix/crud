package com.clubmatrix.crud.models;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String slug;
    private String description;

    @ManyToMany
    @JoinTable(name = "role_permission", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<Permission> permissions = new HashSet<>();

    public Role() {
    }

    public Role(String name, String slug, String description) {
        this.name = name;
        this.slug = slug;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void addPermission(Permission permission) {
        this.permissions.add(permission);
    }
}
