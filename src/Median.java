import java.util.*;

public class Median {
	
	/* median of two sorted arrays.*/
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
	/*Regular expression matching*/
	
	public static boolean isMatch(String s, String p)
	{
		if(s==null|| p==null)
			return false;
		boolean [][] dp = new boolean[s.length()+1][p.length()+1];
		dp[0][0] = true;
		for(int i=0;i<p.length();i++)
		{
			if(p.charAt(i) == '*' && dp[0][i-1])
			{
				dp[0][i+1]=true;
			}
		}
		for(int i=0;i<s.length();i++)
		{
			for(int j=0;j<p.length();j++)
			{
				if(p.charAt(j) == '.')
				{
					dp[i+1][j+1] =dp[i][j];
				}
				if(p.charAt(j)==s.charAt(i))
				{
					dp[i+1][j+1]=dp[i][j];
				}
				if(p.charAt(j)=='*')
				{
					if(p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '*')
					{
						dp[i+1][j+1]=dp[i+1][j-1];
					}
					else
					{
						dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
					}
				}
			}
		}
		for(int i=0;i<s.length();i++)
		{
			for(int j=0;j<p.length();j++)
			{
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return dp[s.length()][p.length()];
	}
	
	/*binary tree maximum path sum*/
	
	static int maxvalue;
	
	
	
	public static int maxsum(TreeNode root)
	{
		maxvalue=Integer.MIN_VALUE;
		max_traverse(root);
		return maxvalue;
		
	}
	
	public static void  max_traverse(TreeNode root)
	{
		if(root == null)
			return;
			//return 0;
		int left = Math.max(0, root.left.val);
		int right = Math.max(0, root.right.val);
		maxvalue = Math.max(maxvalue,left+right+root.val);
		//return Math.max(left, right)+root.val;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* median of two sorted arrays.
		int [] array1 = {1,3};
		int [] array2 = {2};
		System.out.println(MedianSortedArrays(array1,array2));*/
		
		/*regular expression matching
		String s1="aab";
		String s2="c*a*b";
		System.out.println(isMatch(s1,s2));*/
		
		TreeNode rt = new TreeNode(1);
		TreeNode rt1 = new TreeNode(2);
		TreeNode rt2 = new TreeNode(3);
		rt.setleft(rt1);
		rt.setright(rt2);
		max_traverse(rt);
		System.out.println(maxvalue);
	}

}
