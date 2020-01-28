package application;

import javafx.beans.property.SimpleStringProperty;

public class Outsourced extends Part {

    private SimpleStringProperty companyName;
    
    /**
     * Testing ctor
     */
    public Outsourced() {
    	super(0, "testing outsourced", 0, 0, 0, 1);
    	this.companyName = new SimpleStringProperty("testing");
    }
    
    public Outsourced(String name, double price, int stock, int min, int max, String companyName) {
        super(++partCount, name, price, stock, min, max);
        this.companyName = new SimpleStringProperty(companyName);
    }

    public String getCompanyName() {
        return companyName.get();
    }

    public void setCompanyName(String companyName) {
        this.companyName.set(companyName);
    }
}
