package com.greatlearning.skycrapperservices;

import java.util.Arrays;
import java.util.Stack;

public class skycrapperservices{
	static boolean largestNumber;
	static boolean addFlag;
	
	
	@SuppressWarnings("unchecked")
	public static void calculateFloors(int[] floorSize) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i=0; i<floorSize.length; i++) {
			largestNumber=true;
			int floorSize_i = floorSize[i];
			for (int j=i; j<floorSize.length; j++) {
				if (j==i) {
					continue;
				}
				else 
				{
					int floorSize_j =floorSize[j];
					if (floorSize_i>= floorSize_j) {
						largestNumber=true;
						continue;
					}
					else
					{
						largestNumber= false;
						stack.push(floorSize_i);
						break;
					}
				}
			}
			
			if (largestNumber == true) {	
				Stack<Integer> stackTmp = displayFloor(stack, floorSize_i, i, floorSize);
				stack.clear();
				stack = (Stack<Integer>) stackTmp.clone();
				stackTmp.clear();
				System.out.println();
		}
		else
		{
			System.out.println("DAY " + (i+1) + ":");
		}
		}
	}
	public static Stack<Integer> displayFloor(Stack<Integer> stack, int currentFloor, int iter, int[] arrayFloor) {
		int[] arrayofPoppedElements = new int[arrayFloor.length];
		int count = 0;
		System.out.println("DAY" + (iter+1) + ":" + currentFloor);
		Stack<Integer> stackTmp = new Stack<Integer>();
		boolean largestInStack;
		if (iter==arrayFloor.length -1) {
			while(!stack.empty()) {
				int popFloor = (int) stack.pop();
				arrayofPoppedElements[count++] = popFloor;
			}
			
			if(arrayofPoppedElements!= null) {
				Arrays.sort(arrayofPoppedElements);
				for (int i=arrayofPoppedElements.length-1; i>0; i--) {
					if(arrayofPoppedElements[i]!=0) {
						System.out.println(" " + arrayofPoppedElements[i]);
					}
				}
			}
			return stackTmp;
		}
		else
		{
			if (!stack.empty()) {
				while(!stack.empty()) {
					largestInStack = true;
					int popFloor = (int) stack.pop();
					for (int i=iter; i<arrayFloor.length; i++) {
						if (i==iter) {
							continue;
						}
						if(popFloor<arrayFloor[i]) {
							stackTmp.push(popFloor);
							largestInStack = false;
							break;
						}
						else
						{
							largestInStack = true;
						}
					}
					if (largestInStack==true) {
						arrayofPoppedElements[count++] = popFloor;
					}
				}
			}
			if (arrayofPoppedElements != null) {
				Arrays.sort(arrayofPoppedElements);
				for (int i = arrayofPoppedElements.length-1; i>0; i--) {
					if (arrayofPoppedElements[i] !=0) {
						System.out.println(" " + arrayofPoppedElements[i]);
					}
				}
			}
			return stackTmp;
							
		}
	}
	}
	