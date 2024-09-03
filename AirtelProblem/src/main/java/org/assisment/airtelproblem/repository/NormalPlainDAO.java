package org.assisment.airtelproblem.repository;

import org.assisment.airtelproblem.domain.NormalPlain;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Scope("singleton")
public class NormalPlainDAO implements DAO<NormalPlain> {
    private List<NormalPlain> normalPlainList = new ArrayList<>();

    @Override
    public int save(NormalPlain normalPlain) {
        int id = normalPlainList.size();
        normalPlain.setId(id);
        normalPlainList.add(normalPlain);
        return id;
    }

    // Additional methods for retrieving, updating, and deleting can be added here.
}
