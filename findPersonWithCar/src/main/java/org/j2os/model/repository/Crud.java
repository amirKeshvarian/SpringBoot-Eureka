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
public class Crud <T, I> {
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;
    public List<T> findAllByPersonId(Class<T> tClass, String childName){
        String entityName = tClass.getAnnotation(Entity.class).name();
        return entityManager
                .createQuery("select distinct (o) from " + entityName + " o left join fetch o." +childName + " child")
                .getResultList();
    }
}
