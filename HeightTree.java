import java.util.*;

public class HeightTree
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

    public int height(Node node)
    {
        int lh=0;
        int rh=0;;
        int h=0;

        if(node.left!=null)
        {
            lh=height(node.left);
        }
        else if(node.right!=null)
        {
            rh=height(node.right);
        }

        if(lh>rh)
        {
            h=lh;
        }
        else    
            h=rh;

        return h+1;
    }

    public static void main(String args[])
    {
        HeightTree t = new HeightTree();
         
        t.add(1);
        t.add(2);
        t.add(3);
        t.add(4);
        t.add(5);

        System.out.println("Height of tree: "+t.height(root));
    }
}



