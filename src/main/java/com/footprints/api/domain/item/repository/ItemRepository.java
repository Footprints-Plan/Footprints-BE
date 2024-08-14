package com.footprints.api.domain.item.repository;

import com.footprints.api.domain.item.entity.Item;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByName(String name);
    List<Item> findByRank(Long rank);
}
