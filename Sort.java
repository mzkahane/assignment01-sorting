package assignment01;

import java.util.Arrays;
import java.util.Random;

public abstract class Sort { 
	
	public abstract double[] sort(double[] arr);
	
	public static double[] makeArray(int size) {
		Random random = new Random();
		double[] arr = new double[size];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextDouble();
		}
		return arr;
	} 
	
	public static void checkSort(double[] sortedArr) throws Exception {
		for (int i = 1; i < sortedArr.length; i++) {
			if (sortedArr[i-1] > sortedArr[i]) {
				throw new Exception("Array not sorted!");
			}
		}
	} 
	
	public static void main(String args[]) throws Exception {
		double[] unsortedArr;
		double[] sortedArr;
		
		long[] SSTimes = new long[10];
		long[] BSTimes = new long[10];
		long[] ISTimes = new long[10];
		long[] MSTimes = new long[10];
		long[] QSTimes = new long[10];
		long[] FMTimes = new long[10];
		
		for (int i = 0, size = 50000; i <= 10 && size <= 500000; i++, size += 50000) {
			long start;
			long stop;
			
			unsortedArr = makeArray(size);
			
			// Selection Sort
			SelectionSort selectionSort = new SelectionSort();
			
			start = System.currentTimeMillis();
			sortedArr = selectionSort.sort(Arrays.copyOf(unsortedArr, unsortedArr.length));
			stop = System.currentTimeMillis();
			
			checkSort(sortedArr);
			SSTimes[i] = stop - start;
			
			// Bubble Sort
			BubbleSort bubbleSort = new BubbleSort();
			
			start = System.currentTimeMillis();
			sortedArr = bubbleSort.sort(Arrays.copyOf(unsortedArr, unsortedArr.length));
			stop = System.currentTimeMillis();
			
			checkSort(sortedArr);
			BSTimes[i] = stop - start;
			
			// Insertion Sort
			InsertionSort insertionSort = new InsertionSort();
			
			start = System.currentTimeMillis();
			sortedArr = insertionSort.sort(Arrays.copyOf(unsortedArr, unsortedArr.length));
			stop = System.currentTimeMillis();
			
			checkSort(sortedArr);
			ISTimes[i] = stop - start;
			
			// Merge Sort
			MergeSort mergeSort = new MergeSort();
			
			start = System.currentTimeMillis();
			sortedArr = mergeSort.sort(Arrays.copyOf(unsortedArr, unsortedArr.length));
			stop = System.currentTimeMillis();
			
			checkSort(sortedArr);
			MSTimes[i] = stop - start;
			
			// Quick Sort
			QuickSort quickSort = new QuickSort();
			
			start = System.currentTimeMillis();
			sortedArr = quickSort.sort(Arrays.copyOf(unsortedArr, unsortedArr.length));
			stop = System.currentTimeMillis();
			
			checkSort(sortedArr);
			QSTimes[i] = stop - start;
			
//			// Faster Merge Sort: Assignment 1 Part 2
//			FasterMergeSort FmergeSort = new FasterMergeSort();
//			
//			start = System.currentTimeMillis();
//			sortedArr = FmergeSort.sort(Arrays.copyOf(unsortedArr, unsortedArr.length));
//			stop = System.currentTimeMillis();
//			
//			checkSort(sortedArr);
//			FMTimes[i] = stop - start;
		}
		
		System.out.println("SS: " + Arrays.toString(SSTimes));
		System.out.println("BS: " + Arrays.toString(BSTimes));
		System.out.println("IS: " + Arrays.toString(ISTimes));
		System.out.println("MS: " + Arrays.toString(MSTimes));
		System.out.println("QS: " + Arrays.toString(QSTimes));
		System.out.println("FM: " + Arrays.toString(FMTimes));
		
	}
}
