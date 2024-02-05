package com.isc;

public class BinarySearch {
	public static void main(String ar[]) {
		int bs[] = {4,8,16,24,42,56,78,88,99};
		System.out.println(binarySearch(bs,78));
	}
	
	public static int binarySearch(int bs[] ,  int key) {
		int low = 0;
		int high = bs.length - 1;
		while(low <= high) {
			int mid =  (low + high) / 2;
			if(key == bs[mid]) {return mid;}
			
			if(key > mid) {
				low = mid+1 ;
			}
			if(key < bs[mid]) { high = mid - 1 ;}
		}
		return -1;
	}
}
