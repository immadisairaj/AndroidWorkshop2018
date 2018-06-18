import java.util.Arrays;

public class BinarySearchExample{
	
	public boolean binarySearch(int[] sortedArray,
							 int left,
							 int right,
							 int key) {
		while (left<=right) {
			int mid = left+(right-left)/2;
			if (sortedArray[mid] == key) {
				return true;
			}
			else if (sortedArray[mid] < key) {
				left = mid+1;
			}
			else {
				right = mid-1;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		int[] unsortedArray = new int[10];
		for (int i=0;i<unsortedArray.length;i++) {
			unsortedArray[i] = 1+(int)(Math.random()*10);
		}
		System.out.println("Unsorted Array");
		for (int i=0;i<unsortedArray.length;i++) {
			System.out.print(unsortedArray[i]+" ");
		}
		System.out.println();

		Arrays.sort(unsortedArray);		//Sorting Array
		int[] sortedArray = new int[10];
		sortedArray = unsortedArray;
		System.out.println("Sorted Array");
		for (int i=0;i<sortedArray.length;i++) {
			System.out.print(sortedArray[i]+" ");
		}
		System.out.println();

		int left = 0;
		int right = sortedArray.length - 1;

		int key = 1+(int)(Math.random()*10);
		System.out.println("Key is "+key);

		BinarySearchExample example = new BinarySearchExample();
		System.out.println(example.binarySearch(sortedArray,left,right,key));

		System.out.println(Arrays.binarySearch(sortedArray,key));
	}
}