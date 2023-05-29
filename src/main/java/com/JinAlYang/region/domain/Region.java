package com.JinAlYang.region.domain;


import com.JinAlYang.realEstate.domain.RealEstate;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "region")
@NoArgsConstructor
@Getter
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "region_id")
    private Long id;

    @Column(name = "region_name")
    private String name;
    @Column(name = "region_represent_address")
    private String road_address;

    @OneToMany(mappedBy = "region")
    private List<RealEstate> realEstateList;

    @Builder
    public Region(Long id, String name, String road_address, List<RealEstate> realEstateList) {
        this.id = id;
        this.name = name;
        this.road_address = road_address;
        this.realEstateList = realEstateList;
    }
}
