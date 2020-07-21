package com.newptit.freelib.repository;

import com.newptit.freelib.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, String> {
    public List<Resource> getResourcesByTypeOrderById(String type);
}
