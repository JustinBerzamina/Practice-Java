package javaprac;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class UpdatedHotelReservation2D {
	public static void main(String[] args) {
		int hotel[][] = new int[7][5];
		int floor = 0;
		int room = 0;
		String floorIndex;
		String roomIndex;
		String viewrooms= "";
		String choice="";
		int checkInConfirm;
		String options[] = {"1. View Rooms","2.Check In", "3.Check Out", "4.Exit" };
		Scanner input = new Scanner(System.in);
		do {
			Object selectedOption =JOptionPane.showInputDialog(null, "Select an Option", "Welcome To Hotel Reservation System", JOptionPane.PLAIN_MESSAGE, null, options, options[0]
					);
			if (selectedOption != null) {
				choice = (String) selectedOption;
			}
			else choice = ("4.Exit");

			switch (choice) {

			case "1. View Rooms":

				for (int i = 0; i < hotel.length; i++) {
					viewrooms+=("Floor " + (7-i) + ": " );
					for (int j = 0; j < hotel[i].length; j++) {
						viewrooms+=( "[" + hotel[i][j] + "]");
					}viewrooms+=("\n");
				}
				JOptionPane.showMessageDialog(null, viewrooms, "Rooms(1 = Occupied, 0 = Available)", 1);
				viewrooms="";
				break;
			case "2.Check In":

				floorIndex= JOptionPane.showInputDialog(null,"Enter floor (1-7): ","Floor Number", 3);
				if (floorIndex != null) {
					floor = Integer.parseInt(floorIndex.toString()); floor = 7-floor ;
				} else break;
				roomIndex= JOptionPane.showInputDialog(null,"Enter room (1-5): ","Room Number", 3);
				if (roomIndex != null) {
					room = Integer.parseInt(roomIndex.toString());; room-=1;
				} else break;
				if (hotel[floor][room]==0) {
					hotel[floor][room] = 1;
					checkInConfirm = JOptionPane.showConfirmDialog(
							null,
							"Proceed with check-in for this guest?",
							"Confirm Check-in",
							JOptionPane.YES_NO_OPTION
							);
					if (checkInConfirm == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null,"Check-in successful!", "Success", 1); 
					} else JOptionPane.showMessageDialog(null,"Check-in Cancelled.", "Failed", 0);
				}
				else JOptionPane.showMessageDialog(null,"Room is already occupied.", "Failed", 0);
				break;
			case "3.Check Out":
				floorIndex= JOptionPane.showInputDialog(null,"Enter floor (1-7): ","Floor Number", 3);
				if (floorIndex != null) {
					floor = Integer.parseInt(floorIndex.toString()); floor = 7-floor ;
				} else break;
				roomIndex= JOptionPane.showInputDialog(null,"Enter room (1-5): ","Room Number", 3);
				if (roomIndex != null) {
					room = Integer.parseInt(roomIndex.toString());; room-=1;
				} else break;
				if (hotel[floor][room]==1) {
					hotel[floor][room] = 0;	
					checkInConfirm = JOptionPane.showConfirmDialog(
							null,
							"Proceed with check-out for this guest?",
							"Confirm Check-out",
							JOptionPane.YES_NO_OPTION
							);
					if (checkInConfirm == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null,"Check-out successful!", "Success", 1); 
					} else JOptionPane.showMessageDialog(null,"Check-out Cancelled.", "Failed", 0);	
				}
				else JOptionPane.showMessageDialog(null,"Room is already empty.", "Failed", 0);
				break;
			}

		}while (!"4.Exit".equals(choice));
		JOptionPane.showMessageDialog(null, "See you next time!","Farewell Message", 1);
		input.close();
	}

}