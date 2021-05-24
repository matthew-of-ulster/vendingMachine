import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		boolean run = true;
		vendingMachine v =new vendingMachine();
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			String toPrint = "--Welcome to our vending machine!-- \n Please select an option below";
			toPrint+= "\n1 - Print drinks list";
			toPrint+= "\n2 - Add Drinks";
			toPrint+= "\n3 - Print change available";
			toPrint+= "\n4 - Add change";
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
			case "x":
				System.out.println("Goodbye!");
				run = false;
				break;
			}
			
			
			
			
			
			
		}
		
	}

}
