import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Day4 {
	public static void main(String args[]) {
		
		File inputFile = new File("inputDay4.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		};
		
		
		//Part 1
		ArrayList<String> inputList = new ArrayList<String>();
		while(scan.hasNextLine()) {
			inputList.add(scan.nextLine());
		}
		
		Collections.sort(inputList);
		ArrayList<Guard> guards = new ArrayList<Guard>();
		
		//load times
		int i = 0;
		int sleepTime = 0;
		int wakeTime = 0;
		int totalTimeAsleep = 0;
		int guardId = 0;
		Guard curGuard = null; 
		while(i < inputList.size()) {
			String[] x = inputList.get(i).split(" ");
			
			if(x[2].compareTo("Guard") == 0) {
				guardId = Integer.parseInt(x[3].substring(1));
				curGuard = getGuard(guardId, guards);;
				
			}
			if(x[2].compareTo("falls") == 0) {
				sleepTime = Integer.parseInt(x[1].substring(3, 5));
			}else if(x[2].compareTo("wakes") == 0) {
				wakeTime = Integer.parseInt(x[1].substring(3, 5));
				totalTimeAsleep = wakeTime - sleepTime;
				String tempTime = String.valueOf(totalTimeAsleep);
				int firstDig, secondDig;
				if(tempTime.length() == 1) {
					firstDig = 0;
					secondDig = Integer.parseInt(tempTime.substring(0,1));
				}else {
					firstDig = Integer.parseInt(tempTime.substring(0,1));
					secondDig = Integer.parseInt(tempTime.substring(1,2));
				}
				curGuard.addTime(firstDig, secondDig);
				curGuard.addMinutes(sleepTime, wakeTime);
			}
			
			i++;
		}
		
		//get highest time and guard number
		int guardIdMax = 0;
		int timeMinuteMax = 0;
		int timeSleepMax = 0;
		for(Guard g : guards) {
			if(g.findTotalSleep() > timeSleepMax) {
				timeMinuteMax = g.findLargestTime();
				guardIdMax = g.getGuardId();
				timeSleepMax = g.findTotalSleep();
			}
		}
		System.out.println("**** PART 1 ****");
		System.out.println("Guard Id Max: " + guardIdMax);
		System.out.println("Time Minute Max: " + timeMinuteMax);
		System.out.println("Time Sleep Max: " + timeSleepMax);
		System.out.println(guardIdMax * timeMinuteMax);
		
		
		//Part 2
		
		Guard maxId = null;
		int minute = 0;
		int maxMinuteSleep = 0;
		
		for(Guard g : guards) {
		
			if(g.findLargestTimeFreq() > maxMinuteSleep) {
				maxId = g;
				minute = g.findLargestTime();
				maxMinuteSleep = g.findLargestTimeFreq();
			}
		}
		System.out.println("**** PART 2 ****");
		System.out.println("Guard #" + maxId.getGuardId() + " slept most at minute " + minute + " a total of "
				+ maxMinuteSleep + " times.");
		System.out.println(maxId.getGuardId() * minute);
			
	}
	
	public static Guard getGuard(int guardId, ArrayList<Guard> guards) {
		Guard guardToReturn = null;
		boolean inList = false;
		
		for(Guard g : guards) {
			if(g.getGuardId() == guardId) {
				guardToReturn = g;
				inList = true;
			}
		}
		if(!inList) {
			Guard newGuard = new Guard(guardId);
			guards.add(newGuard);
			guardToReturn = newGuard;
		}
		return guardToReturn;
	}
}

class Guard {
	private int id;
	int[][] time;
	int[][] minute;
	private int maxTimeSleepFreq;
	
	public Guard(int number) {
		id = number;
		time = new int[10][10];
		minute = new int[10][10];
	}
	
	public void addTime(int dig1, int dig2) { //dig1 is first digit of second, dig2 is second digit of second
		
		time[dig1][dig2]++;
	}
	
	public void addMinutes(int sleepMin, int wakeMin) {
		
		ArrayList<Integer> minutes = new ArrayList<Integer>();
		int start = sleepMin;
		for(int i = start; i < wakeMin; i++) {
			minutes.add(i);
		}
		for(Integer i : minutes) {
			
			String tempTime = String.valueOf(i);
			int firstDig, secondDig;
			if(tempTime.length() == 1) {
				firstDig = 0;
				secondDig = Integer.parseInt(tempTime.substring(0,1));
			}else {
				firstDig = Integer.parseInt(tempTime.substring(0,1));
				secondDig = Integer.parseInt(tempTime.substring(1,2));
			}
			minute[firstDig][secondDig]++;
		}
	}
	
	public int findLargestTime() {
		int max = 0;
		int dig1 = 0;
		int dig2 = 0;
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(minute[i][j] > max) {
					max = minute[i][j];
					maxTimeSleepFreq = minute[i][j];
					dig1 = i;
					dig2 = j;
				}
			}
		}
		String second = String.valueOf(dig1) + String.valueOf(dig2);
		return Integer.parseInt(second);
		
	}
	
	public int findLargestTimeFreq() {
		int tempTime = findLargestTime();
		return maxTimeSleepFreq;
	}

	public int findTotalSleep() {
		int total = 0;
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				total += time[i][j] * Integer.parseInt(String.valueOf(i) + String.valueOf(j));
			}
		}
		return total;
				
	}
	
	public int getGuardId() {
		return id;
	}
}
