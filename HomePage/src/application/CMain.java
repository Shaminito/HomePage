package application;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class CMain {

	@FXML
	ImageView boton_menu;
	
	@FXML
	AnchorPane darkBackground;
	
	@FXML
	AnchorPane menu_Lateral;
	
	TranslateTransition menu_LateralTransition;
	FadeTransition darkBackgroundTransition;
	
	public void initialize() {
		
		darkBackground.setVisible(false);
		
		menu_LateralTransition = new TranslateTransition(Duration.seconds(0.5),menu_Lateral);
		menu_LateralTransition.setByX(-300);
		menu_LateralTransition.play();
		
		boton_menu.setOnMouseClicked(event -> {

			darkBackground.setVisible(true);

			darkBackgroundTransition = new FadeTransition(Duration.seconds(0.5),darkBackground);
			darkBackgroundTransition.setFromValue(0);
			darkBackgroundTransition.setToValue(0.6);
			darkBackgroundTransition.play();
			
            menu_LateralTransition = new TranslateTransition(Duration.seconds(0.5),menu_Lateral);
            menu_LateralTransition.setByX(300);
            menu_LateralTransition.play();
        });

		darkBackground.setOnMouseClicked(event -> {

			darkBackgroundTransition = new FadeTransition(Duration.seconds(0.5),darkBackground);
			darkBackgroundTransition.setFromValue(0.6);
			darkBackgroundTransition.setToValue(0);
			darkBackgroundTransition.play();

			darkBackgroundTransition.setOnFinished(event1 -> {
            	darkBackground.setVisible(false);
            });

            menu_LateralTransition = new TranslateTransition(Duration.seconds(0.5),menu_Lateral);
            menu_LateralTransition.setByX(-300);
            menu_LateralTransition.play();
        });
	}
}