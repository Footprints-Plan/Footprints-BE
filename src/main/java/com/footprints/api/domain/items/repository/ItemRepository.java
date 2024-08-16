package com.footprints.api.domain.items.repository;

import com.footprints.api.domain.items.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Items, Long> {
}
