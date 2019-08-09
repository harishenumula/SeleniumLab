package com.java;

import java.util.Iterator;

public class Java_Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] items = new int[5][5];

		for (int i = 0; i <= 4; i++) {// Row Iteration
			for (int j = 0; j <= 4; j++) {// Column Iteration
				items[i][j] = i + j;
			}
		}
		for (int[] item : items) {
			for (int i = 0; i < items.length; i++) {
				System.out.print(item[i] + "\t");

			}
			System.out.println();
		}
		System.out.println("\n\n");
		for (int[] item : items) {
			for (int item_ : item) {
				System.out.print(item_ + "\t");
			}

			System.out.println();
		}
	}

}
