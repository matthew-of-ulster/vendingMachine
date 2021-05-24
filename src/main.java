import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		boolean run = true;
		vendingMachine v =new vendingMachine();
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			String toPrint = "\n--Welcome to our vending machine!-- \n Please select an option below";
			toPrint+= "\n1 - Print drinks list";
			toPrint+= "\n2 - Add Drinks";
			toPrint+= "\n3 - Print change available";
			toPrint+= "\n4 - Add change";
			toPrint+= "\n5 - Buy Drink";
			toPrint+="\nx - quit";
			System.out.println(toPrint);
			
			String userSel = sc.nextLine();
			switch(userSel.trim()) {
			case "1":
				v.printAll();
				break;
			case "2":
				System.out.println(v.addDrinks());
				break;
			case "3":
				System.out.println(v.printChange());
				break;
			case "4":
				System.out.println(v.addChange());
				break;
			case "5":
				String printDrink ="Which drink would you like?";
				if(v.productsAvailable.size()==0) {
					printDrink ="No Drinks Available";
				}
				for(int i = 0 ;i<v.productsAvailable.size();i++) {
					printDrink+= "\n"+(i + 1) +" - " + v.productsAvailable.get(i).name;
				}
				System.out.println(printDrink);
				int choice = Integer.parseInt(sc.nextLine().trim());
				v.buyDrink(choice-1);
				
				break;
			case "x":
				System.out.println("Goodbye!");
				run = false;
				break;
			}
			
			
			
			
			
			
		}
		
	}

}
