import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day2 {
	public static void main(String args[]) {
		
		File inputFile = new File("inputDay2.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		};
		
		
		ArrayList<String> inputList = new ArrayList<String>();
		while(scan.hasNextLine()) {
			inputList.add(scan.nextLine());
		}
		
		boolean isCorrectId = true;
		
		for(String id1 : inputList) {
			for(String id2 : inputList.subList(1, inputList.size()-1)) {
				if(id1.length() == id2.length() && id1.compareTo(id2) != 0) {
					int difference = 1; //id's can differ by 1
			        for(int j = 0; j < id1.length(); j++) { 
			            if(id1.charAt(j) != id2.charAt(j)) {
			                difference--; 
			                if(difference < 0) { //differ by too much
			                    isCorrectId = false;
			                }
			            }
			        }
					if(isCorrectId == true) {
						System.out.println("CorrectId1:" + id1);
						System.out.println("CorrectId2:" + id2);
						String commonLetters = "";
						for(int m = 0; m < id1.length(); m++) {
							if(id1.charAt(m) == id2.charAt(m)) {
								commonLetters += id1.charAt(m);
							}
						}
						
						System.out.println(commonLetters);
						System.exit(0);
					}
					isCorrectId = true;
			    }
			}
		}
		
		
		/*
		//Part 1
		HashMap<Character, Integer> boxMap = new HashMap<Character, Integer>();
		String boxId;
		int value2 = 0;
		int value3 = 0;
		while(scan.hasNextLine()) {
			boxId = scan.nextLine();
			System.out.println(boxId);
			for (int i = 0; i < boxId.length(); i++) {
			    char letter = boxId.charAt(i);
			    Integer value = boxMap.get(letter);
			    if (value != null) {
			        boxMap.put(letter, new Integer(value + 1));
			    }
			    else {
			       boxMap.put(letter, 1);
			   }
			}
			if(boxMap.containsValue(2) && boxMap.containsValue(3)) {
				System.out.println("contains 2 and 3");
				value2++;
				value3++;
			}else if(boxMap.containsValue(2)) {
				System.out.println("contains 2");
				value2++;
			}else if(boxMap.containsValue(3)) {
				System.out.println("contains 3");
				value3++;
			}else {}
			boxMap.clear();
		}
		
		System.out.println(value2 * value3);
	
		*/
		
	}
	
}
