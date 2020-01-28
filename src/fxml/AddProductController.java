package fxml;

import application.Inventory;
import application.Part;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AddProductController {

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
	
	@FXML public void initialize() {
		
		// Populate our parts table
    	colAllPartsID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colAllPartsName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colAllPartsQuantity.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        colAllPartsPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        tblAllParts.setItems(Inventory.getInstance().getAllParts());
        
	}
	
	@FXML public void btnSearchPartClick() {
		
	}

	@FXML public void btnDelPartClick() {
		
	}
	
	@FXML public void btnSaveClick() {
		
	}
	
	@FXML public void btnCancelClick() {
		
	}
	
	public void searchPart() {
		
	}
	
}
