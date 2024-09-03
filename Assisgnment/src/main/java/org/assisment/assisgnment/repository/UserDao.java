package org.assisment.assisgnment.repository;

import org.assisment.assisgnment.domain.ImdbUser;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Scope("singleton")
public class UserDao implements DAO<ImdbUser> {
    List<ImdbUser> usersList = new ArrayList<ImdbUser>();

    @Override
    public int saveDetails(ImdbUser imdbUser) {
        int id = usersList.size();
        imdbUser.setUserId(id);
        usersList.add(imdbUser);
        System.out.println("saved details");
        return id;
    }

    @Override
    public Optional<ImdbUser> get(Integer id) {
      if(usersList.size()>0 || id!=null) {
          return Optional.of(usersList.get(id));
      }
      return Optional.empty();
    }
}
