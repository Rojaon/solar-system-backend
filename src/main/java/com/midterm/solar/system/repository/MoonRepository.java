package com.midterm.solar.system.repository;

import com.midterm.solar.system.model.Moon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoonRepository extends JpaRepository<Moon, String> {
}
