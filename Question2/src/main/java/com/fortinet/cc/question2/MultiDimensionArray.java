package com.fortinet.cc.question2;

public class MultiDimensionArray {
	private long[] data;
	private int[] dimensions;
	private int[] parts;
	private int arraySize;
	
	public MultiDimensionArray(int[] dimensions) {
		int d = dimensions.length;
		this.parts = new int[d];
		this.dimensions = new int[d];
		
		this.parts[0] = 1;
		this.dimensions[0] = dimensions[0];
		int size = dimensions[0];
		
		for(int i= 1; i<d; i++) {
			this.parts[i] = this.parts[i-1] * this.dimensions[i-1];
			this.dimensions[i] = dimensions[i];
			size *= dimensions[i];			
		}
		
		this.arraySize = size;	
		data = new long[arraySize];
	}
	
	public void setData(int[] indexOfDimension, long value) {
		int index = getIndex(indexOfDimension);
		data[index] = value;
	}
	
	public int getIndex(int[] indexOfDimension) {
		int index = 0;
		for(int i=0; i<indexOfDimension.length; i++) {
			index += indexOfDimension[i] * parts[i];
		}
		
		return index;
	}
	
	public long getValue(int[] indexOfDimension) {
		int index = getIndex(indexOfDimension);
		
		return data[index];
	}
	
	public int getSize() {
		return arraySize;
	}

}
