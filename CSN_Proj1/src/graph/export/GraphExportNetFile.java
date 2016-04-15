package graph.export;

import java.util.ArrayList;
import java.util.List;

import graph.Edge;
import graph.Graph;

public class GraphExportNetFile extends GraphExport {

	public GraphExportNetFile(String fileName, Graph graph) {
		super(fileName, graph);
		this.fileNameSufix = ".NET";
	}

	@Override
	protected void writeExport() {
		outputStream.println("*Vertices     " + graph.getTotalNode());
		for(int i = 1; i <= graph.getTotalNode(); i++){
			outputStream.println(i + " " + i);
		}
		outputStream.println("*Arcs");
		outputStream.println("*Edges");
		
		List<Edge> edgeList = graph.getEdgeList();
		for(Edge edge: edgeList){
			outputStream.println((edge.getOrig()+1) + " " + (edge.getDest()+1));
		}
	}

}
