import java.util.*;
public class Tree {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// ***TAKE INPUT MANUALLY***
//		TreeNode<Integer> Node= new TreeNode<>(1);
//		TreeNode<Integer> Node1=new TreeNode<>(2);
//		TreeNode<Integer> Node2=new TreeNode<>(3);
//		TreeNode<Integer> Node3=new TreeNode<>(4);
//		TreeNode<Integer> Node11=new TreeNode<>(5);
//		TreeNode<Integer> Node12=new TreeNode<>(6);
//		Node.children.add(Node1);
//		Node.children.add(Node2);
//		Node.children.add(Node3);
//		Node1.children.add(Node11);
//		Node1.children.add(Node12);
		
		//***TAKE INPUT RECURSIVELY***
//	 TreeNode<Integer> root=	takeInputRecursively(sc);
	 
		
	 //***PRINT TREE RECURSIVELY***
		 //printRecursively(root);
		
//		***TAKE INPUT LEVELWISE***
	 TreeNode<Integer> root=takeInputLW();

//	 ***PRINT TREE LEVELWISE***
	 printLW(root);
	 
	 
//	 ***NUMBER OF NODES IN TREE***
	int numOfNodes=NumberOFNode(root);
	 System.out.println("total number of node in Tree: "+numOfNodes);
	 
	 
	 
//	 ***SUM OF NODES***
	 int sum=sumOfTree(root);
	 System.out.println("sum of all tree node: "+sum);
	 
	 
//	 ***LARGEST IN TREE***
	 int largest=largestInTree(root);
	 System.out.println("LARGEST IN TREE :"+largest);
//	 ***NUMBER OF NODE GREATER THEN X***{
	 int x=10;
	 int number=NumberOfNode(root,x);
	 System.out.println(" node greater then "+x+" is :"+number);
	 
//	 ***FIND HEIGHT***
	 int height=getHeight(root);
	 System.out.println("Height of Tree : "+height);
	 
	 
//	 ******COUNT LEAF NODE*******
	 int count=countLeaf(root);
	 System.out.println("Total number of leaf node :"+count);
	 
	 
	 //***TRAVERSAL***
// 1. PreOrder Traversal
	 preOrder(root);
	 System.out.println();
	 
//  2. PostOrder
	 postOrder(root);
	 
	 sc.close();
	}
	private static void postOrder(TreeNode<Integer> root) {
		if(root==null) {
			return ;
		}
		
		for(int i=0;i<root.children.size();i++) {
			postOrder(root.children.get(i));
		}
		System.out.print(root.data+" ");
		
	}
	private static void preOrder(TreeNode<Integer> root) {
		if(root==null) {
			return ;
		}
		System.out.print(root.data+" ");
		for(int i=0;i<root.children.size();i++) {
			preOrder(root.children.get(i));
		}
		
	}
	public static int countLeaf(TreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int count=0;
		if(root.children.size()==0) {
			count++;
		}
		for(int i=0;i<root.children.size();i++) {
			count=count+countLeaf(root.children.get(i));
		}
		return count;
	}
	public static int getHeight(TreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int maxHeight=0;
		for(int i=0;i<root.children.size();i++) {
			int max=getHeight(root.children.get(i));
			if(max>maxHeight) {
				maxHeight=max;
			}
		}
		return maxHeight+1;
		//Add 1 for rootnode
	}
	public static int NumberOfNode(TreeNode<Integer> root, int x) {
		if(root==null) {
			return 0;
		}
		int count=0;
		if(root.data>x) {
			count++;
		}
		for(int i=0;i<root.children.size();i++) {
			count+=NumberOfNode(root.children.get(i),x);
		}
		return count;
	}
	public static int largestInTree(TreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int max=Integer.MIN_VALUE;
		for(int i=0;i<root.children.size();i++) {
			 int x=largestInTree(root.children.get(i));
			 if(x>max) {
				 max=x;
			 }
		}
		return Math.max(root.data,max);
		
	}
	public static int sumOfTree(TreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		if(root.children.size()==0) {
			return root.data;
		}
		int sum=0;
		for(int i=0;i<root.children.size();i++) {
			sum+=sumOfTree(root.children.get(i));
		}
		return sum+root.data;
	}
	public static int NumberOFNode(TreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int count=0;
		for(int i=0;i<root.children.size();i++) {
			count=count+NumberOFNode(root.children.get(i));
		}
		return count+1;
	}
	public static void printLW(TreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		Queue<TreeNode<Integer>> queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size=queue.size();
			if(size==0) {
				break;
			}
			while(size>0) {
				
				TreeNode<Integer> front=queue.poll();
				System.out.print(front.data+" ");
				for(int i=0;i<front.children.size();i++) {
					queue.add(front.children.get(i));
				}
				size--;
			}
			System.out.println();
		}
	}
	public static TreeNode<Integer> takeInputLW() {
		Scanner sc=new Scanner(System.in);
		Queue<TreeNode<Integer>> queue=new LinkedList<>();
		System.out.println("Enter the root node");
		int n=sc.nextInt();
		
		TreeNode<Integer> root=new TreeNode<Integer>(n);
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode<Integer> FrontNode=queue.poll();
			System.out.println("Enter number of children "+FrontNode.data);
			int childno=sc.nextInt();
			for(int i=0;i<childno;i++) {
				System.out.println("enter "+(i+1)+"th child of the "+FrontNode.data);
				int child=sc.nextInt();
				TreeNode<Integer> childs=new TreeNode<Integer>(child);
				queue.add(childs);
				FrontNode.children.add(childs);			}
		}
		sc.close();
		return root;
		
	}
	public static void printRecursively(TreeNode<Integer> root) {
		String ans=root.data+" : ";
		for(int i=0;i<root.children.size();i++) {
			ans=ans+root.children.get(i).data+" , ";
		}
		System.out.println(ans);
		for(int i=0;i<root.children.size();i++) {
			printRecursively(root.children.get(i));
		}
		
	}
	public static TreeNode<Integer> takeInputRecursively(Scanner sc) {
		
		System.out.println("Enter the Next Node");
		int n=sc.nextInt();
		System.out.println("Enter the Number of children for "+n);
		int childNo=sc.nextInt();
		TreeNode<Integer> root=new TreeNode<Integer>(n);
		for(int i=0;i<childNo;i++) {
			TreeNode<Integer> child=takeInputRecursively(sc);
			root.children.add(child);
		}
		return root;
	}
}
