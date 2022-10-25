package com.ey.models;

import javax.persistence.*;

@Entity
@Table(name = "ranks")
public class Ranks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id", updatable = false)
    private String id;

    @Column(nullable = false)
    private String permission;

    public Ranks() {}

    public Ranks(String id, String permission) {
        this.id = id;
        this.permission = permission;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Ranks{" +
                "id=" + id +
                ", permission='" + permission + '\'' +
                '}';
    }
}
