package org.assisment.airtelproblem.repository;

import org.assisment.airtelproblem.domain.NormalUser;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Scope("singleton")
public class NormalUserDAO implements DAO<NormalUser> {
    private List<NormalUser> normalUserList = new ArrayList<>();

    @Override
    public int save(NormalUser normalUser) {
        int id = normalUserList.size();
        normalUser.setId(id);
        normalUserList.add(normalUser);
        return id;
    }

    // Additional methods for retrieving, updating, and deleting can be added here.
}
