package com.JinAlYang.memberRegion;

import com.JinAlYang.member.domain.Member;
import com.JinAlYang.region.domain.Region;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "member_region")
@NoArgsConstructor
public class MemberRegion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_region_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
}
