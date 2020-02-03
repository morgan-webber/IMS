package fxml;

import application.IMSTools;
import application.Inventory;
import application.Part;
import application.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ModifyProductController {

	@FXML TextField txtID;
	@FXML TextField txtName;
	@FXML TextField txtQuantity;
	@FXML TextField txtPrice;
	@FXML TextField txtMax;
	@FXML TextField txtMin;
	@FXML TextField txtPartSearch;
	
	@FXML TableColumn<Part, String> colAllPartsID;
	@FXML TableColumn<Part, String> colAllPartsName;
	@FXML TableColumn<Part, String> colAllPartsQuantity;
	@FXML TableColumn<Part, String> colAllPartsPrice;
	@FXML TableColumn<Part, String> colCurrentPartsID;
	@FXML TableColumn<Part, String> colCurrentPartsName;
	@FXML TableColumn<Part, String> colCurrentPartsQuantity;
	@FXML TableColumn<Part, String> colCurrentPartsPrice;
	
	@FXML Button btnAddPart;
	@FXML Button btnDelPart;
	@FXML Button btnSave;
	@FXML Button btnCancel;
	@FXML Button btnSearchPart;
	
	@FXML TableView<Part> tblAllParts;
	@FXML TableView<Part> tblCurrentParts;
	
	public static Product product;
	
	@FXML public void initialize() {
		
		// Populate our parts table
    	colAllPartsID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colAllPartsName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colAllPartsQuantity.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        colAllPartsPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        tblAllParts.setItems(Inventory.getInstance().getAllParts());
        
        // Populate our current parts table
        colCurrentPartsID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colCurrentPartsName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colCurrentPartsQuantity.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        colCurrentPartsPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        tblCurrentParts.setItems(product.getAllAssociatedParts());
        
        
        
        // Populate our text fields
        if (product != null) {
        	this.txtID.setText(String.valueOf(product.getID()));
            this.txtName.setText(String.valueOf(product.getName()));
            this.txtQuantity.setText(String.valueOf(product.getStock()));
            this.txtPrice.setText(String.valueOf(product.getPrice()));
            this.txtMax.setText(String.valueOf(product.getMax()));
            this.txtMin.setText(String.valueOf(product.getMin()));	
        }
        
	}
	
	@FXML public void btnAddPartClick() {
		Part part = tblAllParts.getSelectionModel().getSelectedItem();
		if (part != null) {
			product.addAssociatedParts(part);
		}
	}
	
	@FXML public void btnSearchPartClick() {
		
	}

	@FXML public void btnDelPartClick() {
		
	}
	
	@FXML public void btnSaveClick() {
		// Verify all fields have something in them
		boolean nameVerified = IMSTools.verifyTextFieldData(txtName);
		boolean qtyVerified = IMSTools.verifyTextFieldData(txtQuantity);
		boolean priceVerified = IMSTools.verifyTextFieldData(txtPrice);
		boolean maxVerified = IMSTools.verifyTextFieldData(txtMax);
		boolean minVerified = IMSTools.verifyTextFieldData(txtMin);
		
		if (!nameVerified || !qtyVerified || !priceVerified || !maxVerified || !minVerified ) {
			return;
		}
		
		// Copy all of our data into our object
		product.setName(txtName.getText());
		product.setStock(Integer.valueOf(txtQuantity.getText()));
		product.setPrice(Double.valueOf(txtPrice.getText()));
		product.setMax(Integer.valueOf(txtMax.getText()));
		product.setMin(Integer.valueOf(txtMin.getText()));
		
		// Add our product to the Inventory
		//Inventory.getInstance().addProduct(currentProduct);
		
		// Close the window
		btnCancelClick();
	}
	
	@FXML public void btnCancelClick() {
		((Stage) btnCancel.getScene().getWindow()).close();
	}
	
	public void searchPart() {
		
	}
	
	
}
