package atm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginScreen{
	
	Authentication authentication;
	Scene scene;
	HomeScreen Home;
	Stage stage;
	
	public LoginScreen(Stage stage) {
		this.stage=stage;
	}
	public void prepareLogin(){
		
		
		authentication = new Authentication();
		
		
		Label cardNumber = new Label("Card Number");
		TextField cardNumberIn = new TextField();
		Button submit = new Button("Enter");
		Label valid = new Label();
		GridPane grid = new GridPane();
		grid.setMinSize(500, 500);
		grid.setVgap(10);
		grid.setHgap(5);
		grid.setAlignment(Pos.CENTER);
		grid.add(cardNumber, 1, 0);
		grid.add(cardNumberIn, 1, 1);
		grid.add(submit, 1, 2);
		grid.add(valid, 1, 3);
		
	    scene = new Scene(grid, 600, 400);
	    
	    cardNumber.setStyle("-fx-font: normal lighter 14px 'sans-serif'");
	    submit.setStyle("-fx-background-color: darkcyan; -fx-text-fill: white");
	    grid.setStyle("-fx-background-color: cornsilk");
	    
	    submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String cardNumber = cardNumberIn.getText();
				boolean validB = authentication.validate(cardNumber);
				if(validB) {
					stage.setScene(Home.getScene());
				}
				else {
					valid.setText("WRONG CARD NUMBER .. PLEASE RE-ENTER");
					}
			}
	    });	
	 
	}	
		
	public Scene getScene() {
		return scene;
	    }
	public void setLoginScreen(HomeScreen home) {
		Home=home;
	}
	
}
	
	
	




