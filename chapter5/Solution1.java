package chapter5;

public class Solution1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[]={2,3,4,5,6,8,10,100,0,0,0,0,0,0};
		int b[]={1,4,5,7,8,8};
		merge(a,b,8,6);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public static void merge(int[] a,int[] b,int lastA,int lastB){
		int indexA=lastA-1;
		int indexB=lastB-1;
		int indexMerge=lastA+lastB-1;
		while(indexB>=0){
			if(indexA>=0 && a[indexA]>b[indexB]){
				a[indexMerge]=a[indexA];
				indexA--;
			}
			else{
				a[indexMerge]=b[indexB];
				indexB--;
			}
			indexMerge--;
		}
	}
}
