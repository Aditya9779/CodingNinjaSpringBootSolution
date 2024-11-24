package com.devtools.solution.actuator;

import com.devtools.solution.repo.BookDal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "stock")
public class CustomEndpoint2 {
    @Autowired
    private BookDal bookDal;

    @ReadOperation
    public Map<String, Integer> getBookQuantities() {
        Map<String, Integer> quantitiesMap = new HashMap<>();
        bookDal.findAll().forEach(book -> quantitiesMap.put(book.getTitle(), book.getQuantity()));
        return quantitiesMap;
    }
}
