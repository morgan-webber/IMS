package application;

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
	

	
}
