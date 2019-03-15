package atm;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DepositScreen {
	Scene scene;
	LoginScreen login;
	Stage stage;
	HomeScreen home;
	
	public DepositScreen(Scene scene) {
		this.scene=scene;
	}
	
	public DepositScreen(Stage stage) {
		this.stage=stage;
	}
	
	
	public void prepareScreen() {
	
	home = new HomeScreen(stage);
	
	Label label = new Label("Enter the desired amount of deposit");
	Label labelresult = new Label();
	TextField deposit = new TextField();
	Button submit = new Button("Submit >>");
	Button back = new Button("<< Back");
	GridPane grid = new GridPane();
	grid.setMinSize(500, 500);
	grid.setVgap(10);
	grid.setHgap(5);
	grid.setAlignment(Pos.CENTER);
	grid.add(label, 1, 0);
	grid.add(deposit, 1, 1);
	grid.add(submit, 2, 2);
	grid.add(back, 0, 2);
	grid.add(labelresult, 1, 3);
	
	submit.setStyle("-fx-background-color: darkcyan; -fx-text-fill: white ");
	back.setStyle("-fx-background-color: darkcyan ; -fx-text-fill: white");
	label.setStyle("-fx-font: normal normal 13px 'sans-serif'");
	grid.setStyle("-fx-background-color: cornsilk");
	
	scene = new Scene(grid, 600, 400);
	
	
	
	submit.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			int hold = Integer.parseInt(deposit.getText());
			home.transaction.deposit(hold);
			labelresult.setText("SUCCESS! " + hold + " WAS ADDED TO YOUR BALANCE.");
		}
	});
	
	back.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			stage.setScene(home.getScene());
		}
	});
	
	}
	public Scene getScene() {
		return this.scene;
	}
	public void setHomeScreen(HomeScreen home) {
		this.home=home;
	}
}
