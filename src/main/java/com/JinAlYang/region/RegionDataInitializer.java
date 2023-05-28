package com.JinAlYang.region;

import com.JinAlYang.region.domain.Region;
import com.JinAlYang.region.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegionDataInitializer implements CommandLineRunner {

    private final RegionRepository regionRepository;

    @Override
    public void run(String... args) throws Exception {
        // 초기 데이터 생성 및 저장
        Region region = Region.builder()
                    .id(1L)
                    .name("광진구")
                    .road_address("서울특별시 광진구 자양로 117 광진구청")
                    .build();

        regionRepository.save(region);
    }
}
