package com.daria.dev.service;

import com.daria.dev.model.IEntity;
import org.jvnet.hk2.annotations.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class AbstractService<E extends IEntity, Id> implements IService<E,Id> {

    JpaRepository<E, Id> repository;

    public void setRepository(JpaRepository<E, Id> repo){
        this.repository = repo;
    };

    @Transactional
    @Override
    public E save(E entity) {
        return repository.save(entity);
    }

    @Transactional
    @Override
    public E update(E entity) {
        return repository.save(entity);
    }

    @Transactional
    @Override
    public E delete(E entity) {
        repository.delete(entity);
        return entity;
    }

    @Transactional
    @Override
    public E deleteById(Id id) {
        E entity = repository.getOne(id);
        repository.delete(entity);
        return entity;
    }

    @Transactional
    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public Optional<E> findById(Id id) {
        return repository.findById(id);
    }
}

