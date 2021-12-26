package com.sip.Ams.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sip.Ams.entities.Provider;


@Repository
public interface ProviderRepository extends CrudRepository<Provider, Long> {
    @Query("FROM Provider p WHERE p.name like %?1%")
    List<Provider> findProviderByName(String nameProvider);
    
}