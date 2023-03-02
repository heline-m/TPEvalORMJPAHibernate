package org.epsi.models;

import jakarta.persistence.Entity;

@Entity(name="cat")
public class Cat extends Animal{
    private String chipid;
}
