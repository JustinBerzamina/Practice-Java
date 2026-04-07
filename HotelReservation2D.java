package javapracb;
import java.util.Scanner;
public class HotelReservation2D {
	public static void main(String[] args) {
		int hotel[][] = new int[7][5];
		int choice = 0;
		int floor = 0;
		int room = 0;
		Scanner input = new Scanner(System.in);
		do {
			System.out.print("=== HOTEL RESERVATION SYSTEM ===\n" +
								"1. View Rooms\n"	+
								"2. Check In\n"   +
								"3. Check Out\n"	+
								"4. Exit\n"+ 
								"Enter Choice: "
					);
			choice = input.nextInt();
			System.out.println();
			switch (choice) {
			
			case 1:
				for (int i = 0; i < hotel.length; i++) {
					System.out.print("Floor " + (i+1) + ": " );
					for (int j = 0; j < hotel[i].length; j++) {
						System.out.print("[" + hotel[i][j] + "]");
					}
					System.out.println();
				}System.out.println(); 
				break;
			case 2:
				System.out.print("Enter floor (1-7): ");
				floor = input.nextInt(); floor-=1;
				System.out.print("Enter room (1-5): ");
				room = input.nextInt(); room-=1;
				if (hotel[floor][room]==0) {
					hotel[floor][room] = 1;
					System.out.println("Check-in successful!"); 
				}
				else System.out.println("Room is already occupied.");
				break;
			case 3:
				System.out.print("Enter floor (1-7): ");
				floor = input.nextInt(); floor-=1;
				System.out.print("Enter room (1-5): ");
				room = input.nextInt(); room-=1;
				if (hotel[floor][room]==1) {
					hotel[floor][room] = 0;
					System.out.println("Check-out successful!"); 
				}
				else System.out.println("Room is already empty.");
				break;
				
			}
		
		}while(choice!=4);
		System.out.println("See you next time!");
		input.close();
	}
	
}
