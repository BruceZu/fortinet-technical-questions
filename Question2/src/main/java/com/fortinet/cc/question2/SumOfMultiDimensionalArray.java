package com.fortinet.cc.question2;

import java.util.*;

public class SumOfMultiDimensionalArray {
	// Time Complexity - O(x*y*z...*n) - size of each dimension
	// Space Complexity - O(n) n - lengthOfDimensions
	public static Long sum(MultiDimensionArray mArray, int[] lengthOfDimensions) {
		if(mArray == null || lengthOfDimensions == null || lengthOfDimensions.length == 0) return 0L;
		int n = lengthOfDimensions.length;
		int[] index = new int[n];
		List<int[]> list = new ArrayList<int[]>();
		long sum = 0;
		getIndexList(0, n, lengthOfDimensions, index, list);
		for(int[] idx : list) {
			sum += mArray.getValue(idx);
		}
		return sum;
	}
	
	public static void getIndexList(int d, int n, int[] dim, int [] index, List<int[]> list) {
		if(d >= n) {
			int[] idx = index.clone();
			list.add(idx);
			return;			
		}
		for(int i =0; i<dim[d]; i++) {
			index[d] = i;
			getIndexList(d+1, n, dim, index, list);
		}		
	}
	
	public static void main(String[] args) {
		int[] dimensions = new int[3];
		dimensions[0] = 2;
		dimensions[1] = 2;
		dimensions[2] = 2;
		MultiDimensionArray mArray = new MultiDimensionArray(dimensions);
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				for(int k=0; k<2; k++) {
					int[] indexOfDimension = new int[3];
					indexOfDimension[0] = i;
					indexOfDimension[1] = j;
					indexOfDimension[2] = k;
					long v = 0 + (long) (Math.random() * (100 - 0));
					System.out.print(v + " ");
					mArray.setData(indexOfDimension, v);
				}
			}			
		}		
		long s = 0;
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				for(int k=0; k<2; k++) {
					s += mArray.getValue(new int[]{i,j,k});
					System.out.print(mArray.getValue(new int[]{i,j,k}) + " ");
				}
			}			
		}
		System.out.println(s);
		
		System.out.println(sum(mArray, dimensions));
		
	}
}


