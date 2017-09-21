package com.fortinet.cc.question2;

import static org.junit.Assert.*;

import org.junit.Test;

public class SumOfMultiDimensionalArrayTest {

	@Test
	public void testNullArray() {
		int[] dimensions = new int[0];
		long sum = SumOfMultiDimensionalArray.sum(null, dimensions);
		assertTrue(sum == 0);
	}
	
	@Test
	public void testNullDimension() {
		int[] dimensions = new int[1];
		dimensions[0] = 0;
		MultiDimensionArray mArray = new MultiDimensionArray(dimensions);
		long sum = SumOfMultiDimensionalArray.sum(mArray, null);
		assertTrue(sum == 0);
	}
	
	@Test
	public void testNoInput() {
		int[] dimensions = new int[1];
		dimensions[0] = 0;
		MultiDimensionArray mArray = new MultiDimensionArray(dimensions);
		long sum = SumOfMultiDimensionalArray.sum(mArray, dimensions);
		assertTrue(sum == 0);
	}
	
	@Test
	public void testValidInput() {
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
					mArray.setData(indexOfDimension, v);
				}
			}			
		}
		long s = 0;
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				for(int k=0; k<2; k++) {
					s += mArray.getValue(new int[]{i,j,k});					
				}
			}			
		}
		
		long sum = SumOfMultiDimensionalArray.sum(mArray, dimensions);
		assertTrue(s == sum);
	}
	
	@Test
	public void testLargeInput() {
		int[] dimensions = new int[5];
		dimensions[0] = 2;
		dimensions[1] = 2;
		dimensions[2] = 2;
		dimensions[3] = 2;
		dimensions[4] = 2;
		MultiDimensionArray mArray = new MultiDimensionArray(dimensions);
		for(int i=0; i<dimensions[0]; i++) {
			for(int j=0; j<dimensions[1]; j++) {
				for(int k=0; k<dimensions[2]; k++) {
					for(int x=0; x<dimensions[3]; x++) {
						for(int y=0; y<dimensions[4]; y++) {
							long v = 0 + (long) (Math.random() * (100 - 0));
							mArray.setData(new int[]{i,j,k,x,y}, v);
						}
					}
				}
			}			
		}
		
		long s = 0;
		for(int i=0; i<dimensions[0]; i++) {
			for(int j=0; j<dimensions[1]; j++) {
				for(int k=0; k<dimensions[2]; k++) {
					for(int x=0; x<dimensions[3]; x++) {
						for(int y=0; y<dimensions[4]; y++) {
							s += mArray.getValue(new int[]{i,j,k,x,y});
						}
					}
				}
			}			
		}
		long sum = SumOfMultiDimensionalArray.sum(mArray, dimensions);
		assertTrue(s == sum);
	}

}
