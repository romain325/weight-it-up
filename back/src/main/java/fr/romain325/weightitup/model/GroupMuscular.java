package fr.romain325.weightitup.model;

import javax.persistence.*;

@Entity
@Table(name = "groupe_musculaire")
public class GroupMuscular {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "img")
    private String img;

    public GroupMuscular() {

    }

    public GroupMuscular(String name, String img) {
        this.name = name;
        this.img = img;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}