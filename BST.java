public class BST extends IntTree
{
	
	public BST(IntTreeNode node)
	{
		super(node);
	}
	public BST(int height) // generate full BST with input height (value from 1)
	{
		super(null);
		root = new IntTreeNode(1);
		if (height > 1)
		{
			root.fillBST(height - 1);
			root.setBST(root);
			IntTreeNode.counts = 0; // reset
		}
	}
	public boolean contains(int v)
	{
		return contains(root, v);
	}
	private boolean contains(IntTreeNode node, int v)
	{
		if (node != null)
		{
			int val = node.getVal();
			if (v > val)
				return contains(node.getRight(), v);
			else if (v < val)
				return contains(node.getLeft(), v);
			else
				return true;
		}
		else
			return false;
	}
	public void add(int v)
	{
		root = add(root, v);
	}
	private IntTreeNode add(IntTreeNode node, int v)
	{
		if (node != null)
		{
			if (v > node.getVal())
				node.setRight(add(node.getRight(), v));
			else if (v < node.getVal())
				node.setLeft(add(node.getLeft(), v));
			else // duplicate
				return node;
			return node;
		}
		else // node == null
		{
			return new IntTreeNode(v);
		}
	}
	public void remove(int v) // remove v, if it exists.
	{
		root = remove(root, v);
	}
	private IntTreeNode remove(IntTreeNode node, int v)
	{
		int value = node.getVal();
		if (node != null)
		{
			if (value < v)
				node.setRight(remove(node.getRight(), v));
			else if (value > v)
				node.setLeft(remove(node.getLeft(), v));
			else // value == v
			{
				if (node.getLeft() == null && node.getRight() == null)
					return null;
				else if (node.getLeft() != null && node.getRight() == null)
					return node.getLeft();
				else if (node.getLeft() == null && node.getRight() != null)
					return node.getRight();
				else // node.getLeft() != null && node.getRight() != null
				{
					int min = node.getRight().getMin();
					node.setVal(min);
					node.setRight(remove(node.getRight(), min));
					return node;
				}
			}
		}
		return node;
	}
	public static void main(String[] args)
	{
		BST tree = new BST(4);
		tree.printCondition();
		System.out.println("Does this contain 15?: " + tree.contains(15)); // true
		System.out.println("Does this contain 16?: " + tree.contains(16)); // false
		
		System.out.println();
		System.out.println();
		BST tree2 = new BST(new IntTreeNode(42));
		tree2.add(42);
		tree2.add(15);
		tree2.add(9);
		tree2.add(27);
		tree2.add(86);
		tree2.add(3);
		tree2.add(48);
		tree2.add(12);
		tree2.add(39);
		tree2.printCondition();
		tree2.remove(3);
		System.out.println("Removal: 3");
		tree2.printCondition();
		tree2.remove(42);
		System.out.println("Removal: 42");
		tree2.printCondition();
		tree2.remove(15);
		System.out.println("Removal: 15");
		tree2.printCondition();
		tree2.remove(9);
		System.out.println("Removal: 9");
		tree2.printCondition();
		tree2.remove(48);
		System.out.println("Removal: 48");
		tree2.printCondition();
		tree2.remove(12);
		System.out.println("Removal: 12");
		tree2.printCondition();
		tree2.remove(39);
		System.out.println("Removal: 39");
		tree2.printCondition();
		tree2.remove(86);
		System.out.println("Removal: 86");
		tree2.printCondition();
		tree2.remove(27);
		System.out.println("Removal: 27");
		tree2.printCondition();
	}
}
