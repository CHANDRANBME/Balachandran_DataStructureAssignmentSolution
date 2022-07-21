package com.greatlearning.skycrapperdriver;

import java.util.Scanner;

import com.greatlearning.skycrapperservices.skycrapperservices;

public class Main{
	
	public static void main(String[] args){
		System.out.println("ENTER THE TOTAL NUMBER OF FLOORS");
		try (Scanner sc = new Scanner(System.in)) {
			int numberofFloors = sc.nextInt();
			int[] listofFloors = new int[numberofFloors];
			for (int i=0; i<numberofFloors; i++) {
				System.out.println("ENTER THE FLOOR SIZE GIVEN ON DAY: " + (i+1));
				int floorsize=sc.nextInt();
				listofFloors[i]=floorsize;
			}
			skycrapperservices.calculateFloors(listofFloors);
		}
		
	}
}