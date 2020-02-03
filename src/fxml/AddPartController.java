package fxml;


import application.InHouse;
import application.Inventory;
import application.Outsourced;
import application.Part;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddPartController {

	@FXML TextField txtName;
	@FXML TextField txtQuantity;
	@FXML TextField txtPrice;
	@FXML TextField txtMax;
	@FXML TextField txtMin;
	@FXML TextField txtBonusField;
	@FXML RadioButton radInHouse;
	@FXML RadioButton radOutsourced;
	
	@FXML Label lblBonusField;
	
	@FXML Button btnSave;
	@FXML Button btnCancel;
	
	@FXML public void btnCancelClick() {

		((Stage) btnCancel.getScene().getWindow()).close();
	}
	
	@FXML public void btnSaveClick() {
		
		// Gather info
		String name = txtName.getText();
		double price = Double.parseDouble(txtPrice.getText());
		int quantity = Integer.parseInt(txtQuantity.getText());
		int min = Integer.parseInt(txtMin.getText());
		int max = Integer.parseInt(txtMax.getText());
		
		//Create and add our part
		Part newPart;
		try {
			newPart = this.radInHouse.isSelected() ? 
					new InHouse(name, price, quantity, min, max, Integer.parseInt(txtBonusField.getText())) : 
					new Outsourced(name, price, quantity, min, max, txtBonusField.getText());
			Inventory.getInstance().addPart(newPart);
		}
		catch (Exception e) {
			// This will catch malformed fields
			e.printStackTrace();
		}
		
		// Exit the scene
		((Stage) btnCancel.getScene().getWindow()).close();
	}
	
	@FXML public void radInHouseClicked() {
		this.radOutsourced.setSelected(false);
		this.lblBonusField.setText("Machine ID");
		this.txtBonusField.setPromptText("Machine ID");
	}
	
	@FXML public void radOutsourcedClicked() {
		this.radInHouse.setSelected(false);
		this.lblBonusField.setText("Company Name");
		this.txtBonusField.setPromptText("Company Name");
	}
	
}
