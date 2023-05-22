package com.JinAlYang.region.domain;


import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "region")
@NoArgsConstructor
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "region_id")
    private Long id;
}
