package com.JinAlYang.realEstate.web.controller;

import com.JinAlYang.realEstate.service.RealEstateService;
import com.JinAlYang.realEstate.web.dto.RealEstateCreateDto;
import com.JinAlYang.realEstate.web.dto.RealEstateResponseDto;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/realEstate")
public class RealEstateController {
    private final RealEstateService realEstateService;

    @PostMapping("")
    public boolean createRealEstate(@RequestBody RealEstateCreateDto dto){
        return realEstateService.createRealEstate(dto).isPresent();
    }

    @GetMapping("/{id}")
    public RealEstateResponseDto getRealEstate(@PathVariable Long id, HttpServletResponse response) {
        return realEstateService.findRealEstateById(id);
    }

    @GetMapping("/bbox")
    public List<RealEstateResponseDto> getRealEstateListInMap(
            @RequestParam("location") String location,
            @RequestParam("filter") String filter,
            HttpServletResponse response
    ) {
        return realEstateService.findAllRealEstateResponseDtoByFilter(location, filter);
    }

}
