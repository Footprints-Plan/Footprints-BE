package com.footprints.api.domain.items.repository;

import com.footprints.api.domain.category.entity.Category;
import com.footprints.api.domain.items.entity.Items;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Items, Long> {
    List<Items> findByNameContaining(String name);

    List<Items> findAllByCategoryId(Long categoryId);
}
