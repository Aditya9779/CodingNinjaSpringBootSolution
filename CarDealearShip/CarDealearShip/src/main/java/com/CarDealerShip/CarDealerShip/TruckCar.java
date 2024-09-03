package com.CarDealerShip.CarDealerShip;

public class TruckCar implements Car {
    private String owner;
    Tyre addingTyre; //This is the normal naming function it's should be any thing

    public Tyre getAddingTyre() {
        return addingTyre;
    }

    public void setAddingTyre(Tyre addingTyre) {
        this.addingTyre = addingTyre;
    }


    /* public TruckCar(Tyre inputTyre) {
         this.addingTyre = inputTyre;
     }*/
    @Override


    public String getInfo() {
        return "" + getOwnerName() + " Owns a Truck. " + addingTyre.getTyreInfo() + "";
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
