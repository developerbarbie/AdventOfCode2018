import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
	public static void main(String args[]) {
		
		File inputFile = new File("input.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		};
		
		//Part 2
		ArrayList<Integer> inputList = new ArrayList<Integer>();
		while(scan.hasNextLine()) {
			inputList.add(Integer.parseInt(scan.nextLine()));
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int total = 0;
		list.add(total);
		boolean done = false;
		while(done == false) {
			for(int i = 0; i < inputList.size(); i++) {
				total += inputList.get(i);
				if(list.contains(total)) {
					System.out.println(total);
					done = true;
					break;
				}
				list.add(total);
			}
			
		}
		
		
		
		//Part 1
		/*
		int total = 0;
		while(scan.hasNextLine()) {
			total += Integer.parseInt(scan.nextLine());
		}
		System.out.println(total);
		*/
	}
	

}
