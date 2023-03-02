package org.epsi.models;

import jakarta.persistence.Entity;

@Entity(name="fish")
public class Fish extends Animal{
    private FishLivEnv livingEnv;
}
