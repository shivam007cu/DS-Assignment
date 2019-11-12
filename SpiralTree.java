import java.util.*;

public class SpiralTree
{
    static Node root;

    class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data=data;
            left=right=null;
        }
    }

    public Node insert(Node node, int data)
    {
        if(node==null)
        {
            return new Node(data);
        }

        if(data<node.data)
        {
            if(node.left!=null)
            {
                insert(node.left, data);
            }
            else
                node.left=new Node(data);
        }
        else if(data>node.data)
        {
            if(node.right!=null)
            {
                insert(node.right, data);
            }
            else
                node.right=new Node(data);
        }
        return node;
    }

    public void add(int data)
    {
        root=insert(root, data);
    }

    public int height(Node root)
    {
        int lh=0;
        int rh=0;;
        int h=0;

        if(root==null)
        {
            return 0;
        }
        else
        {
            lh=height(root.left);
            rh=height(root.right);

            if(lh>rh)
            {
                return lh+1;
            }
            else
                return rh+1;
        }
    }
	
	public void printOrder()
	{
		int h=height(root);
		boolean check=true;
		for(int i=1;i<=h;i++)
		{
			printLevel(root,i,check);
			check=!check;
		}
	}

	public void printLevel(Node root, int level, boolean check)
	{
		if(root==null)
		{
			return;
		}
		else if(level==1)
		{
			System.out.println(root.data);
		}
		else if(level>1)
		{
			if(check!=false)
			{
				printLevel(root.left,level-1,check);
				printLevel(root.right,level-1,check);
			}
			else
			{
				printLevel(root.right,level-1,check);
				printLevel(root.left,level-1,check);
			}
		}
			
	}


    public static void main(String args[])
    {
        SpiralTree t = new SpiralTree();
         
        t.add(1);
        t.add(3);
        t.add(2);
        t.add(4);
        t.add(5);
		
		t.printOrder();
    }
}