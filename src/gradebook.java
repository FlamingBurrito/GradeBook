import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class gradebook {

	public static void main(String[] args) {
		
		int option = 0;
		System.out.println("Welcome to the Grade Book");
		Scanner userIn = new Scanner (System.in);
		ArrayList<Double> gradebook = new ArrayList<Double>();

		while(option!=6) {
			System.out.println("-=+=--=+=--=+=--=+=--=+=--=+=--=+=--=+=--=+=-");
			System.out.println("Please select what you would like to do");
			System.out.println("1) Enter Values");
			System.out.println("2) Modify Entry");
			System.out.println("3) Delete Entry");
			System.out.println("4) View Stats");
			System.out.println("5) View all Entries");
			System.out.println("6) Exit Program");
			
			option = userIn.nextInt();
			
			if(option == 1) {
				System.out.println("Enter your Entries here");
				double gradebookEntry = 0;
				while(true) {
					gradebookEntry = userIn.nextDouble();
					if(gradebookEntry == -1) {
						break;
					}
					else {
						gradebook.add(gradebookEntry);
					}
				  }
				}
			if(option == 2) {
				System.out.println("What index would you like to modify");
				int index = userIn.nextInt();
				System.out.println("Replace grade:" + index + " Value: " + gradebook.get(index) + "With what?");
				gradebook.set(index, userIn.nextDouble());
				System.out.println("Successfully set");
			}
			
			if(option == 3) {
				System.out.println("What index would you like to delete");
				int index = userIn.nextInt();
				gradebook.remove(index);
				System.out.println("Deleted");
			}
			
			if(option == 4) {
				double total = 0;
				for(int i = 0; i < gradebook.size(); i++) {
					total += gradebook.get(i);
				}
				double average = total/gradebook.size();
				
				ArrayList<Double> copiedGradeBook = new ArrayList<Double>();
				copiedGradeBook.addAll(gradebook);
				Collections.sort(copiedGradeBook);
				
				double max = copiedGradeBook.get(gradebook.size()-1);
				double min = copiedGradeBook.get(0);
				
				double median = 0;
				if(copiedGradeBook.size()%2==1) {
					median = copiedGradeBook.get(copiedGradeBook.size()/2);
				}
				else {
					int secIndex = copiedGradeBook.size()/2;
					double firstMedian = copiedGradeBook.get(secIndex - 1);
					double secondMedian = copiedGradeBook.get(secIndex);
					median = (firstMedian+secondMedian)/2.0;
				}
				System.out.println("Printing stats...");
				System.out.println("");
				System.out.println("Average: " + average);
				System.out.println("Min: " + min);
				System.out.println("Max: " + max);
				System.out.println("Median: " + median);
				System.out.println("Elements: " + gradebook.size());
				
			}
			
			
			if(option == 5) {
				System.out.println("|index| Value");
				for(int i = 0; i < gradebook.size();i++) {
					System.out.println("| " + i + "|" + gradebook.get(i));
				}
			}
		}
	}
}
