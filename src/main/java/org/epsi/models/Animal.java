package org.epsi.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "animal")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Date birth;
    @Column
    private String couleur;

    @ManyToOne(optional = false)
    private PetStore petStores;

    public Animal(Date birth, String couleur, PetStore petStores) {
        this.birth = birth;
        this.couleur = couleur;
        this.petStores = petStores;
    }

    public PetStore getPetStores() {
        return petStores;
    }

    public void setPetStores(PetStore petStores) {
        this.petStores = petStores;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", birth=" + birth +
                ", couleur='" + couleur + '\'' +
                ", petStores=" + petStores +
                '}';
    }
}
