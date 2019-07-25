package mergeSort;

/**
 * @author Tristan
 * @date   2019年7月24日
 * @time   下午5:31:07
 */
public class Solution {
	public void mergeSort(int[] arr, int low, int high) {
		int mid = (low + high)/2;
		if (low < high) {
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
		
			merge(arr, low, mid, high);
		}
	}
	
	public void merge(int[] arr, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int k = 0;
		int i = low;
		int j = mid + 1;
		while(i <= mid && j <= high) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		
		while (i <= mid) {
			temp[k++] = arr[i++];
		}
		
		while (j <= high) {
			temp[k++] = arr[j++];
		}
		
		for (int x = 0; x < temp.length; x++) {
			arr[x + low] = temp[x];
		}
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr = {14, 12, 15, 11, 16};
		s.mergeSort(arr, 0, 4);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print("[" + arr[i]  + "]" +" ");
		}
	}
}
