package com.thayslan.myfirstspringproject.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String cpf;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JsonBackReference
    @JoinColumn(name = "client_id", unique = true, nullable = false)
    Client client;

}
