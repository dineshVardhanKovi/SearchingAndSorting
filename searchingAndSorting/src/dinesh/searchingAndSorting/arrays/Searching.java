package dinesh.searchingAndSorting.arrays;

public class Searching {
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9};
		//System.out.println(linearSearch(array, 6));
		//System.out.println(binarySearchIterative(array, 31));
		//System.out.println(binarySearchRecursive(array, 31,0,array.length-1));
		//System.out.println(jumpSearch(array, 9));
		System.out.println(interpolationSearch(array, 19));
	
	}

	//linear search
	public static boolean linearSearch(int[] array,int x) {
		for (int i = 0; i < array.length; i++) {
			if(array[i] == x) {
				return true;
			}
		}
		return false;
	}

	//iterative binary search
	public static boolean binarySearchIterative(int[] array,int x) {
		int low = 0;
		int high = array.length-1;
		while(low <= high) {
			int mid = low+(high-1)/2;
			if(array[mid] == x) {
				return true;
			}else if (array[mid] < x) {
				low = mid +1;
			}else {
				high = mid -1;
			}
		}		
		return false;
	}

	//recursive binary search
	public static boolean binarySearchRecursive(int[] array,int x,int low,int high) {
		while(low <= high) {
			int mid = low+(high-1)/2;
			if(array[mid] == x) {
				return true;
			}else if (array[mid] < x) {
				return binarySearchRecursive(array, x, mid + 1,high);
			}else {
				return binarySearchRecursive(array, x, low,mid -1 );
			}
		}		
		return false;
	}

	//jump search
	public static boolean jumpSearch(int[] array,int x) {
		int prev = 0;
		int n = array.length;
		int step = (int) Math.sqrt(n);


		// Finding the block where element is present (if it is present) 
		while(array[Math.min(step,n)-1] < x) {
			prev = step;
			step += step;
			if(prev >= n) {
				return false;
			}
		}

		// Doing a linear search for x in block  beginning with prev. 
		while(array[prev] <x) {
			prev++;

			// If we reached next block or end of array, element is not present. 
			if(prev == Math.min(step, n)) {
				return false;
			}
		}

		// If element is found 
		if(array[prev] == x) {
			return true;
		}
		return false;
	}

	public static boolean interpolationSearch(int[] array,int x) {

		int low = 0;
		int high = array.length-1;

		
		
		while(low <= high) {
			
			int pos = low + ( (x-array[low]) * ((high-low)	/ (array[high] - array[low])) );	
		
			if(array[pos] == x) {
				return true;
			}else if (array[pos] < x) {
				low = pos +1;
			}else {
				high = pos-1;
			}
		}		
		return false;
	}
}
