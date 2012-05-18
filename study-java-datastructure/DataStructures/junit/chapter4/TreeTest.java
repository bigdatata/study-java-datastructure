package chapter4;

import org.junit.Test;

import analysis.in.java.chapter4.Tree;

public class TreeTest {

	@Test
	public void tests(){
		Character c='N';
		System.out.println(c);
	}
	@Test
	public void test(){
		Tree<Character> tree;
		Tree<Character> N=new Tree<Character>('N',null,null);
		Tree<Character> G=new Tree<Character>('G',N,null);
		Tree<Character> M=new Tree<Character>('M',null,null);
		Tree<Character> L=new Tree<Character>('L',null,M);
		Tree<Character> K=new Tree<Character>('K',null,L);
		Tree<Character> F=new Tree<Character>('F',K,G);
		Tree<Character> Q=new Tree<Character>('Q',null,null);
		Tree<Character> P=new Tree<Character>('P',null,Q);
		Tree<Character> J=new Tree<Character>('J',P,null);
		Tree<Character> I=new Tree<Character>('I',null,J);
		Tree<Character> E=new Tree<Character>('E',I,F);
		Tree<Character> H=new Tree<Character>('H',null,null);
		Tree<Character> D=new Tree<Character>('D',H,E);
		Tree<Character> C=new Tree<Character>('C',null,D);
		Tree<Character> B=new Tree<Character>('B',null,C);
		Tree<Character> A=new Tree<Character>('A',B,null);
		tree=A;
		tree.preOrderTraveral();
		System.out.println("----------------------");
		tree.postOrderTraveral();
		
	}
}
