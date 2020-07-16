package com.task.discountcalculation.service;

import com.task.discountcalculation.dto.TenantDto;
import com.task.discountcalculation.entity.Tenant;
import java.util.Optional;

import java.util.List;

public interface ITenantService {

    Optional<Tenant> createTenant(TenantDto tenantDto);

    Optional<Tenant> getTenantById(Long id);

    Optional<List<Tenant>> getAllTenants();

    Optional<Tenant> updateTenant(Long id, TenantDto tenantDto);

    void deleteTenant(Long id);
}
