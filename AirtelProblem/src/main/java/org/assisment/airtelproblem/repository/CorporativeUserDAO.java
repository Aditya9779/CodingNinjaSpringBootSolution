package org.assisment.airtelproblem.repository;

import org.assisment.airtelproblem.domain.CorporativeUser;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Scope("singleton")
public class CorporativeUserDAO implements DAO<CorporativeUser> {
    private List<CorporativeUser> corporativeUserList = new ArrayList<>();

    @Override
    public int save(CorporativeUser corporativeUser) {
        int id = corporativeUserList.size();
        corporativeUser.setId(id);
        corporativeUserList.add(corporativeUser);
        return id;
    }

    // Additional methods for retrieving, updating, and deleting can be added here.
}
