package com.JinAlYang.region.domain;


import com.JinAlYang.memberRegion.MemberRegion;
import com.JinAlYang.realEstate.domain.RealEstate;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "region")
@NoArgsConstructor
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "region_id")
    private Long id;

    @Column(name = "region_name")
    private String name;
    @Column(name = "region_represent_address")
    private String represent_address;

    @OneToMany(mappedBy = "region")
    private List<RealEstate> realEstateList;
}
