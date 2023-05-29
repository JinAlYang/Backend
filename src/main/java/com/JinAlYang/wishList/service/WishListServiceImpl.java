package com.JinAlYang.wishList.service;

import com.JinAlYang.member.domain.Member;
import com.JinAlYang.member.repository.MemberRepository;
import com.JinAlYang.realEstate.domain.RealEstate;
import com.JinAlYang.realEstate.repository.RealEstateRepository;
import com.JinAlYang.realEstate.web.dto.RealEstateResponseDto;
import com.JinAlYang.wishList.domain.WishList;
import com.JinAlYang.wishList.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class WishListServiceImpl implements WishListService{

    private final MemberRepository memberRepository;
    private final RealEstateRepository realEstateRepository;
    private final WishListRepository wishListRepository;
    //최근 본 집 메소드
    @Override
    @Transactional(readOnly = true)
    public List<RealEstateResponseDto> findAllRecentHome(Long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if(!optionalMember.isPresent())
            throw new IllegalArgumentException("해당 멤버가 없습니다");

        Member member = optionalMember.get();
        Map<Long, WishList> wishLists = member.initializeOrGetWishList();

        List<RealEstateResponseDto> realEstateResponseDtoList = new ArrayList<>();

        Collection<WishList> wishListsValues = wishLists.values();
        for(WishList value : wishListsValues)
        {
            if(!value.isRecentHome_status())
                continue;
            RealEstate realEstate = value.getRealEstate();
            RealEstateResponseDto realEstateResponseDto = RealEstateResponseDto.builder()
                    .id(realEstate.getId())
                    .monthlyRentType(realEstate.getMonthlyRentType())
                    .deposit(realEstate.getDeposit())
                    .roomSize(realEstate.getRoomSize())
                    .spaceType(realEstate.getSpaceType())
                    .monthlyPayment(realEstate.getMonthlyPayment())
                    .occupancyPeriods(realEstate.getOccupancyPeriods())
                    .windowDirection(realEstate.getWindowDirection())
                    .builtDate(realEstate.getBuiltDate())
                    .realEstateDetail(realEstate.getRealEstateDetail())
                    .build();
            realEstateResponseDtoList.add(realEstateResponseDto);
        }
        return realEstateResponseDtoList;
    }

    @Override
    @Transactional
    public boolean addRecentHome(Long memberId, Long realEstateId) {
        Optional<RealEstate> optionalRealEstate = realEstateRepository.findById(realEstateId);
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if(!optionalRealEstate.isPresent())
            throw new IllegalArgumentException("해당 매물이 없습니다");
        else if(!optionalMember.isPresent())
            throw new IllegalArgumentException("해당 멤버가 없습니다");

        Member member = optionalMember.get();
        RealEstate realEstate = optionalRealEstate.get();
        Map<Long, WishList> wishLists = member.initializeOrGetWishList();
        if(wishLists.containsKey(realEstateId))
        {
            WishList tragetWishList = wishLists.get(realEstateId);
            if(!tragetWishList.isRecentHome_status())
                tragetWishList.setRecentHome_status(true);
        }
        else
        {
            WishList targetWishList = WishList.builder()
                    .member(member)
                    .realEstate(realEstate)
                    .build();
            targetWishList.setRecentHome_status(true);
            WishList save = wishListRepository.save(targetWishList);
            wishLists.put(realEstateId,save);
        }
        return true;
    }

    @Override
    @Transactional
    public boolean removeRecentHome(Long memberId, Long realEstateId) {
        Optional<RealEstate> optionalRealEstate = realEstateRepository.findById(realEstateId);
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if(!optionalRealEstate.isPresent())
            throw new IllegalArgumentException("해당 매물이 없습니다");
        else if(!optionalMember.isPresent())
            throw new IllegalArgumentException("해당 멤버가 없습니다");

        Member member = optionalMember.get();
        Map<Long, WishList> wishLists = member.getWishLists();
        if(!wishLists.containsKey(realEstateId))
            throw new IllegalArgumentException("해당 wishList가 없습니다");
        WishList targetWishList = wishLists.get(realEstateId);
        wishLists.get(realEstateId).setRecentHome_status(false);
        if(!targetWishList.isRecentHome_status() && !targetWishList.isZzimList_status())
        {
            member.getWishLists().remove(realEstateId);
            wishListRepository.deleteById(targetWishList.getId());
        }
        return true;
    }

    //찜한 집 메소드
    @Override
    @Transactional(readOnly = true)
    public List<RealEstateResponseDto> findAllZzimHome(Long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if(!optionalMember.isPresent())
            throw new IllegalArgumentException("해당 멤버가 없습니다");

        Member member = optionalMember.get();
        Map<Long, WishList> wishLists = member.initializeOrGetWishList();

        List<RealEstateResponseDto> realEstateResponseDtoList = new ArrayList<>();

        Collection<WishList> wishListsValues = wishLists.values();
        for(WishList value : wishListsValues)
        {
            if(!value.isZzimList_status())
                continue;
            RealEstate realEstate = value.getRealEstate();
            RealEstateResponseDto realEstateResponseDto = RealEstateResponseDto.builder()
                    .id(realEstate.getId())
                    .monthlyRentType(realEstate.getMonthlyRentType())
                    .deposit(realEstate.getDeposit())
                    .roomSize(realEstate.getRoomSize())
                    .spaceType(realEstate.getSpaceType())
                    .monthlyPayment(realEstate.getMonthlyPayment())
                    .occupancyPeriods(realEstate.getOccupancyPeriods())
                    .windowDirection(realEstate.getWindowDirection())
                    .builtDate(realEstate.getBuiltDate())
                    .realEstateDetail(realEstate.getRealEstateDetail())
                    .build();
            realEstateResponseDtoList.add(realEstateResponseDto);
        }
        return realEstateResponseDtoList;
    }

    @Override
    @Transactional
    public boolean addZzimHome(Long memberId, Long realEstateId) {

        Optional<RealEstate> optionalRealEstate = realEstateRepository.findById(realEstateId);
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if(!optionalRealEstate.isPresent())
            throw new IllegalArgumentException("해당 매물이 없습니다");
        else if(!optionalMember.isPresent())
            throw new IllegalArgumentException("해당 멤버가 없습니다");

        Member member = optionalMember.get();
        RealEstate realEstate = optionalRealEstate.get();
        Map<Long, WishList> wishLists = member.initializeOrGetWishList();
        if(wishLists.containsKey(realEstateId))
        {
            WishList tragetWishList = wishLists.get(realEstateId);
            if(!tragetWishList.isZzimList_status())
                tragetWishList.setZzimList_status(true);
        }
        else
        {
            WishList targetWishList = WishList.builder()
                    .member(member)
                    .realEstate(realEstate)
                    .build();
            targetWishList.setZzimList_status(true);
            WishList save = wishListRepository.save(targetWishList);
            wishLists.put(realEstateId,save);
        }
        return true;
    }

    @Override
    @Transactional
    public boolean removeZzimHome(Long memberId, Long realEstateId) {
        Optional<RealEstate> optionalRealEstate = realEstateRepository.findById(realEstateId);
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if(!optionalRealEstate.isPresent())
            throw new IllegalArgumentException("해당 매물이 없습니다");
        else if(!optionalMember.isPresent())
            throw new IllegalArgumentException("해당 멤버가 없습니다");

        Member member = optionalMember.get();
        Map<Long, WishList> wishLists = member.getWishLists();
        if(!wishLists.containsKey(realEstateId))
            throw new IllegalArgumentException("해당 wishList가 없습니다");
        WishList targetWishList = wishLists.get(realEstateId);
        wishLists.get(realEstateId).setZzimList_status(false);
        System.out.println(targetWishList.isRecentHome_status() + " " + targetWishList.isZzimList_status());
        if(!targetWishList.isRecentHome_status() && !targetWishList.isZzimList_status())
        {
            System.out.println(targetWishList.getId());
            member.getWishLists().remove(realEstateId);
            wishListRepository.deleteById(targetWishList.getId());
        }
        return true;
    }
}
