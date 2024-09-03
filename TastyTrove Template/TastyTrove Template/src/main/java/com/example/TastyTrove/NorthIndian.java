package com.example.TastyTrove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("northIndian")
public class NorthIndian implements Recipe {

    private String name = "NorthIndian";
    private String userName;

    @Autowired
    @Qualifier("lentils")
    private Ingredients lentils;

    @Autowired
    @Qualifier("rice")
    private Ingredients rice;

    @Autowired
    @Qualifier("wheat")
    private Ingredients wheat;

    @Override
    public void setUserName(String name) {
        this.userName = name;
    }

    @Override
    public void setIngredients(String ingredients) {
        // You can choose which ingredient to set based on some logic
        if ("lentils".equalsIgnoreCase(ingredients)) {
            if (this.lentils != null) {
                this.lentils.setIngredient(ingredients);
            }
        } else if ("rice".equalsIgnoreCase(ingredients)) {
            if (this.rice != null) {
                this.rice.setIngredient(ingredients);
            }
        } else if ("wheat".equalsIgnoreCase(ingredients)) {
            if (this.wheat != null) {
                this.wheat.setIngredient(ingredients);
            }
        } else {
            System.out.println("Invalid ingredient choice or Ingredients object is not initialized.");
        }
    }

    @Override
    public void getDetails() {
        System.out.println("Hello user " + this.userName + ", here are the suggested dishes and ingredients:");

        if (this.lentils != null) {
            displayDetails(this.lentils);
        }
        if (this.rice != null) {
            displayDetails(this.rice);
        }
        if (this.wheat != null) {
            displayDetails(this.wheat);
        }
    }

    private void displayDetails(Ingredients ingredient) {
        String dishName = ingredient.getDishDetail();
        List<String> ingredientsList = ingredient.getIngredientsDetail();
        System.out.println("You can make " + dishName + " using the following ingredients:");
        for (int i = 0; i < ingredientsList.size(); i++) {
            System.out.println((i + 1) + ". " + ingredientsList.get(i));
        }
    }
}
