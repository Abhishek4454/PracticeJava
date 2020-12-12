package com.practice.dsa;

import java.util.Arrays;
import java.util.Scanner;

public class MyArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myArray = new int[10];
		myArray[0] = 14;
		myArray[1] = 24;
		myArray[2] = -14;
		myArray[3] = 34;
		myArray[4] = 17;
		myArray[5] = -22;
		myArray[6] = 10;
		myArray[7] = 54;
		myArray[8] = 94;
		myArray[9] = 4;
		/*
		 * Scanner sc = new Scanner(System.in); int n= sc.nextInt();
		 * System.out.println("Enter the Size of array: " + n); int[] myArray= new
		 * int[n]; for (int i = 0; i < myArray.length; i++) {
		 * System.out.println("Enter the array elements : "); myArray[i]=sc.nextInt(); }
		 */
		System.out.println("Initially the arrays : " + Arrays.toString(myArray));
		/*
		 * int pos=5; int x=32; int[] newArray=insertX(pos,myArray,x);
		 * System.out.println("After adding the array element : " +
		 * Arrays.toString(newArray)); int[] newArray1=deleteX(pos,myArray);
		 * System.out.println("After deleting the array element : " +
		 * Arrays.toString(newArray1));
		 */
		//System.out.println(" Buble Sort :- " + Arrays.toString(getBubleSort(myArray)));
		//System.out.println("Selection Sort :- " + Arrays.toString(getSelectionSort(myArray)));
		//System.out.println("Insertion Sort :- " + Arrays.toString(getInsertionSort(myArray)));
		System.out.println("Shell Sort :- " + Arrays.toString(getShellSort(myArray)));


	}

	private static int[] getShellSort(int[] myArray) {
		// TODO Auto-generated method stub
		for(int gap=myArray.length/2 ;gap>0;gap/=2) {//[14, 24, -14, 34, 17, -22, 10, 54, 94, 4]
			for(int i=gap;i<myArray.length;i++) {
				int newElement=myArray[i];
				int j=i;
				while(j>=gap && myArray[j-gap]>newElement) {
					myArray[j]=myArray[j-gap];
					j-=gap;
				}
				myArray[j]= newElement;
			}
		}
		return myArray;
	}

	private static int[] getInsertionSort(int[] myArray) {
		// TODO Auto-generated method stub
		for(int firstUnsortedIndex=1 ;firstUnsortedIndex < myArray.length ;firstUnsortedIndex++) {
			int newElement= myArray[firstUnsortedIndex];//[14, 24, -14, 34, 17, -22, 10, 54, 94, 4]
			int i;
			for ( i = firstUnsortedIndex; i>0 && myArray[i-1]>newElement; i--) 
				myArray[i]=myArray[i-1];
			
			myArray[i]= newElement;		

		}
		return myArray;
	}

	private static int[] getSelectionSort(int[] myArray) {
		// TODO Auto-generated method stub
		for(int lastUnsortedIndex=myArray.length-1; lastUnsortedIndex>0;lastUnsortedIndex--) {
			int largest=0;
			for (int i = 1; i <= lastUnsortedIndex; i++) {
				if (myArray[largest] < myArray[i]) {
					largest=i;
				}
			}
			swap(myArray, largest, lastUnsortedIndex);
		}
		return myArray;
	}

	private static int[] getBubleSort(int[] myArray) {
		// TODO Auto-generated method stub
		for (int lastUnsortedIndex = myArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
			for (int i = 0; i < lastUnsortedIndex; i++) {
				if (myArray[i] > myArray[i + 1]) {
					swap(myArray, i, i + 1);
				}
			}
		}
		return myArray;
	}

	private static void swap(int[] myArray, int i, int j) {
		if (myArray[i] == myArray[j])
			return;
		if (myArray[i] > myArray[j]) {
			int temp = myArray[i];
			myArray[i] = myArray[j];
			myArray[j] = temp;

		}

	}

	private static int[] deleteX(int pos, int[] myArray) {
		int n = myArray.length;
		int[] updatedArray = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			if (i < pos)
				updatedArray[i] = myArray[i];
			else if (i >= pos)
				updatedArray[i] = myArray[i + 1];

		}
		return updatedArray;
	}

	private static int[] insertX(int pos, int[] myArray, int x) {
		// TODO Auto-generated method stub
		int n = myArray.length;
		int[] updatedArray = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			if (i < pos) {
				updatedArray[i] = myArray[i];
			} else if (i == pos) {
				updatedArray[i] = x;
			} else {
				updatedArray[i] = myArray[i - 1];
			}

		}

		return updatedArray;
	}

}
