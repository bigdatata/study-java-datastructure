package analysis.in.java.chapter4;

import java.util.Comparator;

public class BinarySearchTreeAnother<AnyType> {

	private static class BinaryNode<AnyType>{
		AnyType element;
		BinaryNode<AnyType> left;
		BinaryNode<AnyType> right;
		
		public BinaryNode(AnyType element){
			this(element,null,null);
		}
		
		public BinaryNode(AnyType element,BinaryNode<AnyType> left,
				BinaryNode<AnyType> right){
			this.element=element;
			this.left=left;
			this.right=right;
		}
	}
	
	private BinaryNode<AnyType> root;
	
	private Comparator<? super AnyType> cmp;
	
	public BinarySearchTreeAnother(){
		this(null);
	}
	public BinarySearchTreeAnother(Comparator<? super AnyType> cmp){
		this.cmp=cmp;
		root=null;
	}
	private int myCompare(AnyType lhs,AnyType rhs){
		if(null!=cmp){
			return cmp.compare(lhs, rhs);
		}else{
			return ((Comparable)lhs).compareTo(rhs);
		}
	}
	
	private boolean contains(AnyType element,BinaryNode<AnyType> t){
		if(null==t){
			return false;
		}
		int compareResult=myCompare(element,t.element);
		if(compareResult<0){
			return contains(element,t.left);
		}else if(compareResult>0){
			return contains(element,t.right);
		}
		//Match
		return true;
	}
	//Remainder of class is similar with calls to compareTo replaced by myCompare
}
