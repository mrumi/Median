

public class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x)
		{
			val=x;
			right=null;
			left=null;
		}
		
		public void setright(TreeNode n)
		{
			right = n;
		}
		
		public void setleft(TreeNode n)
		{
			left = n;
		}
	}