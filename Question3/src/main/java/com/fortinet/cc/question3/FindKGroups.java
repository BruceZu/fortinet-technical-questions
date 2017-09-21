package com.fortinet.cc.question3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKGroups {
	
	// find k groups
	// Time complexity - O(k*n) - n is the length of the array
	// Space complexity - O(k) 
	public static boolean separate(List<Integer> list, int k) {
		if(list == null || k == 0) return false;
		if(k == 1) return true;
		if(list.size() < k) return false;
				
		int n = list.size();
		int sum = 0;
		int[] subsets = new int[k];
		
		for(int i : list) {
			sum += i;			
		}
		
		if(sum % k != 0) return false;
		
		Arrays.fill(subsets, sum/k);
		
		return separate(list, n-1, k, subsets);
		
	}
	
	public static boolean separate(List<Integer> list, int n, int k, int[] subsets) {
		boolean isKPartition = true;
		for(int i=0; i<k; i++) {
			if(subsets[i] != 0) {
				isKPartition = false;
			}
		}
		if(isKPartition) return true;
		
		if(n < 0) return false;
		
		boolean result = false;
		
		for(int i=0; i<k; i++) {
			if(!result && subsets[i] - list.get(n) >= 0) {
				subsets[i] -= list.get(n);
				
				result = separate(list, n-1, k, subsets);
				
				subsets[i] += list.get(n);
			}
			
		}
		return result;		
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(1);
		list.add(4);
		list.add(5);
		list.add(6);
		System.out.println(separate(list, 3));
	}
}
