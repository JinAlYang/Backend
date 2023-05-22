package com.JinAlYang.realEstate.domain;


import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "realEstate")
@NoArgsConstructor
public class RealEstate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "realEstate_id")
    private Long id;
}
