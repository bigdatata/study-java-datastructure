package chapter1;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import analysis.in.java.chapter1.Orientation;
import analysis.in.java.chapter1.Puzzle;

public class PuzzleTest {
	Puzzle puzzle=new Puzzle();
	@Test
	public void getStringTest(){
		
		System.out.println(puzzle.getString(3,3,4,Orientation.northWest));
	}
	@Test
	public void getPotential(){
		Map<String,String> resultWords=new HashMap<String,String>();
		for(int i=0;i<puzzle.rowSize;i++){
			for(int j=0;j<puzzle.columnSize;j++){
				for(int k=1;k<=puzzle.columnSize;k++){
					for(Orientation orient:Orientation.values()){
						String wordPath="";
						String word=puzzle.getPotentialWordAndPath(i, j, k, orient);
						if(word!=""){
							System.out.printf("(%d,%d) %d (%d,%d) %s\n",i,j,k,orient.x,orient.y,word);
							resultWords.put(word,wordPath);
						}
					}
				}
			}
		}
		for(String word: resultWords.keySet()){
			System.out.print(word+"  ->");
			System.out.println(resultWords.get(word));
		}
	}
}
