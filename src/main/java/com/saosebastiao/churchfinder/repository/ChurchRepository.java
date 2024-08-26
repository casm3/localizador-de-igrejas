package com.saosebastiao.churchfinder.repository;

import com.saosebastiao.churchfinder.entity.Church;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChurchRepository extends JpaRepository<Church, Long> {
}
