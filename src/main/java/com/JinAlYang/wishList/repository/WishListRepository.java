package com.JinAlYang.wishList.repository;

import com.JinAlYang.wishList.domain.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepository extends JpaRepository<WishList,Long> {
}
