import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Day3 {
	public static void main(String args[]) {
		
		File inputFile = new File("input.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		};
		
		
		//Part 2
		ArrayList<String> inputLines = new ArrayList<String>();
		while(scan.hasNextLine()) {
			inputLines.add(scan.nextLine());
		}
		
		int[][] fabric = new int[2000][2000];
		for(String line : inputLines) {
			StringTokenizer data = new StringTokenizer(line);
			while(data.hasMoreTokens()) {
			
				//get claim number
				String claim = data.nextToken();
				//skip @
				data.nextToken();
				//get left edge and top edge
				String edges = data.nextToken();
				String[] edges2 = edges.split(",");
				int leftEdge = Integer.parseInt(edges2[0]);
				int topEdge = Integer.parseInt(edges2[1].split(":")[0]);
				//get wide and tall
				String dimen = data.nextToken();
				String[] dimen2 = dimen.split("x");
				int wide = Integer.parseInt(dimen2[0]);
				int tall = Integer.parseInt(dimen2[1]);
				int i, j;
				
				  for (i = leftEdge; i < (leftEdge + wide); i++)
		            {
		                for (j = topEdge; j < (topEdge + tall); j++)
		                {

		                    fabric[i][j]++;
		                }
		                j = topEdge;
		            }
			}
		} 
			
			for(String line2 : inputLines) {
				StringTokenizer data2 = new StringTokenizer(line2);
				boolean isOverlapping = false;
				
					//get claim number
					String claim = data2.nextToken();
					//skip @
					data2.nextToken();
					//get left edge and top edge
					String edges = data2.nextToken();
					String[] edges2 = edges.split(",");
					int leftEdge = Integer.parseInt(edges2[0]);
					int topEdge = Integer.parseInt(edges2[1].split(":")[0]);
					//get wide and tall
					String dimen = data2.nextToken();
					String[] dimen2 = dimen.split("x");
					int wide = Integer.parseInt(dimen2[0]);
					int tall = Integer.parseInt(dimen2[1]);
					int i, j;
					
					  for (i = leftEdge; i < (leftEdge + wide); i++){
			                for (j = topEdge; j < (topEdge + tall); j++){

			                	if(fabric[i][j] > 1) { //is greater than 1 then there is overlap
			    					isOverlapping = true;
			    				}
			                }
			                j = topEdge;
			            }
					
				
				  if(!isOverlapping) {
					  System.out.println("NOT OVERLAPPING");
					  System.out.println(line2);
				  }
			}
		
		
		
		/*
		
		//Part 1
		int[][] fabric = new int[2000][2000];
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			StringTokenizer data = new StringTokenizer(line);
			while(data.hasMoreTokens()) {
			
				//get claim number
				String claim = data.nextToken();
				//skip @
				data.nextToken();
				//get left edge and top edge
				String edges = data.nextToken();
				String[] edges2 = edges.split(",");
				//System.out.println(edges2[0]);
				int leftEdge = Integer.parseInt(edges2[0]);
				int topEdge = Integer.parseInt(edges2[1].split(":")[0]);
				//get wide and tall
				String dimen = data.nextToken();
				String[] dimen2 = dimen.split("x");
				int wide = Integer.parseInt(dimen2[0]);
				int tall = Integer.parseInt(dimen2[1]);
				int i, j;
				  for (i = leftEdge; i < (leftEdge + wide); i++)
		            {
		                for (j = topEdge; j < (topEdge + tall); j++)
		                {

		                    fabric[i][j]++;
		                }
		                j = topEdge;
		            }
			}
		}
		
		int totalOverlap = 0;
		for(int m = 0; m < 2000; m++) {
			for(int n = 0; n < 2000; n++) {
				if(fabric[m][n] > 1) { //is greater than 1 then there is overlap
					totalOverlap ++;
				}
			}
		}
		
		System.out.println(totalOverlap);
		
		*/
		
		}
	
	
}
