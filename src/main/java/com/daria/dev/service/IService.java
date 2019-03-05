package com.daria.dev.service;

import com.daria.dev.model.IEntity;
import java.util.List;
import java.util.Optional;

public interface IService<E extends IEntity, ID > {
    E save(E entity);
    E update(E entity);
    E delete(E entity);
    E deleteById(ID id);
    List<E> findAll();
    Optional<E> findById(ID id);
}

