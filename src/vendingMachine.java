import java.util.ArrayList;

public class vendingMachine {
	ArrayList<product> productsAvailable = new ArrayList<product>();
	int numOf1;
	int numOf5;
	int numOf10;
	int numOf25;
	int sumCash = numOf1 + 5*numOf5 + 10*numOf10 + 25*numOf25;
	
	
	public vendingMachine() {	
		numOf1 = 0;
		numOf5 = 0;
		numOf10 = 0;
		numOf25 = 0;
	}
	
	public String addDrinks() {
		String returnString = "Drinks added";
		product coke = new product("Coke", 25, 1);
		product pepsi = new product("Pepsi", 35, 3);
		product soda = new product("Soda", 45, 3);
		
		productsAvailable.add(coke);
		productsAvailable.add(pepsi);
		productsAvailable.add(soda);
		
		return returnString;
	}
	public String addChange() {
		numOf1 = 100;
		numOf5 = 100;
		numOf10 = 100;
		numOf25 = 100;
		sumCash = numOf1 + 5*numOf5 + 10*numOf10 + 25*numOf25;
		String returnString  = "Change reset. \n Total = ";
	
			if(	sumCash>100) {
				returnString+= "£" + (double)sumCash / 100;
			}else {
				returnString += sumCash + "p";
			}
		
		return returnString;
	}
	
	public String printChange() {
		String returnString  = "Change total = ";
	
			if(	sumCash>100) {
				returnString+= "£" + (double)sumCash / 100;
			}else {
				returnString += sumCash + "p";
			}
		
		return returnString;
	}
	
	public void printAll() {
		String toPrint = "";
		if(productsAvailable.size()>0) {
			for(int i =0; i<productsAvailable.size();i++) {
				toPrint+= "There ";
				if(productsAvailable.get(i).quantity==1) {
					toPrint+= "is";
				}else {
					toPrint+= "are";
				}
				toPrint+=  " " + productsAvailable.get(i).quantity + " " + productsAvailable.get(i).name;
				
				if(productsAvailable.get(i).quantity!=1) {
					toPrint+= "s";
				}
				toPrint+= " priced at " + productsAvailable.get(i).price + "p. ";
			}
		}else {
			toPrint = "No Products in vending machine.";
		}
		System.out.println(toPrint);
	}
}
