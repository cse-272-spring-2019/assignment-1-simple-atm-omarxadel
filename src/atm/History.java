package atm;


public class History {
		int i=0,j=0;
		String [] history = new String[5];
		
	public boolean empty(String [] H) {
		boolean flag=true;
		for(int i = 0 ; i > H.length ; i++) {
			if(H[i]!=null) flag=false;
		}
		return flag;
	}
	
	public boolean full(String [] H) {
			if(H[H.length-1]==null) {
				return false;	
			}
			return true;
		}
		
	public void pop(String [] H, String event) {
		for(int j=0;j<H.length-1;j++) {
			H[j]=H[j+1];
		}
		H[H.length-1]=event;
		
	}
	public void setJ(int n) {
		j=n;
	}
	
	public void push(String [] H, String event) {
		if(!full(H)) {
			H[i]= event;
			i++;
			if(i>4) i=4;
			j=i;
		}
		else { 
			pop(H,event);
			
		}
	}
	
	
	
	}
	
	
	
