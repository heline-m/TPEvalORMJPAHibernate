package org.epsi.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "animal")
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Date birth;
    @Column
    private String couleur;

    @ManyToOne(optional = false)
    private PetStore petStores;

    public PetStore getPetStores() {
        return petStores;
    }

    public void setPetStores(PetStore petStores) {
        this.petStores = petStores;
    }
}
