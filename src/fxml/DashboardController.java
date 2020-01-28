package fxml;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import application.InHouse;
import application.Inventory;
import application.Part;
import application.Product;
import application.Outsourced;

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
    	
    }
    
    @FXML public void btnAddProductClicked() {
    	presentStage("AddProduct.fxml", "Add Product");
    }
    
    @FXML public void btnModProductClicked() {
    	presentStage("ModifyProduct.fxml", "Modify Product");
    }
    
    @FXML public void btnDeleteProductClicked() {
    	
    }
    
    @FXML public void btnSearchPartClicked() {
    	
    }
    
    @FXML public void btnSearchProductClicked() {
    	
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