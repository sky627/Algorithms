package exercisesInClass;

import java.util.Arrays;

public class BubbleSort {
	/*
	 * Worst Time Complexity: O(n^2). Worst case occurs when arr is reverse sorted.
	 * 
	 * Best Time Complexity: O(n). Best case occurs when arr is already sorted.
	 *
	 * Space Complexity: O(1)
	 * 
	 * Stable: Yes
	 * 
	 * Due to its simplicity, bubble sort is often used to introduce the concept of
	 * a sorting algorithm. In computer graphics it is popular for its capability to
	 * detect a very small error (like swap of just two elements) in almost-sorted
	 * arrs and fix it with just linear complexity (2n).
	 */
	public static int[] bubbleSort(int[] arr) {
		int[] res = Arrays.copyOf(arr, arr.length);
		for (int i = 0; i < arr.length - 1; i++) {
			boolean flag = false;
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (res[j] > res[j + 1]) {
					swap(res, j, j + 1);
					flag = true;
				}
			}
			if (!flag) {
				break;
			}
		}
		return res;
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		int[] arr = { 50, 20, 60, 30, 18, 12, 62, 15, 3 };
		System.out.println("bubbleSort:" + Arrays.toString(bubbleSort(arr)));
	}
}
