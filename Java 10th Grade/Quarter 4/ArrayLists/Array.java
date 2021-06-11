import java.util.*;
import java.lang.*; 
import java.io.*; 

import java.util.Collections;  // Import the Collections class

class Array{

	public ArrayList<Integer> numbers = new ArrayList<Integer>();

	int newNumber;

	void addNumbers() {
		for(int i = 0; i < 10; i++) {
			newNumber = ((int)(Math.random()*10));
			numbers.add(newNumber);
		}
	}

	void printArray() {
		System.out.println("Original ArrayList:");
		for (int i : numbers) {
      System.out.print("," + i);
		}
	}

	void largeNum() {
		int max = numbers.get(0);
		int n = numbers.size();
		int arrayNum = 0;
		       
    for (int i = 1; i < n; i++) {
      if (numbers.get(i) > max) {
        max = numbers.get(i);
				arrayNum = i;
      }
    }
		System.out.println();
		System.out.println("The largest number in this ArrayList is: " + max);
		System.out.println("The Index of this number is " + arrayNum);
	}

	void largeAbValue() {
		int max = Math.abs(numbers.get(0));
		int arrayNum = 0;
		int n = numbers.size();

		for (int i = 1; i < n; i++) {
      if (Math.abs(numbers.get(i)) > max) {
        max = Math.abs(numbers.get(i));
				arrayNum = i;
      }
    }

		System.out.println("The largest absolute number in this ArrayList is: " + max + " / index " + arrayNum);
	}

	void proj3ct() {
		int searchNum = ((int)(Math.random()*10));
		int count = 0;
		System.out.println("The number being searched for is: " + searchNum);
		int n = numbers.size();

		for (int i = 0; i < n; i++) {
      if(numbers.get(i) == searchNum) {
				System.out.println("the index of the number being searched for is: " + i);
				count++;
			}
		}
		if(count == 0) {
			System.out.println("The number was not found in this array list");
		}
	}

	void compare() {
		ArrayList<Integer> numbers2 = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			newNumber = ((int)(Math.random()*10));
			numbers2.add(newNumber);
		}
		System.out.println();
		System.out.print("The first array list is: ");
		for (int i : numbers) {
      System.out.print("," + i);
		}
		System.out.println();
		System.out.print("The second array list is: ");
		for (int i : numbers2) {
      System.out.print("," + i);
		}

		Collections.sort(numbers);
		Collections.sort(numbers2);
		int count = 0;
		for (int i = 0; i < 10; i++) {
			if(numbers.get(i) != numbers2.get(i)){
				System.out.println();
				System.out.println("These arrays are not the same");
				break;
			}
			else {
				count++;
			}
		}

		if(count == 10){
			System.out.println("These Arraylists are the same");
		}
	}


	
}