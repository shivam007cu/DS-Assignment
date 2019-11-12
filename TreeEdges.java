import java.util.*;

public class TreeEdges
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

    public static int height(Node root)
	{
		if (root == null)
		{
			return -1;
		}
		else
		{
        return 1+Math.max(height(root.left), height(root.right));
		}
    }

    public static void main(String args[])
    {
        TreeEdges t = new TreeEdges();
         
        t.add(1);
        t.add(2);
        t.add(3);
        t.add(4);
        t.add(5);
		
        System.out.println("Height of tree: "+t.height(root));
    }
}