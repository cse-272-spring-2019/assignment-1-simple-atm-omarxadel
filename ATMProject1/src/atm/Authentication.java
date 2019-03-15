package atm;

public class Authentication {
	
	Account A = new Account();
	
	public boolean validate(String CardNo) {
		String C = A.getCard();
			return CardNo.equals(C);
		}
}
