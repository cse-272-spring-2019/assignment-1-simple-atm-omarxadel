package atm;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class WithdrawScreen {
	Scene scene;
	LoginScreen login;
	Stage stage;
	HomeScreen home;
	
	public WithdrawScreen(Stage primaryStage1) {
		stage=primaryStage1;
	}

	public void prepareScreen(){
	Label label = new Label("Enter the desired amount of deposit");
	Label labelresult = new Label();
	TextField withdraw = new TextField();
	Button submit = new Button("Submit >>");
	Button back = new Button("<< Back");
	GridPane grid = new GridPane();
	grid.setMinSize(500, 500);
	grid.setVgap(10);
	grid.setHgap(5);
	grid.setAlignment(Pos.CENTER);
	grid.add(label, 1, 0);
	grid.add(withdraw, 1, 1);
	grid.add(submit, 2, 2);
	grid.add(back, 0, 2);
	grid.add(labelresult, 1, 3);
	
	submit.setStyle("-fx-background-color: darkcyan; -fx-text-fill: white ");
	back.setStyle("-fx-background-color: darkcyan ; -fx-text-fill: white");
	label.setStyle("-fx-font: normal normal 13px 'sans-serif'");
	grid.setStyle("-fx-background-color: cornsilk");
	
	scene = new Scene(grid, 600, 400);
	home = new HomeScreen(stage);
	
	
	
	submit.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			
			int hold = Integer.parseInt(withdraw.getText());
			boolean v = home.transaction.withdrawl(hold);
			if(v)labelresult.setText("SUCCESS! " + hold + " WAS TAKEN FROM YOUR BALANCE.");
			
			else labelresult.setText("ERROR! " + hold + " IS MORE THAN WHAT YOU HAVE IN YOUR BALANCE.");
			}
	});
	
	back.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			stage.setScene(home.getScene());
		}
	});
	
	
}

	public void setHomeScreen(HomeScreen home) {
		this.home=home;
		
	}

	public Scene getScene() {
		return this.scene;
		}
	}
