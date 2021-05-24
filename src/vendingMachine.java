import java.util.ArrayList;
import java.util.Scanner;

public class vendingMachine {
	ArrayList<product> productsAvailable = new ArrayList<product>();
	static int numOf1;
	static int numOf5;
	static int numOf10;
	static int numOf25;
	static int sumCash = numOf1 + 5*numOf5 + 10*numOf10 + 25*numOf25;
	
	
	public vendingMachine() {	
		numOf1 = 0;
		numOf5 = 0;
		numOf10 = 0;
		numOf25 = 0;
	}
	
	public void buyDrink(int choice) {
		if (choice<productsAvailable.size()) {
			if (productsAvailable.get(choice).quantity == 0) {
				System.out.println(productsAvailable.get(choice).name + " is unavailable");
			}else {
				System.out.println("Please enter change");
				boolean correctChange = vendingMachine.enterChange(productsAvailable.get(choice).price);
				if(correctChange) {
					productsAvailable.get(choice).quantity--;
					System.out.println("\nEnjoy Your " + productsAvailable.get(choice).name + "!\n");
				}
			}
			
		}
		
	}
	
	private static boolean enterChange(int cost) {
		Scanner sc = new Scanner(System.in);
		boolean returnBool = true;
		int total = 0;
		int count1 = 0;
		int count5 = 0;
		int count10 = 0;
		int count25 = 0;
		
		while(total<cost) {
			
		System.out.println("Total due: " + (cost-total) + "\nTotal paid: " + total + "\nPlease enter a coin" );
		int coin = sc.nextInt();
		switch(coin) {

		case 1 :
			count1++;
			total = total + coin;
			break;
		case 5:
			count5++;
			total = total + coin;
			break;
		case 10:
			count10++;
			total = total + coin;
			break;
		case 25:
			count25++;
			total = total + coin;
			break;		
			default :
				System.out.println("\nInvalid coin. \nWould you like to cancel the transaction? y/n\n");
				String quit = sc.next();
				if(quit.equals("y")) {
					return false;
				}
		}
		
		
		}
		System.out.println("\nAre you sure you want to buy a drink? y/n" );
		String quit = sc.next();
		if(quit.equals("n")) {
			System.out.println("You have been refunded");
			return false;
		}else {
			numOf1 = numOf1 + count1;
			numOf5 = numOf5 + count5;
			numOf10 = numOf10 + count10;
			numOf25 = numOf25 + count25;
			int changeDue = total - cost;
			count1 = 0;
			count5 = 0;
			count10 = 0;
			count25 = 0;
			while(changeDue>0) {
				if(changeDue>=25) {
					count25++;
					changeDue = changeDue - 25;
				}else if(changeDue>=10) {
					count10++;
					changeDue = changeDue - 10;
				}else if(changeDue>=5) {
					count5++;
					changeDue = changeDue - 5;
				}else if(changeDue>=1) {
					count1++;
					changeDue = changeDue - 1;
				}
				
			}
			String yourChange="Your change is ";
			for(int i = 1;i<=count25;i++) {
				numOf25--;
				yourChange += "25 ";
			}
			for(int i = 1;i<=count10;i++) {
				numOf10--;
				yourChange += "10 ";
			}
			for(int i = 1;i<=count5;i++) {
				numOf5--;
				yourChange += "5 ";
			}
			for(int i = 1;i<=count1;i++) {
				numOf1--;
				yourChange += "1 ";
			}
			System.out.println(yourChange);
		}
		sumCash = numOf1 + 5*numOf5 + 10*numOf10 + 25*numOf25;
		return returnBool;
	}

	public String addDrinks() {
		ArrayList<product> blank = new ArrayList<product>();
		productsAvailable = blank;
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
				toPrint+= "\nThere ";
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
