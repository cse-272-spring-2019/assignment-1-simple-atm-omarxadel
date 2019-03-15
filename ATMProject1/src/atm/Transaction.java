package atm;

public class Transaction {
	
	History h = new History();
	Account Acc1 = new Account();
	int temp,historybalance;
	String[] history = new String[5];
	int cases;
	boolean flag=false;
	int i=0,count=0;

	
	public void deposit(int Amount) {
		cases=1;
		Acc1.setBalance(Amount);
		historybalance=Amount;
		addHistory();
	}
	
	public boolean withdrawl(int Amount) {
		cases=2;
		if(Amount<=Acc1.getBalance()) {
		Acc1.setBalance(-Amount);
		historybalance=Amount;
		addHistory();
		return true;
		}
		else return false;
	}
	
	public String display() {
		cases=3;
		temp=Acc1.getBalance();
		addHistory();
		return("Your balance is  "+temp);
		}
	

	
	public void addHistory() {
		if(cases==1) {
			h.push(history, "Deposit of "+historybalance);
		}
		else if (cases==2) {
			h.push(history, "Withdrawl of "+historybalance);
		}
		else if (cases==3) {
			h.push(history, "Balance inquiry with balance of "+Acc1.getBalance());
		}
		for(int i = 0 ; i < history.length ; i++) {
			if(history[i]==null) {
				this.i=i-1;
				break;
			}
			else if (i==4) this.i=4;
		}
		flag=true;
	}
	
	public String showPrev() {
		if(i==0) {
			return "The previous process was "+history[i];
		}
		else if(i>0 && i<5) {
			if(history[i]!=null) {
				if (flag) {
					flag=false;
				}
				else {
					flag=false;
					i--;
					}

				return "The previous process was "+history[i];
			}
		}
			return null;
	}
	
	public String showNext() {
		if(i>=0 && i<4) {
			if(history[i+1]!=null){
				return "The next process was "+history[++i];
			}
			else {
				for(int i = 0 ; i < history.length ; i++) {
				if(history[i]==null) {
					this.i=i-1;
					break;
				}
				else {
					this.i=4;
					flag=true;
				}
				
			}}
		}
		else {
				for(int i = 0 ; i < history.length ; i++) {
				if(history[i]==null) {
					this.i=i-1;
					break;
				}
				else {
					this.i=4;
					flag=true;
				}
				
			}}
		return null;
	
	}
	
	

	
	}
