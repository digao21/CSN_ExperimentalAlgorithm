package graph.export;

import java.util.List;

import graph.Edge;
import graph.Graph;

public class GraphExportEdgelistFile extends GraphExport {

	public GraphExportEdgelistFile(String fileName, Graph graph) {
		super(fileName, graph);
		this.fileNameSufix = ".edge";
	}

	@Override
	protected void writeExport() {
		
		List<Edge> edgeList = graph.getEdgeList();
		for(Edge edge: edgeList){
			outputStream.println((edge.getOrig()+1) + " " + (edge.getDest()+1));
		}
	}
	
}
