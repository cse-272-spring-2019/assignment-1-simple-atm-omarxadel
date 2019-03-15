package atm;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;;

public class MainClass extends Application  {
	
	
	public static void main(String[] args)  {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage1) throws Exception {
		
		primaryStage1.setTitle("ATM");
		LoginScreen loginscreen = new LoginScreen(primaryStage1);
		HomeScreen home = new HomeScreen(primaryStage1);
		DepositScreen deposit = new DepositScreen(primaryStage1);
		WithdrawScreen withdraw = new WithdrawScreen(primaryStage1);
		loginscreen.prepareLogin();
		home.prepareScene();
		deposit.prepareScreen();
		withdraw.prepareScreen();
		loginscreen.setLoginScreen(home);
		home.setLoginScreen(loginscreen);
		home.setDepositScreen(deposit);
		home.setWithdrawScreen(withdraw);
		deposit.setHomeScreen(home);
		withdraw.setHomeScreen(home);
		
		
		primaryStage1.setScene(loginscreen.getScene());
		primaryStage1.show();
		
	}

	
}
