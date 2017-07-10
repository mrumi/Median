
public class Median {
	
	public static double MedianSortedArrays(int[] A,int [] B)
	{
		int m=A.length,n=B.length;
		int l=(m+n+1)/2;
		int r = (m+n+2)/2;
		return (kth_num(A,0,B,0,l)+kth_num(A,0,B,0,r))/2.0;
	}
	
	public static double kth_num(int[]A, int as, int[] B, int bs,int k)
	{
		if(as >A.length-1) return B[bs+k-1];
		if(bs>B.length-1) return A[as+k-1];
		if(k ==1) return Math.min(A[as], B[bs]);
		
		int aMid = Integer.MAX_VALUE,bMid = Integer.MAX_VALUE;
		if(as+k/2-1<A.length) aMid = A[as+k/2 -1];
		if(bs+ k/2-1 <B.length) bMid = B[bs+k/2-1];
		
		if(aMid < bMid)
			return kth_num(A,as+k/2,B,bs,k-k/2);
		else
			return kth_num(A,as,B,bs+k/2,k-k/2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array1 = {1,3};
		int [] array2 = {2};
		System.out.println(MedianSortedArrays(array1,array2));
	}

}
