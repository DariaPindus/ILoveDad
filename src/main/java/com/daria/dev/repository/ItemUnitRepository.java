package com.daria.dev.repository;

import com.daria.dev.model.Item;
import com.daria.dev.model.ItemUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemUnitRepository extends JpaRepository<ItemUnit, Long> {
}
