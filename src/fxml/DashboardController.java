package fxml;

import application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DashboardController {

    /** Controls **/
    @FXML TableView<Part> tblParts;
    @FXML TableColumn<Part, String> colPartID;
    @FXML TableColumn<Part, String> colPartName;
    @FXML TableColumn<Part, String> colPartQty;
    @FXML TableColumn<Part, String> colPartPrice;
    
    @FXML TableView<Product> tblProducts;
    @FXML TableColumn<Product, String> colProductID;
    @FXML TableColumn<Product, String> colProductName;
    @FXML TableColumn<Product, String> colProductQty;
    @FXML TableColumn<Product, String> colProductPrice;
    
    @FXML Button btnAddPart;
    @FXML Button btnModPart;
    @FXML Button btnDeletePart;
    @FXML Button btnAddProduct;
    @FXML Button btnModProduct;
    @FXML Button btnDeleteProduct;
    @FXML Button btnSearchPart;
    @FXML Button btnSearchProduct;
    @FXML Button btnExit;
    
    @FXML TextField txtSearchPart;
    @FXML TextField txtSearchProduct;
    
    private Inventory inventory;

    public DashboardController(){

    }

    public void initialize() {
    	inventory = Inventory.getInstance();
    	
    	//********
    	// DEBUG
    	//********
    	inventory.addPart(new InHouse());
    	inventory.addPart(new Outsourced());
    	
    	// Setup Parts table
    	colPartID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colPartName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colPartQty.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        colPartPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        tblParts.setItems(inventory.getAllParts());       
        
        // Setup Products table
        colProductID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colProductName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colProductQty.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        colProductPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        tblProducts.setItems(inventory.getAllProducts());
    }
    
    @FXML public void btnAddPartClicked() {
    	presentStage("AddPart.fxml", "Add Part");
    }
    
    @FXML public void btnModPartClicked() {
    	
    	if (tblParts.getSelectionModel().getSelectedItem() != null) {
    		ModifyPartController.part = tblParts.getSelectionModel().getSelectedItem();
    		presentStage("ModifyPart.fxml", "Modify Part");	
    	}
    	
    }
    
    @FXML public void btnDeletePartClicked() {
        Part part = tblParts.getSelectionModel().getSelectedItem();
        if (part != null && IMSTools.confirmAction("Confirm Deletion", "Delete Part", "Delete part " + part.getName() + "?")){
            tblParts.getItems().remove(part);
        }
    }

    @FXML public void btnAddProductClicked() {
    	AddProductController.currentProduct = new Product();
    	presentStage("AddProduct.fxml", "Add Product");
    }
    
    @FXML public void btnModProductClicked() {
    	
    	if (tblProducts.getSelectionModel().getSelectedItem() != null) {
    		ModifyProductController.product = tblProducts.getSelectionModel().getSelectedItem(); 
    		presentStage("ModifyProduct.fxml", "Modify Product");	
    	}
    	
    }
    
    @FXML public void btnDeleteProductClicked() {

        Product product = tblProducts.getSelectionModel().getSelectedItem();
        if (product != null && IMSTools.confirmAction("Confirm Deletion", "Delete Part", "Delete product " + product.getName() + "?")){
            tblParts.getItems().remove(product);
        }
    }
    
    @FXML public void btnSearchPartClicked() {
        // Get the search term and build regex
        String term = txtSearchPart.getText();
        String pattern = ".*";
        if (term != null){
            for (char c : term.toCharArray()){
                pattern += c + ".*";
            }
        }

        Pattern r = Pattern.compile(pattern);
        Matcher m;
        ObservableList<Part> list = Inventory.getInstance().getAllParts();
        ObservableList<Part> matches = FXCollections.observableArrayList();
        for (Part part : list){
            m = r.matcher(part.getName());
            if (m.find()){
                matches.add(part);
            }
        }

        tblParts.setItems(matches);
    }
    
    @FXML public void btnSearchProductClicked() {
        // Get the search term and build regex
        String term = txtSearchPart.getText();
        String pattern = ".*";
        if (term != null){
            for (char c : term.toCharArray()){
                pattern += c + ".*";
            }
        }

        Pattern r = Pattern.compile(pattern);
        Matcher m;
        ObservableList<Product> list = Inventory.getInstance().getAllProducts();
        ObservableList<Product> matches = FXCollections.observableArrayList();
        for (Product product : list){
            m = r.matcher(product.getName());
            if (m.find()){
                matches.add(product);
            }
        }

        tblProducts.setItems(matches);
    }

    private void presentStage(String fxml, String title) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
    		Parent root = loader.load();
    		Stage stage = new Stage();
    	    stage.initModality(Modality.APPLICATION_MODAL);
    	    stage.setTitle(title);
    		stage.setScene(new Scene(root));
    		stage.show();
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void exit(){
        System.exit(0);
    }

}