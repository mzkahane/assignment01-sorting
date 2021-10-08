package assignment01;

import java.util.Arrays;

public class FasterMergeSort extends Sort{
	
	// Finds and returns the index of the last element of the next sorted region
	public int findNext(double[] arr, int start) {		
		int index = start;
		for (int i = start; i < arr.length-1; i++) {
			if (arr[i] < arr[i+1]) {
				index++;
			} else {
				return index;
			}
		}
		return index;
	}
	
	public void merge(double[] arr, double[] left, double[] right) {
		int li = 0, ri = 0, ai = 0;
		
		while (li < left.length || ri < right.length) {
			if (li == left.length) {
				arr[ai++] = right[ri++];
			} else if (ri == right.length) {
				arr[ai++] = left[li++];
			} else if (left[li] < right[ri]) {
				arr[ai++] = left[li++];
			} else if (left[li] > right[ri]) {
				arr[ai++] = right[ri++];
			} else if (left[li] == right[ri]) {
				arr[ai++] = left[li++];
				arr[ai++] = right[ri++];
			}
		}
	}
	
	@Override
	public double[] sort(double[] arr) {
		int run1 = findNext(arr, 0);
		if (run1 < arr.length-1) {
			double[] left = Arrays.copyOfRange(arr, 0, run1+1);
			int run2 = findNext(arr, run1+1)+1;
			double[] right = Arrays.copyOfRange(arr, run1+1, run2);
			
			merge(arr, left, right);			
			sort(arr);

		}
		return arr;
	}
	

}
