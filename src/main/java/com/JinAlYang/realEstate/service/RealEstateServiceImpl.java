package com.JinAlYang.realEstate.service;

import com.JinAlYang.realEstate.domain.*;
import com.JinAlYang.realEstate.repository.RealEstateDetailRepository;
import com.JinAlYang.realEstate.repository.RealEstateRepository;
import com.JinAlYang.realEstate.web.dto.RealEstateCreateDto;
import com.JinAlYang.realEstate.web.dto.RealEstateDetailCreateDto;
import com.JinAlYang.realEstate.web.dto.RealEstateResponseDto;
import com.JinAlYang.region.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class RealEstateServiceImpl implements RealEstateService{

    private final RealEstateRepository realEstateRepository;
    private final RealEstateDetailRepository realEstateDetailRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Optional<RealEstate> createRealEstate(RealEstateCreateDto realEstateCreateDto) {

        RealEstateDetailCreateDto realEstateDetailCreateDto = realEstateCreateDto.getRealEstateDetailCreateDto();
        RealEstateDetail savedRealEstateDetail = realEstateDetailRepository.save(realEstateDetailCreateDto.toEntity());

        RealEstate realEstate = realEstateCreateDto.toEntity();
        realEstate.setRealEstateDetail(savedRealEstateDetail);

        return Optional.of(realEstateRepository.save(realEstate));
    }
    @Override
    public RealEstateResponseDto findRealEstateById(Long id) {
        Optional<RealEstate> optionalRealEstate = realEstateRepository.findById(id);

        if(!optionalRealEstate.isPresent())
            throw new IllegalArgumentException("해당 부동산 매물이 없습니다.");

        RealEstate realEstate = optionalRealEstate.get();
        return RealEstateResponseDto.builder()
                .id(realEstate.getId())
                .address(realEstate.getAddress())
                .latitude(realEstate.getLatitude())
                .longitude(realEstate.getLongitude())
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
    }

    public List<RealEstateResponseDto> findAllRealEstateResponseDtoByFilter(String location, String filter) {
        List<RealEstate> realEstateList = findAllRealEstateByFilter(location, filter);

        List<RealEstateResponseDto> realEstateResponseDtoList = new ArrayList<>();
        for(RealEstate realEstate : realEstateList) {
            realEstateResponseDtoList.add(findRealEstateById(realEstate.getId()));
        }

        return realEstateResponseDtoList;
    }

    /*
    location -> (%5F = _)
    filter -> (%2C = ,)
    filter key & value -> (%3A = :)
    filter value range -> (%7E = ~)
    */
    @Override
    @Transactional
    public List<RealEstate> findAllRealEstateByFilter(String location, String filter) {
        Specification<RealEstate> spec;
        // locationBox = [bottom, left, top, right] need to Double
        String[] locationBox = location.split("_");

        spec = Specification.where(RealEstateSpecification.betweenLocation("latitude", locationBox[0], locationBox[2]))
                .and(RealEstateSpecification.betweenLocation("longitude", locationBox[1], locationBox[3]));

        if(filter.compareTo("null") == 0) return realEstateRepository.findAll(spec);

        // map = <key, val>, if key="deposit" then val->rangeParsing(val)
        Map<String, String> filterMap = getUrlParsing(filter);
        for(Map.Entry<String, String> elem : filterMap.entrySet()) {
            if(elem == null) break;
            String key = elem.getKey();
            if(key.compareTo("region") == 0) {
                spec = spec.and(RealEstateSpecification.equalRegion(elem.getValue()));
            }
            else if(key.compareTo("monthlyRentType") == 0) {
                MonthlyRentType temp = null;
                if(elem.getValue().compareTo("MONTHLY") == 0) temp = MonthlyRentType.MONTHLY;
                else if(elem.getValue().compareTo("JEONSE") == 0) temp = MonthlyRentType.JEONSE;
                spec = spec.and(RealEstateSpecification.equalMonthlyRentType(temp));
            }
            else if(key.compareTo("spaceType") == 0) {
                SpaceType temp = null;
                if(elem.getValue().compareTo("원룸") == 0) temp = SpaceType.ONEROOM;
                else if(elem.getValue().compareTo("투룸") == 0) temp = SpaceType.TWOROOM;
                else if(elem.getValue().compareTo("오피스텔") == 0) temp = SpaceType.OFFICETEL;
                spec = spec.and(RealEstateSpecification.equalSpaceType(temp));
            }
            else if(key.compareTo("floorType") == 0) {
                FloorType temp = null;
                if(elem.getValue().compareTo("옥탑") == 0) temp = FloorType.ROOFTOP;
                else if(elem.getValue().compareTo("지상층") == 0) temp = FloorType.GROUND;
                else if(elem.getValue().compareTo("반지하") == 0) temp = FloorType.UNDER;
                spec = spec.and(RealEstateSpecification.equalFloorType(temp));
            }
            else if(key.compareTo("deposit") == 0 || key.compareTo("monthlyPayment") == 0 || key.compareTo("roomSize") == 0) {
                String[] rangeString = rangeParsing(elem.getValue());
                spec = spec.and(RealEstateSpecification.betweenRange(key, Integer.parseInt(rangeString[0]), Integer.parseInt(rangeString[1])));
            }
            else { //detail option
                spec = spec.and(RealEstateSpecification.equalBoolean(key, Boolean.parseBoolean(elem.getValue())));
            }
        }
        List<RealEstate> result = realEstateRepository.findAll(spec);
        return result;
    }

    public Map<String, String> getUrlParsing(String filter) {
        // format -> key1:val1,key2:val2
        Map<String, String> map = new HashMap<>();
        String[] params = filter.split(",");
        for(String param : params) {
            String name = param.split(":")[0].replace("\"", "");
            String value = param.split(":")[1];
            map.put(name, value);
        }

        return map;
    }

    public String[] rangeParsing(String value) {
        //remove '[',']' and split by '~'
        String val = value.replace("[", "").replace("]", "");
        return val.split("~");
    }
}
