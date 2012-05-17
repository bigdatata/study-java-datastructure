package analysis.in.java.chapter1;

/**
 * Îª¾ØÕó·½Ïò
 * @author luotao
 *
 */
public enum Orientation {
	north(0,-1),northEast(1,-1),east(1,0),southEast(1,1),
	south(0,1),southWest(-1,1),west(-1,0),northWest(-1,-1);
	private Orientation(int x,int y){
		this.x=x;
		this.y=y;
	}
	public int x;
	public int y;
}
