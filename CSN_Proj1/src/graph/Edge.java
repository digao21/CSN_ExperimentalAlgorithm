package graph;

public class Edge {
	private int orig;
	private int dest;
	
	public Edge(int orig, int dest){
		this.orig = orig;
		this.dest = dest;
	}

	public int getOrig() {
		return orig;
	}
	public int getDest() {
		return dest;
	}
		
}
