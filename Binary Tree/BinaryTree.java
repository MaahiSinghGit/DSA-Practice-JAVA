import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {

	public static void main(String[] args) {
//			***TAKE INPUT MANUALLY***
//		BinaryTreeNode<Integer> roots=new BinaryTreeNode<>(1);
//		BinaryTreeNode<Integer> node1=new BinaryTreeNode<>(2);
//		BinaryTreeNode<Integer> node2=new BinaryTreeNode<>(3);
//		roots.left=node1;
//		roots.right=node2;
//		BinaryTreeNode<Integer> node11=new BinaryTreeNode<>(11);
//		BinaryTreeNode<Integer> node12=new BinaryTreeNode<>(12);
//		BinaryTreeNode<Integer> node21=new BinaryTreeNode<>(21);
//		BinaryTreeNode<Integer> node22=new BinaryTreeNode<>(22);
//		node1.left=node11;
//		node1.right=node12;
//		node2.left=node21;
//		node2.right=node22;
		
//             ***TAKE INPUT RECURSIVELY***
		//BinaryTreeNode<Integer> root=takeInputRecursively();
//     ***PRINT BINARY TREE RECURSIVLY***
		//printRecursively(root);
// ***TAKE INPUT and PRINT LEVELWISE***
		BinaryTreeNode<Integer> root=takeInputLW();
		printLW(root);
		
//  ***COUNT THE NODE IN BTREE***
		System.out.println("Total Number of node in Tree : "+count(root));
		
//	***HEIGHT OF TREE***
		System.out.println("Height of Binary Tree :"+Height(root));

	
	     System.out.println("Inorder: ");
	     inorder(root);
	     System.out.println("preorder: ");
	     preorder(root);
	     System.out.println("postorder: ");
	     postorder(root);
//			***MIRROR IN BINARY TREE***
			BinaryTreeNode<Integer> roots= mirror(root);
			System.out.println("Mirror Tree : ");
					printLW(roots);
			
	}
	
	private static void preorder(BinaryTreeNode<Integer> root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return;
		}
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}

	private static void postorder(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return ;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+" ");
	}

	private static void inorder(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return ;
		}
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}

	public static void swap(BinaryTreeNode<Integer> root) {
			BinaryTreeNode<Integer> temp=root.left;
			root.left=root.right;
			root.right=temp;
		}
	public static BinaryTreeNode<Integer> mirror(BinaryTreeNode<Integer> root){
			if(root==null) {
				return null;
			}
			mirror(root.left);
			mirror(root.right);
			swap(root);
			return root;
		}
	
	public static int count(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int ans=0;
		ans=ans+count(root.left);
		ans=ans+count(root.right);
		return ans+1;
		
	}

	public static void printLW(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return ;
		}
		Queue<BinaryTreeNode<Integer>> queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode<Integer> Front=queue.poll();
			System.out.print(Front.data+" : ");
			if(Front.left!=null) {
				System.out.print("L:"+Front.left.data);
				queue.add(Front.left);
			}
			if(Front.right!=null) {
				queue.add(Front.right);
				System.out.print("R:"+Front.right.data);
			}
			System.out.println();
		}
		
	}

	public static BinaryTreeNode<Integer> takeInputLW() {
		Queue<BinaryTreeNode<Integer>> queue=new LinkedList<>();
		System.out.println("enter the root node");
		Scanner sc=new Scanner(System.in);
		int Root=sc.nextInt();
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(Root);
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode<Integer> front=queue.poll();
			System.out.println("Enter the left node of"+front.data);
			int Left=sc.nextInt();
			if(Left!=-1) {
				BinaryTreeNode<Integer> left=new BinaryTreeNode<Integer>(Left);
				front.left=left;
				queue.add(left);
			}
			
			System.out.println("Enter the right node of"+front.data);
			int Right=sc.nextInt();
			if(Right!=-1) {
				BinaryTreeNode<Integer> right=new BinaryTreeNode<Integer>(Right);
				front.right=right;
				queue.add(right);
			}
			
		}
		sc.close();
		return root;
	}

	public static int Height(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		return (Math.max(Height(root.left),Height(root.right))+1);
	}

	public static void printRecursively(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return ;
		}
		String ans=root.data+":";
		if(root.left!=null) {
			ans=ans+" L:"+root.left.data;
		}
		if(root.right!=null) {
			ans=ans+" R:"+root.right.data;
		}
		System.out.println(ans);
		printRecursively(root.left);
		printRecursively(root.right);
		
	}

	public static BinaryTreeNode<Integer> takeInputRecursively() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter root data");
		int roots=sc.nextInt();
		if(roots==-1) {
			return null;
		}
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(roots);
		root.left=takeInputRecursively();
		root.right=takeInputRecursively();
		
		return root;
	}

}
