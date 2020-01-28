package application;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Product {

	public static int productCount = 0;
	
    private ObservableList<Part> associatedParts;
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleDoubleProperty price;
    private SimpleIntegerProperty stock;
    private SimpleIntegerProperty min;
    private SimpleIntegerProperty max;

    public Product() {
    	this(FXCollections.observableArrayList(), "testing", 0, 0, 0, 1);
    }
    
    public Product(ObservableList<Part> associatedParts, String name, double price, int stock, int min, int max) {
        this.associatedParts = associatedParts;
        this.id = new SimpleIntegerProperty(++productCount);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.stock = new SimpleIntegerProperty(stock);
        this.min = new SimpleIntegerProperty(min);
        this.max = new SimpleIntegerProperty(max);
    }

    public void addAssociatedParts(Part part){
        associatedParts.add(part);
    }

    public void deleteAssocaitedPart(Part associatedPart){
        associatedParts.remove(associatedPart);
    }

    public ObservableList<Part> getAllAssociatedParts() {
        return associatedParts;
    }

    public int getID() {
        return id.get();
    }

    public void setID(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public double getPrice() {
        return price.get();
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public int getStock() {
        return stock.get();
    }

    public void setStock(int stock) {
        this.stock.set(stock);
    }

    public int getMin() {
        return min.get();
    }

    public void setMin(int min) {
        this.min.set(min);
    }

    public int getMax() {
        return max.get();
    }

    public void setMax(int max) {
        this.max.set(max);
    }
}
