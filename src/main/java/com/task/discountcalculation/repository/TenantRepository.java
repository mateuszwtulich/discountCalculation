package com.task.discountcalculation.repository;

import com.task.discountcalculation.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {
}
