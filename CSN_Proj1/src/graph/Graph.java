package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	private int totalNode;
	private List<Edge> edgeList = new ArrayList<>();
	
	public Graph(int totalNodes){
		this.totalNode = totalNodes;
	}
	
	public void addEdge(Edge edge){
		edgeList.add(edge);
	}

	public int getTotalNode() {
		return totalNode;
	}
	public List<Edge> getEdgeList() {
		return edgeList;
	}	
	
}
