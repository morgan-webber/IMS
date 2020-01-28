package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Inventory
 *
 * Singleton class that represents the inventory of our client
 */
public class Inventory {

    private static Inventory instance = null;

    // our lists of parts and products
    private ObservableList<Part> allParts;
    private ObservableList<Product> allProducts;

    public Inventory(){
        allParts = FXCollections.observableArrayList();
        allProducts = FXCollections.observableArrayList();
    }

    /**
     * getInstance
     *
     * Singleton Ctor
     * @return the instance of the Inventory class
     */
    public static Inventory getInstance(){
        if (instance == null){
            instance = new Inventory();
        }

        return instance;
    }

    /**
     * addPart
     *
     * Adds a part to the inventory
     * @param newPart the part to add
     */
    public void addPart(Part newPart){
        this.allParts.add(newPart);
    }

    /**
     * addProduct
     *
     * Adds a product to the inventory
     * @param newProduct
     */
    public void addProduct(Product newProduct){
        this.allProducts.add(newProduct);
    }

    /**
     * lookupPart
     *
     * Looks up a part by the part ID
     * @param partID the part ID to search for
     * @return the part if it exists in the inventory, null if it doesn't
     */
    public Part lookupPart(int partID){
        for (Part part : allParts){
            if (part.getID() == partID){
                return part;
            }
        }

        return null;
    }

    /**
     * lookupProduct
     *
     * Looks up a product by the product ID
     * @param productID the product ID to search for
     * @return the product if it exists in the inventory, null if it doesn't
     */
    public Product lookupProduct(int productID){
        for (Product product : allProducts){
            if (product.getID() == productID){
                return product;
            }
        }

        return null;
    }

    /**
     * updatePart
     *
     * Moves the selected part to a new index in the list
     * @param idx the destination index
     * @param selectedPart the selected part
     */
    public void updatePart(int idx, Part selectedPart){
        this.allParts.set(idx, selectedPart);
    }

    /**
     * updateProduct
     *
     * Moves the selected product to a new index in the list
     * @param idx the destination index
     * @param selectedProduct the selected product
     */
    public void updateProduct(int idx, Product selectedProduct){
        this.allProducts.set(idx, selectedProduct);
    }

    /**
     * deletePart
     *
     * Deletes the part from the inventory
     * @param selectedPart the selected part
     */
    public void deletePart(Part selectedPart){
        this.allParts.remove(selectedPart);
    }

    /**
     * deleteProduct
     *
     * Deletes the product from the inventory
     * @param selectedProduct the selected product
     */
    public void deleteProduct(Product selectedProduct){
        this.allParts.remove(selectedProduct);
    }

    /**
     * getAllParts
     *
     * @return an ObservableList of parts in the inventory
     */
    public ObservableList<Part> getAllParts(){
        return this.allParts;
    }

    /**
     * getAllProducts
     *
     * @return an ObservableList of products in the inventory
     */
    public ObservableList<Product> getAllProducts(){
        return this.allProducts;
    }
}
