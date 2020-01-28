package application;

import javafx.beans.property.SimpleIntegerProperty;

public class InHouse extends Part {

    private SimpleIntegerProperty machineID;
    
    /**
     * Testing ctor
     */
    public InHouse() {
    	super(0, "testing", 0, 0, 0, 1);
    	this.machineID = new SimpleIntegerProperty(0);
    }
    
    public InHouse(String name, double price, int stock, int min, int max, int machineID) {
        super(++partCount, name, price, stock, min, max);
        this.machineID = new SimpleIntegerProperty(machineID);
    }

    public void setMachineID(int machineID){
        this.machineID.set(machineID);
    }

    public int getMachineID(){
        return this.machineID.get();
    }

}
