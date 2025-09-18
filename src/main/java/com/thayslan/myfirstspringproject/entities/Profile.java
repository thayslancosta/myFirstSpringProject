package com.thayslan.myfirstspringproject.entities;

import jakarta.persistence.*;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String cpf;

    @OneToOne(mappedBy = "profile", fetch = FetchType.LAZY)
    Client client;

    public Profile() {
    }

    public Profile(String name, String address, String cpf) {
        this.name = name;
        this.address = address;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
