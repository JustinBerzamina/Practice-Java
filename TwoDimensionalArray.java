package davi;
import java.util.Scanner;
public class TwoDimensionalArray {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numbers [][] = {{120,250,789,7},{58,79,31,87},{8,1,2,3},{99,98,97,96}};
		
		for (int[] nums:numbers){
			for (int num:nums) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i<numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				if (numbers[i][j] == 1) System.out.println("Number 1 is found at indices " + i + " " + j);
			}
		}
		numbers[2][1] = 50;
		System.out.println();
		for (int[] nums:numbers){
			for (int num:nums) {
				System.out.print(num + " ");
			}
			System.out.println();
			
		}
		for (int i = 0; i<numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				if (i == 1) { numbers[i][j] = 0;
					
				}
			}
		}
		System.out.println();
		for (int[] nums:numbers){
			for (int num:nums) {
				System.out.print(num + " ");
			}
			System.out.println();
			
		}
		input.close();
	}
	

}
