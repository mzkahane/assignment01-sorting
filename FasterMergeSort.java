package assignment01;

import java.util.ArrayList;

public class FasterMergeSort extends Sort {
	// Retuns a 2D array list containing the start and end indices for each sorted region
	private static ArrayList<int[]> findSorted(double[] arr){
		ArrayList<int[]> indices = new ArrayList<int[]>();
		
		int i = 0;
		while (i < arr.length) {
			int start = i;
			while (i < arr.length-1 && arr[i+1] >= arr[i]) {
				i++;
			}
			int end = i;
			int[] index = {start, end};
			indices.add(index);
			i++;
		}
		return indices;
	}
	
	// Returns a double array from the original unsorted array given the start and end points
	public static double[] getRegion(double[] arr, int[] range) {
		int start = range[0];
		int end = range[1];
		
		double[] region = new double[(end-start)+1];
		int j = 0;
		
		for (int i = start; i <= end; i++) {
			region[j] = arr[i];
			j++;
		}
		return region;
	}
	
	// Merges two sorted regions into the original array, starting where the left array starts
	public static void merge(double[] arr, double[] left, double[] right, int start) {

		int li = 0, ri = 0, ai = start;
		
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
	
	public double[] sort(double[] arr) {

		ArrayList<int[]> indices = new ArrayList<int[]>();
		
		
		while (indices.size() != 1) {
			indices = findSorted(arr);
			
			for (int i = 0; i < indices.size()-1; i += 2) {
				double[] left = getRegion(arr, indices.get(i));
				double[] right = getRegion(arr, indices.get(i+1));
				
				merge(arr, left, right, indices.get(i)[0]);
			}
		}
		return arr;
		
	}

}
