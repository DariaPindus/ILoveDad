package com.daria.dev.service;

import com.daria.dev.model.Item;
import com.daria.dev.model.ItemUnit;
import com.daria.dev.model.size.GeneralSize;
import com.daria.dev.repository.ItemRepository;
import com.daria.dev.repository.ItemUnitRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ItemService extends AbstractService<Item, Long> {

    ItemRepository repository;

    @Autowired
    private ItemUnitRepository unitsRepository;

    @Autowired
    public ItemService(ItemRepository repository)
    {
        this.repository = repository;
        setRepository(repository);
    }

    @PostConstruct
    @Transactional
    public void init(){
        if (repository.findAll().isEmpty()){
            Item item = new Item("Test 1", 123.2);
            Item saved1 = repository.save(item);

            List<ItemUnit> itemUnits = new ArrayList<>();
            itemUnits.add(new ItemUnit(item, "white", GeneralSize.S, 2));
            itemUnits.add(new ItemUnit(item, "black", GeneralSize.M, 1));
            List<ItemUnit> resUnits1 = unitsRepository.saveAll(itemUnits);


            Item item2 = new Item("Test 2", 543.2);
            Item saved2 = repository.save(item2);

            List<ItemUnit> itemUnits2 = new ArrayList<>();
            itemUnits2.add(new ItemUnit(item2, "white", GeneralSize.S, 0));
            itemUnits2.add(new ItemUnit(item2, "rose", GeneralSize.XS, 3));
            List<ItemUnit> resUnits2 = unitsRepository.saveAll(itemUnits2 );
        }
    }

}
