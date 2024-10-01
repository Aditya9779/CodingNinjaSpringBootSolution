package org.cn.cnkart.Service;

import jakarta.transaction.Transactional;
import org.cn.cnkart.Repository.ItemDetailsDal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ItemDetailsService {
    @Autowired
    ItemDetailsDal itemDetailsDal;

    public void remove(int id) {
        itemDetailsDal.delete(itemDetailsDal.findById(id).get());
    }
}
