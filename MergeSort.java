package assignment01;

import java.util.Arrays;

public class MergeSort extends Sort {
	
	public static double[] getLeft(double[] arr) {
		int size = arr.length / 2;
		double[] left = Arrays.copyOfRange(arr, 0, size);
		return left;
	}
	
	public static double[] getRight(double[] arr) {
		int size = arr.length / 2;
		double[] right = Arrays.copyOfRange(arr, size, arr.length);
		return right;
	}
	
	public static void merge(double[] arr, double[] left, double[] right) {
		int li = 0, ri = 0, ai = 0;
		
		while (ai < arr.length) {
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
		if (arr.length > 1) {
			double[] left = getLeft(arr);
			double[] right = getRight(arr);
			
			sort(left);
			sort(right);
			merge(arr, left, right);
		}
		return arr;
	}

}
