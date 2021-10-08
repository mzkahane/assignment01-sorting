package assignment01;

public class QuickSort extends Sort {

	public void swap(double[] arr, int i, int j) {
		double temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public int partition(double[] arr, int left, int right) {
		int pivot = right;
		int bot = left;
		int top = right-1;
		
		if (left < right) {
			
			while (bot <= top) {
				while (bot < right && arr[bot] < arr[pivot]) {
					++bot;
				}
				while (top >= bot && arr[top] >= arr[pivot]) {
					--top;
				}
				if (bot < top) {
					swap(arr, bot, top);
				} else {
					swap(arr, bot, pivot);
				}
			}
		}
		return bot;
	}
	
	public double[] quickSort(double[] arr, int bot, int top) {
		if (bot < top) {
			int p = partition(arr, bot, top);
			quickSort(arr, bot, p-1);
			quickSort(arr, p+1, top);
		}
		return arr;
	}
	
	@Override
	public double[] sort(double[] arr) {
		int bot = 0, top = arr.length-1;
		quickSort(arr, bot, top);
		return arr;
	}

}
