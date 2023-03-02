package org.epsi.models;

import jakarta.persistence.*;

@Entity(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String number;
    @Column
    private String street;
    @Column
    private String zipCode;
    @Column
    private String city;
}
