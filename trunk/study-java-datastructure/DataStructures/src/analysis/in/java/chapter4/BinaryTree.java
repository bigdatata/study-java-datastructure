package analysis.in.java.chapter4;

public class BinaryTree<AnyType> {

	AnyType element;
	BinaryTree<AnyType> left;
	BinaryTree<AnyType> right;
	
	public BinaryTree(AnyType element){
		this(element,null,null);
	}
	
	public BinaryTree(AnyType element,BinaryTree<AnyType> left,
			BinaryTree<AnyType> right){
		this.element=element;
		this.left=left;
		this.right=right;
	}
	
	public void preOrderTraveral(){
		preOrderTraveral(this);
	}
	private void preOrderTraveral(BinaryTree<AnyType> binaryTree){
		if(null==binaryTree){
			return ;
		}
		System.out.println(binaryTree.element);
		preOrderTraveral(binaryTree.left);
		preOrderTraveral(binaryTree.right);
	}
	public void inOrderTraveral(){
		inOrderTraveral(this);
	}
	private void inOrderTraveral(BinaryTree<AnyType> binaryTree){
		if(null==binaryTree){
			return ;
		}
		inOrderTraveral(binaryTree.left);
		System.out.println(binaryTree.element);
		inOrderTraveral(binaryTree.right);
	}
	public void postOrderTraveral(){
		postOrderTraveral(this);
	}
	private void postOrderTraveral(BinaryTree<AnyType> binaryTree){
		if(null==binaryTree){
			return ;
		}
		postOrderTraveral(binaryTree.left);
		postOrderTraveral(binaryTree.right);
		System.out.println(binaryTree.element);
	}
}
