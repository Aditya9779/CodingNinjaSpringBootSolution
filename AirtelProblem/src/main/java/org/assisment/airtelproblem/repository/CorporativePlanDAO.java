package org.assisment.airtelproblem.repository;

import org.assisment.airtelproblem.domain.CorporativePlan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Scope("singleton")
public class CorporativePlanDAO implements DAO<CorporativePlan> {
    private List<CorporativePlan> corporativePlanList = new ArrayList<CorporativePlan>();

    @Override
    public int save(CorporativePlan corporativePlan) {
        int id = corporativePlanList.size();
        corporativePlan.setId(id);
        corporativePlanList.add(corporativePlan);
        return id;
    }
}
