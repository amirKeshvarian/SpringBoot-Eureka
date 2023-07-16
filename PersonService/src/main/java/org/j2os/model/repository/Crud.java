package org.j2os.model.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Scope("singleton")
public class Crud <T, I>{
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    public void insert(T t){
        entityManager.persist(t);
    }
    public T selectOne(Class<T> tClass, I id){
        return entityManager.find(tClass, id);
    }

}
