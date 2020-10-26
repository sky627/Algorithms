package exercisesInClass;

import java.util.Arrays;

public class Sort {
	// swap sort
	/*
	 * Average Time Complexity: O(n^2).
	 * 
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
	public int[] bubbleSort(int[] arr) {
		int[] res = Arrays.copyOf(arr, arr.length);
		for (int i = 0; i < res.length - 1; i++) {
			boolean flag = false;
			for (int j = 0; j < res.length - 1 - i; j++) {
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

	/*
	 * Average Time Complexity: O(nlogn)
	 * 
	 * Worst Time Complexity: O(n^2). Worst case occurs when arr is sorted.
	 * 
	 * Best Time Complexity: O(nlogn).
	 *
	 * Space Complexity: O(1)
	 * 
	 * Stable: No
	 * 
	 */
	public int[] quickSort(int[] arr) {
		int[] res = Arrays.copyOf(arr, arr.length);
		return quickSort(res, 0, res.length - 1);
	}

	private int[] quickSort(int[] arr, int begin, int end) {
		if (begin < end) {
			int partition = partition(arr, begin, end);
			quickSort(arr, begin, partition - 1);
			quickSort(arr, partition + 1, end);
		}
		return arr;
	}

	private int partition(int[] arr, int begin, int end) {
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
			return i;
		} else {
			swap(arr, pivot, i - 1);
			return i - 1;
		}
	}

	// selection sort
	/*
	 * Average Time Complexity: O(n^2)
	 * 
	 * Worst Time Complexity: O(n^2)
	 * 
	 * Best Time Complexity: O(n^2)
	 *
	 * Space Complexity: O(1)
	 * 
	 * Stable: No
	 * 
	 */
	public int[] selectionSort(int[] arr) {
		int[] res = Arrays.copyOf(arr, arr.length);
		for (int i = 0; i < res.length - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < res.length; j++) {
				if (res[minIdx] > res[j]) {
					minIdx = j;
				}
			}
			swap(res, i, minIdx);
		}
		return res;
	}

	/*
	 * 
	 * Time complexity: build heap:O(nlogn) + sort:O(n*lgn) = O(nlogn)
	 * 
	 * Average Time Complexity: O(nlogn)
	 * 
	 * Worst Time Complexity: O(nlogn)
	 * 
	 * Best Time Complexity: O(nlogn)
	 *
	 * Space Complexity: O(1)
	 * 
	 * Stable: No
	 * 
	 */
	public int[] heapSort(int[] arr) {
		int[] tmp = Arrays.copyOf(arr, arr.length);
		heapify(tmp);
		int idx = 0, size = tmp.length;
		int[] res = new int[size];
		while (size > 0) {
			res[idx++] = tmp[0];
			tmp[0] = tmp[size - 1];
			heapify(tmp, 0, --size);
		}
		return res;
	}

	private void heapify(int[] arr) {
		for (int i = (arr.length - 2) / 2; i >= 0; i--) {
			heapify(arr, i, arr.length);
		}
	}

	private void heapify(int[] arr, int idx, int size) {
		int leftIdx = 2 * idx + 1, rightIdx = 2 * idx + 2, minIdx = idx;
		if (rightIdx < size && arr[minIdx] > arr[rightIdx]) {
			minIdx = rightIdx;
		}
		if (leftIdx < size && arr[minIdx] > arr[leftIdx]) {
			minIdx = leftIdx;
		}
		if (minIdx != idx) {
			swap(arr, idx, minIdx);
			heapify(arr, minIdx, size);
		}
	}

	// insertion sort
	/*
	 * Average Time Complexity: O(n^2)
	 * 
	 * Worst Time Complexity: O(n^2)
	 * 
	 * Best Time Complexity: O(n)
	 *
	 * Space Complexity: O(1)
	 * 
	 * Stable: Yes
	 * 
	 */
	public int[] insertionSort(int[] arr) {
		int[] res = Arrays.copyOf(arr, arr.length);
		for (int i = 1; i < res.length; i++) {
			int j = i - 1, cur = res[i];
			if (cur < res[j]) {
				while (j >= 0 && cur < res[j]) {
					res[j + 1] = res[j];
					j--;
				}
				res[j + 1] = cur;
			}
		}
		return res;
	}

	/*
	 * Average Time Complexity: O(n^1.3)
	 * 
	 * Worst Time Complexity: O(nlogn)
	 * 
	 * Best Time Complexity: O(n)
	 *
	 * Space Complexity: O(1)
	 * 
	 * Stable: No
	 * 
	 */
	public int[] shellSort(int[] arr) {
		int[] res = Arrays.copyOf(arr, arr.length);
		for (int gap = res.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < res.length; i++) {
				int j = i - gap, cur = res[i];
				if (cur < res[j]) {
					while (j >= 0 && cur < res[j]) {
						res[j + gap] = res[j];
						j -= gap;
					}
					res[j + gap] = cur;
				}
			}
		}
		return res;
	}

	// merge sort
	/*
	 * Average Time Complexity: O(nlogn)
	 * 
	 * Worst Time Complexity: O(nlogn)
	 * 
	 * Best Time Complexity: O(nlogn)
	 *
	 * Space Complexity: O(n)
	 * 
	 * Stable: Yes
	 * 
	 */
	public int[] mergeSort(int[] arr) {
		if (arr.length == 0) {
			return arr;
		}
		int[] res = Arrays.copyOf(arr, arr.length);
		return mergeSort(res, 0, res.length - 1);
	}

	private int[] mergeSort(int[] arr, int begin, int end) {
		if (begin < end) {
			int mid = begin + (end - begin) / 2;
			int[] left = mergeSort(arr, begin, mid);
			int[] right = mergeSort(arr, mid + 1, end);
			int idx = 0, i = 0, j = 0;
			while (i < left.length) {
				arr[begin + idx++] = left[i++];
			}
			while (j < right.length) {
				arr[begin + idx++] = right[j++];
			}
			return merge(arr, begin, mid, end);
		}
		return new int[] { arr[begin] };
	}

	private int[] merge(int[] arr, int begin, int mid, int end) {
		int[] res = new int[end - begin + 1];
		int idx = 0, i = begin, j = mid + 1;
		while (idx < res.length) {
			while (i <= mid && j <= end) {
				if (arr[i] <= arr[j]) {
					res[idx++] = arr[i++];
				} else {
					res[idx++] = arr[j++];
				}
			}
			while (i <= mid) {
				res[idx++] = arr[i++];
			}
			while (j <= end) {
				res[idx++] = arr[j++];
			}
		}
		return res;
	}

	/*
	 * Average Time Complexity: O(n+k)
	 * 
	 * Worst Time Complexity: O(n+k)
	 * 
	 * Best Time Complexity: O(n+k).
	 *
	 * Space Complexity: O(n+k)
	 * 
	 * Stable: Yes
	 * 
	 */
	public int[] countingSort(int[] arr) {
		int[] res = Arrays.copyOf(arr, arr.length);
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int num : res) {
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		int[] buckets = new int[max - min + 1];
		for (int num : res) {
			buckets[num - min]++;
		}
		int idx = 0;
		for (int i = 0; i < buckets.length; i++) {
			while (buckets[i] != 0) {
				res[idx++] = min + i;
				buckets[i]--;
			}
		}
		return res;
	}

	/*
	 * Average Time Complexity: O(kn)
	 * 
	 * Worst Time Complexity: O(kn)
	 * 
	 * Best Time Complexity: O(kn).
	 *
	 * Space Complexity: O(kn)
	 * 
	 * Stable: Yes
	 * 
	 */
	public int[] radixSort(int[] arr) {
		int[] plus = new int[arr.length];
		int[] minus = new int[arr.length];
		int plusNum = 0, minusNum = 0;
		for (int num : arr) {
			if (num >= 0) {
				plus[plusNum++] = num;
			} else {
				minus[minusNum++] = -num;
			}
		}
		plus = radixSort(plus, plusNum);
		minus = radixSort(minus, minusNum);
		int[] res = Arrays.copyOf(arr, arr.length);
		int idx = 0, plusIdx = 0, minusIdx = minusNum - 1;
		while (idx < minusNum) {
			res[idx++] = -minus[minusIdx--];
		}
		while (idx < res.length) {
			res[idx++] = plus[plusIdx++];
		}
		return res;
	}

	private int[] radixSort(int[] arr, int size) {
		int[] res = Arrays.copyOf(arr, size);
		int maxNum = Integer.MIN_VALUE;
		for (int i = 0; i < res.length; i++) {
			maxNum = Math.max(res[i], maxNum);
		}
		int maxBit = String.valueOf(maxNum).length();
		for (int i = 0; i < maxBit; i++) {
			int[] tmp = Arrays.copyOf(res, res.length);
			int[][] buckets = new int[10][res.length];
			int[] eachBucketSize = new int[10];
			for (int j = 0; j < res.length; j++) {
				for (int k = 0; k < i && tmp[j] > 0; k++) {
					tmp[j] /= 10;
				}
				int curBucketNum = tmp[j] % 10;
				buckets[curBucketNum][eachBucketSize[curBucketNum]++] = res[j];
			}
			int idx = 0;
			for (int j = 0; j < buckets.length; j++) {
				for (int k = 0; k < eachBucketSize[j]; k++) {
					res[idx++] = buckets[j][k];
				}
			}
		}
		return res;
	}

	private void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public int[] generateRandomArray(int size, int value) {
		int[] arr = new int[(int) ((size + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((value + 1) * Math.random()) - (int) (value * Math.random());
		}
		return arr;
	}

	public static void main(String[] args) {
		Sort s = new Sort();
//		int[] arr = { 50, 20, 123, 13, 88, -222, -19, 1470, 2, 13, 15, 0, 13, 0, 21, 40 };
		int[] arr = s.generateRandomArray(100000, 100);
		long a = System.nanoTime();
		System.out.println(Arrays.toString(s.bubbleSort(arr)));
		System.out.println("bubbleSort:" + (System.nanoTime() - a));

		a = System.nanoTime();
		System.out.println(Arrays.toString(s.quickSort(arr)));
		System.out.println("quickSort:" + (System.nanoTime() - a));

		a = System.nanoTime();
		System.out.println(Arrays.toString(s.insertionSort(arr)));
		System.out.println("insertionSort:" + (System.nanoTime() - a));

		a = System.nanoTime();
		System.out.println(Arrays.toString(s.shellSort(arr)));
		System.out.println("shellSort:" + (System.nanoTime() - a));

		a = System.nanoTime();
		System.out.println(Arrays.toString(s.selectionSort(arr)));
		System.out.println("selectionSort:" + (System.nanoTime() - a));

		a = System.nanoTime();
		System.out.println(Arrays.toString(s.heapSort(arr)));
		System.out.println("heapSort:" + (System.nanoTime() - a));

		a = System.nanoTime();
		System.out.println(Arrays.toString(s.mergeSort(arr)));
		System.out.println("mergeSort:" + (System.nanoTime() - a));

		a = System.nanoTime();
		System.out.println(Arrays.toString(s.countingSort(arr)));
		System.out.println("countingSort:" + (System.nanoTime() - a));

		a = System.nanoTime();
		System.out.println(Arrays.toString(s.radixSort(arr)));
		System.out.println("radixSort:" + (System.nanoTime() - a));

		a = System.nanoTime();
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("systemSort:" + (System.nanoTime() - a));
	}
}