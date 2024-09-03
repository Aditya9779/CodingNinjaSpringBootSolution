package org.assisment.airtelproblem.service;

import org.assisment.airtelproblem.domain.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CorporatePlainService implements PlainService {

    @Autowired
    @Qualifier("cP")
    Plan CorporativePlan;

    @Override
    public Boolean registerPlan(Integer data, Integer duration, String speed, String calls) {
        CorporativePlan.createPlan(data, duration, speed, calls);
        return CorporativePlan.savePlanDetails();
    }

    @Override
    public Plan getNewNormalPlan() {
        return CorporativePlan;
    }
}
