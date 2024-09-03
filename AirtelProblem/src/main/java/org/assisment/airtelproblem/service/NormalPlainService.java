package org.assisment.airtelproblem.service;

import org.assisment.airtelproblem.domain.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NormalPlainService implements PlainService {
    @Autowired
    @Qualifier("nP")
    Plan plan;

    @Override
    public Boolean registerPlan(Integer data, Integer duration, String speed, String calls) {
        plan.createPlan(data, duration, speed, calls);
        return plan.savePlanDetails();
    }

    @Override
    public Plan getNewNormalPlan() {
        return plan;
    }
}
