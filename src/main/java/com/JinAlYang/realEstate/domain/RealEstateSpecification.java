package com.JinAlYang.realEstate.domain;

import com.JinAlYang.realEstate.web.dto.RealEstateResponseDto;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class RealEstateSpecification {
    //위도, 경도
    public static Specification<RealEstate> betweenLocation(String key, String start, String end) {
        return new Specification<RealEstate>() {
            @Override
            public Predicate toPredicate(Root<RealEstate> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.between(root.get(key), start, end);
            }
        };
    }
    //보증금, 월세, 방크기
    public static Specification<RealEstate> betweenRange(String key, int start, int end) {
        return new Specification<RealEstate>() {
            @Override
            public Predicate toPredicate(Root<RealEstate> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.between(root.get(key), start, end);
            }
        };
    }
    //지역
    public static Specification<RealEstate> equalRegion(String region) {
        return new Specification<RealEstate>() {
            @Override
            public Predicate toPredicate(Root<RealEstate> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(region).get("name"), region);
            }
        };
    }
    //매매유형
    public static Specification<RealEstate> equalMonthlyRentType(MonthlyRentType rentType){
        return new Specification<RealEstate>() {
            @Override
            public Predicate toPredicate(Root<RealEstate> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("monthlyRentType"), rentType);
            }
        };
    }
    //건물유형(방 개수)
    public static Specification<RealEstate> equalSpaceType(SpaceType spaceType){
        return new Specification<RealEstate>() {
            @Override
            public Predicate toPredicate(Root<RealEstate> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("spaceType"), spaceType);
            }
        };
    }
    //층
    public static Specification<RealEstate> equalFloorType(FloorType floorType){
        return new Specification<RealEstate>() {
            @Override
            public Predicate toPredicate(Root<RealEstate> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("Type"), floorType);
            }
        };
    }
    //all of details
    public static Specification<RealEstate> equalBoolean(String key, boolean status) {
        return new Specification<RealEstate>() {
            //all of Details
            @Override
            public Predicate toPredicate(Root<RealEstate> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("realEstateDetail").get(key), status);
            }
        };
    }
}
