package graph.export;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import graph.Graph;

public abstract class GraphExport {
	private String fileName;	
	
	protected Graph graph;	
	protected String fileNameSufix = ".txt";
	protected PrintWriter outputStream;
	
	public GraphExport(String fileName, Graph graph){
		this.fileName = fileName;
		this.graph = graph;
	}
	
	public void export(){
		try{
			outputStream = new PrintWriter(new FileWriter(fileName+fileNameSufix));
			writeExport();
		}catch(IOException e){
			
		}finally{
			outputStream.close();
		}
	}
	
	protected abstract void writeExport();
	
}
