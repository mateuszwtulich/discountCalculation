package com.task.discountcalculation.service;

import com.task.discountcalculation.dto.TenantDto;
import com.task.discountcalculation.entity.Tenant;
import com.task.discountcalculation.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TenantService implements ITenantService {
    private TenantRepository tenantRepository;

    @Autowired
    public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Override
    public Optional<Tenant> createTenant(TenantDto tenantDto) {
        return Optional.of(tenantRepository.save(toTenant(tenantDto)));
    }

    @Override
    public Optional<Tenant> getTenantById(Long id) {
        return Optional.of(tenantRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public Optional<List<Tenant>> getAllTenants() {
        return Optional.of(tenantRepository.findAll());
    }

    @Override
    public Optional<Tenant> updateTenant(Long id, TenantDto tenantDto) {
        return Optional.of(tenantRepository.findById(id).map(oldTenant -> {
            oldTenant.setName(tenantDto.getName());
            oldTenant.setSurname(tenantDto.getSurname());
            oldTenant.setGroup(tenantDto.getGroup());
            oldTenant.setDateOfBirth(tenantDto.getDateOfBirth());
            return oldTenant;
        })).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public void deleteTenant(Long id) {
        tenantRepository.deleteById(id);
    }

    private Tenant toTenant(TenantDto tenantDto){
        if(tenantDto == null){
            return null;
        }

        Tenant tenant = new Tenant();
        tenant.setName(tenantDto.getName());
        tenant.setSurname(tenantDto.getSurname());
        tenant.setDateOfBirth(tenantDto.getDateOfBirth());
        tenant.setGroup(tenantDto.getGroup());
        return tenant;
    }
}
