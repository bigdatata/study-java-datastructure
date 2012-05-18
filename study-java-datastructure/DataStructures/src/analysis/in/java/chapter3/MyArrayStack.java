package analysis.in.java.chapter3;

public class MyArrayStack<AnyType> implements MyStack<AnyType> {

	private static final int DEFAULT_STACK_SIZE=10;
	private static final int STACK_BOTTOM=-1;
	private int position;
	private int stackSize;
	private AnyType[] theArray;
	
	public MyArrayStack(){
		initStack(DEFAULT_STACK_SIZE);
	}
	public MyArrayStack(int size){
		initStack(size);
	}
	private void  initStack(int size){
		if(size<=0){
			size=DEFAULT_STACK_SIZE;
		}
		theArray = (AnyType[])new Object[size];
		stackSize=size;
		position=STACK_BOTTOM;
	}
	
	@Override
	public boolean isEmpty() {
		return STACK_BOTTOM==position;
	}

	@Override
	public AnyType pop() {
		AnyType element=null;
		if(!isEmpty()){
			element=theArray[position--];
		}
		return element;
	}

	@Override
	public void push(AnyType element) {
		if(position<stackSize-1){
			theArray[++position]=element;
		}else{
			/**
			 * 处理栈溢出，有两种方式，一是不处理抛出异常，二是增加栈空间，三是二者的结合
			 *先增加，如果达到最大栈空间后，还栈空间满，则抛出异常.这里为了简便直接输入栈
			 *满。
			 */
			System.out.println("stack is full");
			
		}
	}

	@Override
	public AnyType top() {
		AnyType element=null;
		if(!isEmpty()){
			element=theArray[position];
		}
		return element;
	}

	
}
