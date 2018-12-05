import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day5 {
	public static void main(String args[]) {
		
		File inputFile = new File("inputDay5.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		};
		
		
		//Part 1
		String poly = scan.nextLine();
		
		
		
		ArrayList<Character> inputList = new ArrayList<Character>();
		int i = 0;
		while(i < poly.length()) {
			inputList.add(poly.charAt(i));
			i++;
		}
		
		/*
		while(!removeDoubles(inputList)) {
			
		}
		
		
		
		for(Character c : inputList) {
			System.out.print(c);
		}
		
		System.out.println("\nUnits remaining: " + inputList.size());
		*/
		
		
		//Part 2
		
	
		String poly2 = poly;
		
		String[] l = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		int index = 0;
		int smallest = 1000000;
		while(index < 26){
			String poly3 = poly2.replaceAll("[" + l[index] + "]", "");
			String poly4 = poly3.replaceAll("[" + l[index].toUpperCase() + "]", "");
			int cur = 0;
			ArrayList<Character> rList = new ArrayList<Character>();
			while(cur < poly4.length()) {
				rList.add(poly4.charAt(cur));
				cur++;
			}
			
			while(!removeDoubles(rList)) {}
			if(rList.size() < smallest) {
				
				smallest = rList.size();
			}
			rList.clear();
			index++;
			
		}
		
		System.out.println("Smallest: " + smallest);
			
	}
	
	public static boolean removeDoubles(ArrayList<Character> inputList) {
		boolean noDoubles = true;
		for(int j = 0; j < inputList.size(); j++) {
			if(j+1 < inputList.size()) {
				if(inputList.get(j).compareTo(inputList.get(j+1)) == 0) { //same case and letter
					
				}else if((Character.toLowerCase(inputList.get(j)) == inputList.get(j+1) ||
						Character.toLowerCase(inputList.get(j+1)) == inputList.get(j)) && 
						inputList.get(j).compareTo(inputList.get(j+1)) != 0 ) { //same letter, different case
					inputList.remove(j+1);
					inputList.remove(j);
					noDoubles = false;
				}else {
				}
			}
		}
		return noDoubles;
	}
}
