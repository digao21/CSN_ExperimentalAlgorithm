package main;

import graph.Graph;
import graph.GraphBuilder;
import graph.export.GraphExportEdgelistFile;
import graph.export.GraphExportNetFile;

public class Main {
	
	public static void main(String[] arg){
		GraphBuilder gb = new GraphBuilder(1000, 20000);		
		gb.buildGraph();	
		
		Graph g = gb.getGraph();
		
		String fileName = "V1000E20000";
		GraphExportNetFile gexp = new GraphExportNetFile(fileName, g);
		GraphExportEdgelistFile gexpL = new GraphExportEdgelistFile(fileName, g);
		gexp.export();
		gexpL.export();
	}
	
}
