package atm;

public class Account {
	private int Balance=0;
	private final String cardNo = "1234567";
	
	
	public int getBalance() {
		return Balance;
	}
	
	public void setBalance(int B) {
		Balance=Balance+B;
	}
	
	public String getCard() {
		return cardNo;
	}
		
}
