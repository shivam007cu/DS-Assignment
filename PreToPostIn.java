import java.util.*;

public class PreToPostIn
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

    public void displayinOrder(Node node)
    {
        if(node!=null)
        {
            displayinOrder(node.left);
            System.out.print(" "+node.data);
            displayinOrder(node.right);
        }
    }
	
	 public void displaypostOrder(Node node)
    {
        if(node!=null)
        {
            displayinOrder(node.left);
            displayinOrder(node.right);
			System.out.print(" "+node.data);
        }
    }

    public static void main(String args[])
    {
        PreToPostIn t = new PreToPostIn();
         
        t.add(50);
        t.add(30);
        t.add(10);
        t.add(40);
        t.add(80);
		t.add(70);
		
		System.out.println("In Order:");
        t.displayinOrder(root);
        System.out.println();
        System.out.println("Post Order:");
		t.displaypostOrder(root);
    }
}