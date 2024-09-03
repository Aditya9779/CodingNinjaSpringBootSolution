package com.CarDealerShip.CarDealerShip;

public class FamilyCar implements Car {
    private String owner;
    Tyre addingTyre;    //this name is the (properth name)
    public Tyre getAddingTyre() {
        return addingTyre;
    }

    public void setAddingTyre(Tyre addingTyre) {
        this.addingTyre = addingTyre;
    }

     //This is the normal naming function it's should be any thing

    /*This is the constructor method*/
    /*public FamilyCar(Tyre inputTyre) {
        this.addingTyre = inputTyre;
    }*/


    @Override
    public String getInfo() {
        return "" + getOwnerName() + " Owns a FamilyCar. " + addingTyre.getTyreInfo() + "";
    }
    @Override
    public void setOwnerName(String ownerName) {
        this.owner = ownerName;
    }

    @Override
    public String getOwnerName() {
        return owner;
    }
}
