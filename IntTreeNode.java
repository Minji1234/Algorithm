import java.util.Random;

public class IntTreeNode {
	public static int counts = 0;
	public static int min = 0;
	public static int max = 0;
	
	private int val;
	private IntTreeNode left;
	private IntTreeNode right;
	
	public IntTreeNode(int value)
	{
		this(value, null, null);
	}
	public IntTreeNode(int value, IntTreeNode l, IntTreeNode r)
	{
		val = value;
		left = l;
		right = r;
	}
	public void setVal(int value)
	{
		val = value;
	}
	public int getVal()
	{
		return val;
	}
	public IntTreeNode getLeft()
	{
		return left;
	}
	public IntTreeNode getRight()
	{
		return right;
	}
	public IntTreeNode setLeft(IntTreeNode l)
	{
		left = l;
		return left;
	}
	public IntTreeNode setLeft(int val)
	{
		left = new IntTreeNode(val);
		return left;
	}
	public IntTreeNode setRight(IntTreeNode r)
	{
		right = r;
		return right;
	}
	public IntTreeNode setRight(int val)
	{
		right = new IntTreeNode(val);
		return right;
	}
	public int getSize()
	{
		getSize(this);
		int tmp = IntTreeNode.counts;
		IntTreeNode.counts = 0;
		return tmp;
	}
	private void getSize(IntTreeNode node)
	{
		if (node != null)
		{
			getSize(node.getLeft());
			IntTreeNode.counts++;
			getSize(node.getRight());
		}
	}
	public int getHeight(IntTreeNode node)
	{
		if (node != null)
		{
			int c = getHeight(node.getLeft()) > getHeight(node.getRight()) ? getHeight(node.getLeft()) : getHeight(node.getRight());
			return c + 1;
		}
		else
			return 0;
	}
	public void fillTree(int cnt)
	{
		Random rand = new Random();
		if (cnt >= 1)
		{
			setLeft(new IntTreeNode(1 + rand.nextInt(100)));
			setRight(new IntTreeNode(1 + rand.nextInt(100)));
			getLeft().fillTree(cnt-1);
			getRight().fillTree(cnt-1);
		}
	}
	public void fillBST(int cnt)
	{
		if (cnt >= 1)
		{
			setLeft(new IntTreeNode(1));
			setRight(new IntTreeNode(1));
			getLeft().fillTree(cnt-1);
			getRight().fillTree(cnt-1);
		}
	}
	public void setBST(IntTreeNode node)
	{
		if (node != null)
		{
			node.setBST(node.getLeft());
			node.setVal(++IntTreeNode.counts);
			node.setBST(node.getRight());
		}
	}
	public int getMin()
	{
		assert this != null;
		return getMin(this);
	}
	private int getMin(IntTreeNode node)
	{
		if (node.getLeft() == null)
		{
			return node.getVal();
		}
		else
			return getMin(node.getLeft());
	}
	public int getMin4Tree()
	{
		IntTreeNode.min = getVal();
		getMin4Tree(this);
		int tmp = IntTreeNode.min;
		IntTreeNode.min = 0;
		return tmp;
	}
	private void getMin4Tree(IntTreeNode node)
	{
		if (node != null)
		{
			getMin4Tree(node.getLeft());
			int v = node.getVal();
			if (v < IntTreeNode.min)
				IntTreeNode.min = v;
			getMin4Tree(node.getRight());
		}
	}
	public int getMax()
	{
		assert this != null;
		return getMax(this);
	}
	private int getMax(IntTreeNode node)
	{
		if (node.getRight() == null)
		{
			return node.getVal();
		}
		else
			return getMax(node.getRight());
	}
	public int getMax4Tree()
	{
		IntTreeNode.max = getVal();
		getMax4Tree(this);
		int tmp = IntTreeNode.max;
		IntTreeNode.max = 0;
		return tmp;
	}
	private void getMax4Tree(IntTreeNode node)
	{
		if (node != null)
		{
			getMax4Tree(node.getLeft());
			int v = node.getVal();
			if (v > IntTreeNode.max)
				IntTreeNode.max = v;
			getMax4Tree(node.getRight());
		}
	}
	public int getHeight()
	{
		return getHeight(this);
	}
}