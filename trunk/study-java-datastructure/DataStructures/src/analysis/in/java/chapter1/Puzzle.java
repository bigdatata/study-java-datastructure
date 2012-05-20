package analysis.in.java.chapter1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Puzzle {

	private char[][] datas={
			{'t','h','i','s'},
			{'w','a','t','s'},
			{'o','a','h','g'},
			{'f','g','d','t'}
	};
	public int rowSize=datas.length;
	public int columnSize=datas[0].length;
	
	public Puzzle(char[][] datas){
		this.datas=datas;
		this.rowSize=datas.length;
		this.columnSize=datas[0].length;
		
	}
	public Puzzle(){
		this.rowSize=datas.length;
		this.columnSize=datas[0].length;
	}
	
	public List<String> getWords(Map<String,Boolean> words){
		return getWords(words,Math.max(rowSize,columnSize ));
	}
	
	public List<String> getWords(Map<String,Boolean> words,int wordMaxSize){
		List<String> resultWords=new LinkedList<String>();
		for(int i=0;i<rowSize;i++){
			for(int j=0;j<columnSize;j++){
				for(int k=1;k<=wordMaxSize;k++){
					for(Orientation orient:Orientation.values()){
						String wordAndPath=getPotentialWordAndPath(i, j, k, orient);
						if(wordAndPath!=""){
							String[] results=wordAndPath.split("&");
							String word=results[0];
							String path=results[1];
							if(words.get(word)!=null){
								resultWords.add(word+ " " +path);
							}
						}
					}
				}
			}
		}
		return resultWords;
	}

	/**
	 * 返回从开始坐标为(beginRow,beginColumn) 方向为orient 字长为wordLength 的字符串及在数组开始结束位置 以
	 * '&'号分隔开,如果越界的直接放回""
	 * @param beginRow
	 * @param beginColumn
	 * @param wordLength
	 * @param orient
	 * @return
	 */
	public String getPotentialWordAndPath(int beginRow,int beginColumn,int wordLength,Orientation orient){
		int endRow=beginRow+(wordLength-1)*orient.x;
		int endColumn=beginColumn+(wordLength-1)*orient.y;
		//判断数组下标位置
		boolean isIndexOutOfBound=(endRow<0||endRow>=rowSize)||(endColumn<0||endColumn>=columnSize)||
		(beginRow<0||beginRow>=rowSize)||(beginColumn<0||beginColumn>=columnSize);
		if(isIndexOutOfBound){
			return "";
		}
		String path=String.format("from (%d,%d) to (%d,%d)\n", beginRow+1,beginColumn+1,endRow+1,endColumn+1);
		return getString(beginRow,beginColumn,wordLength,orient)+"&"+path;
	}
	
	/**
	 * 返回从开始坐标为(beginRow,beginColumn) 方向为orient 字长为wordLength 的字符串
	 * 使用前要判断数组越界
	 * @param beginRow
	 * @param beginColumn
	 * @param wordLength
	 * @param orient
	 * @return
	 */
	public String getString(int beginRow,int beginColumn,int wordLength,Orientation orient){
		StringBuilder result=new StringBuilder();
		for(int k=0;k<wordLength;k++){
			result.append(datas[beginRow+k*orient.x][beginColumn+k*orient.y]);
		}
		return result.toString();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String,Boolean> words=new HashMap<String,Boolean>();
		words.put("that", true);
		words.put("this", true);
		words.put("fat", true);
		words.put("two", true);
		words.put("hello", true);
		words.put("world", true);
		Puzzle puzzle=new Puzzle();
		List<String> wordInArray=puzzle.getWords(words);
		for(String word:wordInArray){
			System.out.println(word);
		}
	}

}
