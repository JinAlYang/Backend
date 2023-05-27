package com.JinAlYang.searchPreset.domain;

import com.JinAlYang.member.domain.Member;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @ManyToOne
    @JoinColumn(name = "member_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member member;
}
