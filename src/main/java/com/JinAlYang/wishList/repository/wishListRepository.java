package com.JinAlYang.wishList.repository;

import com.JinAlYang.region.domain.Region;
import com.JinAlYang.wishList.domain.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface wishListRepository extends JpaRepository<WishList,Long> {
}
