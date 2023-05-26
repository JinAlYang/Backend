package com.JinAlYang.searchPreset.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "searchPreset")
@NoArgsConstructor
public class SearchPreset {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "searchPreset_id")
    private Long id;

    @Column(name = "searchPreset_name")
    private String name;

    @Column(name = "searchPreset_url")
    private String url;

    @Column(name = "searchPreset_info")
    private String preset_info;
}
