package com.JinAlYang.searchPreset.domain;

import com.JinAlYang.member.domain.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.lang.Long;


@Getter
@Entity
@Table(name = "searchPreset")
@NoArgsConstructor
public class SearchPreset {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "searchPreset_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "searchPreset_name")
    private String name;

    @Column(name = "searchPreset_url")
    private String url;

    @Column(name = "searchPreset_info")
    private String preset_info;

    @Builder
    public SearchPreset(Member member, String name, String url, String preset_info) {
        this.member = member;
        this.name = name;
        this.url = url;
        this.preset_info = preset_info;
    }
}
