package atm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HomeScreen {
	Scene scene;
	LoginScreen login;
	Stage stage;
	Transaction transaction;
	DepositScreen d;
	WithdrawScreen w;
	
	public  HomeScreen(Stage stage) {
		this.stage=stage;
	}
	
	public void prepareScene() {
	Label welcome = new Label("Welcome!");
	Label screen = new Label();
	Button withdraw = new Button("Withdraw");
	Button deposit = new Button("Deposit");
	Button inquire = new Button("Balance Inquiry");
	Button next = new Button("Next Action >>");
	Button prev = new Button("<< Previous Action");
	Button log = new Button("Logout");
	GridPane grid = new GridPane();
	grid.setMinSize(500, 500);
	grid.setVgap(10);
	grid.setHgap(5);
	grid.setAlignment(Pos.CENTER);
	grid.add(welcome, 1, 0);
	grid.add(screen, 1, 1);
	grid.add(prev, 0, 1);
	grid.add(next, 2, 1);
	grid.add(inquire, 1, 2);
	grid.add(deposit, 1, 3);
	grid.add(withdraw, 1, 4);
	grid.add(log,1,5);
	scene = new Scene(grid, 600, 400);
	transaction = new Transaction();
	d = new DepositScreen(scene);
	
	welcome.setStyle("-fx-text-algigmnent: center; -fx-font: normal bold 14px 'sans-serif'; -fx-text-fill: darkcyan");
	prev.setStyle("-fx-background-color: darkcyan; -fx-text-fill: white");
	next.setStyle("-fx-background-color: darkcyan; -fx-text-fill: white");
	deposit.setStyle("-fx-background-color: darkcyan; -fx-text-fill: white");
	inquire.setStyle("-fx-background-color: darkcyan; -fx-text-fill: white");
	withdraw.setStyle("-fx-background-color: darkcyan; -fx-text-fill: white");
	log.setStyle("-fx-background-color: crimson; -fx-text-fill: white ");
	grid.setStyle("-fx-background-color: cornsilk");
	
	next.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			String printer = transaction.showNext();
			screen.setText(printer);
		}
	});	
	
	prev.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			String printer = transaction.showPrev();
			screen.setText(printer);
		}
	});	
	
	inquire.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			String printer = transaction.display();
			screen.setText(printer);
		}
	});	
	
	deposit.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			stage.setScene(d.getScene());
		}
	});	
		
	withdraw.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			stage.setScene(w.getScene());
		}
	});	
	
	log.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			stage.setScene(login.getScene());
		}
	});	
		
	}
	
	public Scene getScene() {
		return this.scene;
	    }
	public void setLoginScreen(LoginScreen login) {
		this.login=login;
	}
	public void setDepositScreen(DepositScreen deposit) {
		this.d=deposit;
	}
	public void setWithdrawScreen(WithdrawScreen withdraw) {
		this.w=withdraw;
	}
	
	}

