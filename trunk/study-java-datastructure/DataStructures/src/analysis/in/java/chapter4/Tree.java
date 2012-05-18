package analysis.in.java.chapter4;

public class Tree<AnyType> {

	AnyType element;
	Tree<AnyType> firstChild;
	Tree<AnyType> nextSibling;

	public Tree(AnyType element, Tree<AnyType> firstChild,
			Tree<AnyType> nextSibling) {
		this.element = element;
		this.firstChild = firstChild;
		this.nextSibling = nextSibling;
	}
	
	public void preOrderTraveral(){
		preOrderTraveral(this,0);
	}
	
	private void preOrderTraveral(Tree<AnyType> tree,int depth){
		if(null==tree){
			return;
		}
		printName(tree.element,depth);
		Tree<AnyType> temp=tree;
		preOrderTraveral(tree.firstChild,depth+1);
		while(temp.nextSibling!=null){
			printName(temp.nextSibling.element,depth);
			preOrderTraveral(temp.nextSibling.firstChild,depth+1);
			temp=temp.nextSibling;
		}
	}
	
	private void printName(AnyType element,int depth){
		System.out.print("|");
		while(depth-->0){
			System.out.print("-");
		}
		System.out.println(element);
	}
	public void postOrderTraveral(){
		postOrderTraveral(this,0);
	}
	public void postOrderTraveral(Tree<AnyType> tree,int depth){
		if(null==tree){
			return;
		}
		Tree<AnyType> temp=tree;
		postOrderTraveral(temp.firstChild,depth+1);
		printName(tree.element,depth);
		while(temp.nextSibling!=null){
			postOrderTraveral(temp.nextSibling.firstChild,depth+1);
			printName(temp.nextSibling.element,depth);
			temp=temp.nextSibling;
		}
		
	}

}
