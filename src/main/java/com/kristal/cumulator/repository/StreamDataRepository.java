package com.kristal.cumulator.repository;

import com.kristal.cumulator.models.entities.StreamData;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface StreamDataRepository extends CrudRepository<StreamData,Long> {

    public List<StreamData> findByCreatedAtGreaterThan(Date createdAt);

    @Modifying
    Long deleteByCreatedAtBefore(Date createdAt);
}
