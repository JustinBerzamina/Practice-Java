package javaprac;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
public class JOptionPaneStudentFeedbackSystem {
	public static void main(String[] args) {
		int choice=0;
		int total=0;
		double averageRating=0;
		String name;
		String course;
		String feedback;
		String rates[] = {"1","2","3","4","5"};
		int excellent = 0;
		int good = 0;
		int average = 0;
		int poor = 0;
		int verypoor=0;
		int rate=0;
		String data="-- Student Feedback Records ---\n\n";
		do {
			name = JOptionPane.showInputDialog(null, "Enter your Name:", "Student Feedback System", 3);
			if (name==null || name.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Program Cancelled, please provide an input.", "Exit", 0, null); System.exit(0);
			}
			data+=("Student Name: " + name +"\n");
			course = JOptionPane.showInputDialog(null, "Enter your course:", "Student Feedback System", 3);
			if (course==null|| course.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Program Cancelled, please provide an input.", "Exit", 0, null); System.exit(0);
			}
			data+=("Course: " + course +"\n");
			feedback = JOptionPane.showInputDialog(null, "Write your feedback message:", "Student Feedback System", 3);
			if (feedback==null || feedback.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Program Cancelled, please provide an input.", "Exit", 0, null); System.exit(0);
			} data+=("Feedback: " + feedback +"\n");
			Object rating = JOptionPane.showInputDialog(null, "Rate the subject(1-5):", "Student Feedback System", JOptionPane.QUESTION_MESSAGE, null, rates, rates[2]);
			if (rating != null) {
				rate = Integer.parseInt(rating.toString());
				total++;

				switch (rate) {
				case 5:
					excellent++;
					data+=("Rating: " + rating + "(Excellent)"+ "\n\n");
					break;
				case 4: 
					good++;
					data+=("Rating: " + rating + "(Good)"+ "\n\n");
					break;
				case 3:
					average++;
					data+=("Rating: " + rating + "(Average)"+ "\n\n");
					break;
				case 2:
					poor++;
					data+=("Rating: " + rating + "(Poor)"+ "\n\n");
					break;
				case 1:
					verypoor++;
					data+=("Rating: " + rating + "(Very Poor)"+ "\n\n");
					break;
				}
			} 
			else {
				JOptionPane.showMessageDialog(null, "Program Cancelled, please provide an input.", "Exit", 0, null); System.exit(0);
			}
			choice = JOptionPane.showConfirmDialog(null, "Would you like to add another feedback?");

			if (choice==JOptionPane.CANCEL_OPTION) {
				JOptionPane.showMessageDialog(null, "Program Cancelled.", "Exit", 0, null); System.exit(0);
			}
		}while((choice==JOptionPane.YES_OPTION));
		String feedbackRate ="";
		int ratingTotal = (excellent*5) + (good*4) + (average*3) + (poor*2) + (verypoor*1);
		if (total > 0) {
		    averageRating = (double) ratingTotal / total;
		    if (averageRating >= 4.5) feedbackRate = "Outstanding Feedback!";
		    else if (averageRating >= 3.5) feedbackRate = "Good Feedback!";
		    else if (averageRating >= 2.5) feedbackRate = "Average Feedback!";
		    else feedbackRate = "Needs Improvement.";
		} else {
		    data = "No feedback was recorded.";
		}
		data+=("---------------------------------\n"+
				"Total Feedback: "+ total + "\n"+
				"Average Rating: "+ averageRating + " ("+ feedbackRate +")\n\n"+
				"Excellent: " + excellent +"\n"+
				"Good: " + good +"\n"+
				"Average: " + average +"\n"+
				"Poor: " + poor +"\n"+
				"Very Poor: " + verypoor+"\n"
				+"---------------------------------\n\n"
				);
		JOptionPane.showMessageDialog(null, data, "Student Feedback System", 1);
		try {
			FileWriter fw = new FileWriter("feedback.txt", true);
			fw.write(data);
			fw.close();
			JOptionPane.showMessageDialog(null, "File has been saved successfully! Program will now exit", "File Saved", 1);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error! Could not save the file.\n" + e.getMessage(), "Save Error", 0);
		    e.printStackTrace(); 
		}
	}
}
