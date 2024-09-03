package org.assisment.airtelproblem.service;

import org.assisment.airtelproblem.domain.Plan;

public interface PlainService {
    public Boolean registerPlan(Integer data, Integer duration, String speed, String calls);

    public Plan getNewNormalPlan();
}
