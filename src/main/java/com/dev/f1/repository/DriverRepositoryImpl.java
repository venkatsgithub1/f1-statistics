package com.dev.f1.repository;

import com.dev.f1.model.DriverWithIdAndNameVO;
import com.dev.f1.utils.Queries;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class DriverRepositoryImpl {
    private final EntityManager entityManager;
    private static final String PERCENTAGE = "%";

    public DriverRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<DriverWithIdAndNameVO> findDriversWithIdAndName(String token) {
        TypedQuery<DriverWithIdAndNameVO> query = entityManager.createQuery(Queries
                .DRIVERS_WITH_ID_AND_NAMES_QUERY.query, DriverWithIdAndNameVO.class);
        query.setParameter("token", PERCENTAGE + token + PERCENTAGE);
        return query.getResultList();
    }
}
