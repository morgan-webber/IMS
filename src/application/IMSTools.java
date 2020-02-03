package application;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class IMSTools {

	public static boolean verifyTextFieldData(TextField txt) {
		if (txt.getText() == null || txt.getText().equals("")) {
			txt.setStyle("-fx-background-color: #FFCCCC");
			return false;
		}
		
		txt.setStyle(null);
		return true;
	}
	
	public static boolean confirmAction(String title, String header, String message){
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(message);
		alert.showAndWait();

		if (alert.getResult() == ButtonType.OK){
			return true;
		}
		else{
			return false;
		}
	}
	
}
