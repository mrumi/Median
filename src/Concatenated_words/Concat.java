package Concatenated_words;

import java.util.*;
import java.lang.*;

public class Concat {
	static class TreeNode{
		TreeNode[] kids;
		String main_word;
		boolean is_con;
		boolean isadd;
		boolean end;
		
		public TreeNode()
		{
			this.kids = new TreeNode[26];
			this.main_word =  new String();
			this.is_con=false;
			this.isadd=false;
			this.end=false;
		}
	}
		
		private static void word_inc(String str)
		{
			TreeNode node = root;
			for(char ch : str.toCharArray())
			{
				if(node.kids[ch - 'a'] == null)
				{
					node.kids[ch - 'a']= new TreeNode();
				}
				node = node.kids[ch - 'a'];
			}
			node.end = true;
			node.main_word = str;
		}
	
	
	private static TreeNode root;
	private static ArrayList<String> result;
	public static ArrayList<String> concatenate_words(String[] list_word)
	{
		root = new TreeNode();
		for(String str : list_word)
		{
			if(str.length()==0)
				continue;
			word_inc(str);
		}
		
		result = new ArrayList<>();
		dfs(root,0);
		return result;
	}
	
	private static void dfs(TreeNode node, int count)
	{
		if(node.end && !node.isadd && count >1)
		{
			node.is_con = true;
			node.isadd = true;
			result.add(node.main_word);
		}
		searchword(node,root,count);
	}
	
	private static void searchword(TreeNode n1,TreeNode n2, int count)
	{
		if(n2.is_con)
			return;
		if(n2.end)
			dfs(n1,count+1);
		for(int i = 0;i< 26;i++)
		{
			if(n1.kids[i] != null && n2.kids[i]!= null)
			{
				searchword(n1.kids[i],n2.kids[i],count);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
		String [] t ={ "rain" , "flower", "fireflies", "swing", "tea","rainflowertea", "teaflower", "fall", "springrain", "spring"};
		ArrayList<String> l1 = concatenate_words(t);
		for(int i = 0; i < l1.size(); i++) {   
		    System.out.println(l1.get(i));
		}  
	}

}
