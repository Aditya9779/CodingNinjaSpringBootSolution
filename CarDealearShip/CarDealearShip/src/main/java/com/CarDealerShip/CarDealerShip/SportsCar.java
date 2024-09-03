package com.CarDealerShip.CarDealerShip;

public class SportsCar implements Car {
    private String owner;
    Tyre addingTyre; //This is the normal naming function it's should be any thing

    public Tyre getAddingTyre() {
        return addingTyre;
    }

    public void setAddingTyre(Tyre addingTyre) {
        this.addingTyre = addingTyre;
    }


 /*   public SportsCar(Tyre inputTyre) {
        this.addingTyre = inputTyre;
    }*/

    @Override
    public String getInfo() {
        return "" + getOwnerName() + " Owns a SportsCar. " + addingTyre.getTyreInfo() + "";
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
