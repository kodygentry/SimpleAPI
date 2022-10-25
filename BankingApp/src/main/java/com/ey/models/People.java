package com.ey.models;


import javax.persistence.*;

@Entity
@Table(name = "people")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id", updatable = false)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "boolean DEFAULT true", nullable = false)
    private boolean delinquent;

    @OneToOne
    @JoinColumn(name = "rank_id")
    private Ranks rank;

    // @Column(nullable = false)
    private String password;

    // @Column(nullable = false)
    private String username;

    // @Column(nullable = false)
    private String phone;

    public People() {}

    public People(int id, String name, boolean delinquent, int rankId, String password, String username, String phone) {
        this.id = id;
        this.name = name;
        this.delinquent = delinquent;
        this.rank = rank;
        this.password = password;
        this.username = username;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDelinquent() {
        return delinquent;
    }

    public void setDelinquent(boolean delinquent) {
        this.delinquent = delinquent;
    }

    public Ranks getRankId() {
        return rank;
    }

    public void setRankId(Ranks rank) {
        this.rank = rank;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", delinquent=" + delinquent +
                ", rank=" + rank +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
