package exercisesInClass;

import java.util.Arrays;

public class QuickSort {
	/*
	 * Worst Time Complexity: O(n^2). Worst case occurs when arr is sorted.
	 * 
	 * Best and Average Case Time Complexity: O(nlogn).
	 *
	 * Auxiliary Space: O(1)
	 * 
	 * Stable: No
	 * 
	 */
	public static int[] quickSort(int[] arr) {
		int[] res = Arrays.copyOf(arr, arr.length);
		return quickSort(res, 0, arr.length - 1);
	}

	private static int[] quickSort(int[] arr, int begin, int end) {
		if (begin < end) {
			int partition = partition(arr, begin, end);
			quickSort(arr, begin, partition - 1);
			quickSort(arr, partition + 1, end);
		}
		return arr;
	}

	private static int partition(int[] arr, int begin, int end) {
		int pivot = begin;
		int i = begin + 1, j = end;
		while (i < j) {
			while (i < j && arr[i] <= arr[pivot]) {
				i++;
			}
			while (i < j && arr[j] > arr[pivot]) {
				j--;
			}
			swap(arr, i, j);
		}
		if (arr[pivot] > arr[i]) {
			swap(arr, pivot, i);
		}
		return i;
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		int[] arr = { 50, 20, 60, 30, 18, 12, 62, 15, 3 };
		System.out.println("quickSort:" + Arrays.toString(quickSort(arr)));
	}
}
