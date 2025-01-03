package com.meditrack.dataaggregation.interceptor;

import com.meditrack.dataaggregation.model.entity.Base;
import com.meditrack.dataaggregation.service.HeaderReadService;
import com.meditrack.dataaggregation.util.ApplicationUtil;
import jakarta.persistence.PrePersist;

public class EntityInterceptor {

    @PrePersist
    public void beforePersist(Object entity) {
        // Manipulate the entity before saving
        if (entity instanceof Base baseEntity) {
            final HeaderReadService headerReadService = ApplicationUtil.getBean(HeaderReadService.class);
            baseEntity.setHospitalId(headerReadService.getHospitalId());
            baseEntity.setCreatedBy(headerReadService.getUser());
        }
    }
}
