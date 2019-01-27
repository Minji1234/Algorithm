import java.util.Random;

public class IntTree {
	public IntTreeNode root;
	
	public IntTree(IntTreeNode node)
	{
		root = node;
	}
	public IntTree(int height) // generate full binary tree with input height (value between 1 to 100)
	{
		Random rand = new Random();
		root = new IntTreeNode(1 + rand.nextInt(100));
		if (height > 1)
		{
			root.fillTree(height - 1);
		}
	}
	public int getSize()
	{
		if (root == null)
			return 0;
		return root.getSize();
	}
	public IntTreeNode getRoot()
	{
		return root;
	}
	public void preOrder()
	{
		preOrder(root);
		System.out.println();
	}
	private void preOrder(IntTreeNode node)
	{
		if (node != null)
		{
			System.out.print(node.getVal() + " ");
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}
	public void inOrder()
	{
		inOrder(root);
		System.out.println();
	}
	private void inOrder(IntTreeNode node)
	{
		if (node != null)
		{
			inOrder(node.getLeft());
			System.out.print(node.getVal()+" ");
			inOrder(node.getRight());
		}
	}
	public void postOrder()
	{
		postOrder(root);
		System.out.println();
	}
	private void postOrder(IntTreeNode node)
	{
		if (node != null)
		{
			postOrder(node.getLeft());
			postOrder(node.getRight());
			System.out.print(node.getVal() + " ");
		}
	}
	public int getHeight()
	{
		if (root == null)
			return 0;
		return root.getHeight(root);
	}
	public int getMin()
	{
		assert root != null;
		if (this instanceof BST)
		{
			return root.getMin();
		}
		else // this instanceof IntTree (not BST)
		{
			return root.getMin4Tree();
		}
	}
	public int getMax()
	{
		assert root != null;
		if (this instanceof BST)
		{
			return root.getMax();
		}
		else // this instanceof IntTree (not BST)
		{
			return root.getMax4Tree();
		}
	}
	public void printTree()
	{
		printTree(root, "");
		System.out.println();
	}
	private void printTree(IntTreeNode node, String tab)
	{
		if (node != null)
		{
			printTree(node.getRight(), tab + "	");
			System.out.println(tab + node.getVal());
			printTree(node.getLeft(), tab + "	");
		}
	}
	public String inOrderStr()
	{
		return inOrderStr(root, "");
	}
	private String inOrderStr(IntTreeNode node, String str)
	{
		String tmp = str;
		if (node != null)
		{
			tmp += inOrderStr(node.getLeft(), str);
			tmp += (node.getVal()+" ");
			tmp += inOrderStr(node.getRight(), str);
		}
		return tmp;
	}
	public boolean check() // check whether this tree satisfies BTS's characteristics.
	{
		String str = inOrderStr();
		String[] arr = str.split(" ");
		int[] nuArr = new int[arr.length];
		for (int i = 0; i < nuArr.length; i++)
		{
			nuArr[i] = Integer.parseInt(arr[i]);
		}
		for (int i = 0; i < nuArr.length - 1; i++)
		{
			if (nuArr[i] > nuArr[i+1])
				return false;
		}
		return true;
	}
	public void printCondition()
	{
		System.out.println();
		System.out.println();
		printTree();
		System.out.println("size: " + getSize());
		System.out.println("Tree Height: " + getHeight());
		if (root != null)
		{
			System.out.println("Min: " + getMin() + ", Max: " + getMax());
			System.out.print("PreOrder: ");
			preOrder();
			System.out.print("InOrder: ");
			inOrder();
			System.out.print("PostOrder: ");
			postOrder();
			System.out.println("Is this a BST?: " + check());
			System.out.println();
			System.out.println();
		}
		else
		{
			System.out.println("Root is null. Finish.");
			System.exit(0);
		}
	}
	public static void main(String[] args)
	{
		IntTree tree = new IntTree(new IntTreeNode(42));
		IntTreeNode root = tree.getRoot();
		IntTreeNode a = root.setLeft(15);
		IntTreeNode b = root.setRight(9);
		IntTreeNode c = a.setRight(27);
		IntTreeNode d = b.setLeft(86);
		IntTreeNode e = b.setRight(3);
		c.setLeft(48);
		IntTreeNode f = d.setRight(12);
		e.setRight(39);
		f.setLeft(5);
		tree.printCondition();
	
		IntTree tree2 = new IntTree(3);
		tree2.printCondition();
	}
}
