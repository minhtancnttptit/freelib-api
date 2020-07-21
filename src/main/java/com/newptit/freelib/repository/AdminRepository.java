package com.newptit.freelib.repository;

import com.newptit.freelib.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {
    public Admin findAdminById(String id);
}
