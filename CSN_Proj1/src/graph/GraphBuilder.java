package graph;

import java.util.Random;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GraphBuilder {

	private final int P2 = 45;//70,45
	private final int P3 = 25;//20,25
	private final int P4 = 15;//5,15
	private final int P5 = 10;//3,10
	private final int PN =  5;//2,05
	
	private int totalNode;
	private int totalEdge;
	private int[][] dist;
	private Graph graph;
	
	public GraphBuilder(int totalNode, int totalEdge){
		this.totalNode = totalNode;
		this.totalEdge = totalEdge;
		graph = new Graph(totalNode);
		dist = new int[totalNode][totalNode];
		for(int i = 0; i < totalNode; i++){
			for(int j = 0; j < totalNode; j++){
				if(i == j){
					dist[i][j] = 0;
				}else{
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
		}
	}
	
	public void buildGraph(){
		
		int selectedNode;
		int nextNode;
		int selectedP;
		List<Integer> nodeList = new ArrayList<>();
		
		System.out.println("Start building graph");
		
		for(int i = 0; i < totalEdge; i++){
			if(i%100 == 0)
				System.out.println("Adding adge number " + i);
			
			selectedNode = randomSelectNode();
			
			//System.out.println("Selected Node: " + selectedNode);
			
			do{				
				selectedP = randomSelectP();
				nodeList = getPossibleNodes(selectedNode, selectedP);//Not tested
			}while(nodeList == null);
						
			//System.out.println("Selected P: " + selectedP);
			
			nextNode = randomSelectNextNode(nodeList);//Not tested
			
			//System.out.println("Next node: " + nextNode);
			//System.out.println("Dist: " + dist[selectedNode][nextNode]);
			
			graph.addEdge(new Edge(selectedNode,nextNode));
			updateDist(selectedNode,nextNode);//Not tested
		}
		
		System.out.println("Building graph finish");
		
	}
	
	public Graph getGraph(){
		return graph;
	}
	
	//Public for test
	public int randomSelectNode(){
		int selectedNode = 0;
		
		Random random = new Random();	
		selectedNode = random.nextInt(totalNode);
		
		return selectedNode;
	}
	
	//Public for test
	public int randomSelectP(){
		int selectedP = 0;
		int aux;
		
		Random random = new Random();	
		aux = random.nextInt(P2 + P3 + P4 + P5 + PN) + 1;
		
		if(aux <= P2){
			selectedP = 2;
		}else if(aux <= P2 + P3){
			selectedP = 3;
		}else if(aux <= P2 + P3 + P4){
			selectedP = 4;
		}else if(aux <= P2 + P3 + P4 + P5){
			selectedP = 5;
		}else{
			selectedP = 6;
		}
		
		return selectedP;
	}
	
	private List<Integer> getPossibleNodes(int selectedNode, int selectedP){
		List<Integer> nodeList = new ArrayList<>();
		
		for(int j = 0; j < totalNode; j++){
			if(selectedP >= 6){
				if(dist[selectedNode][j] >= 6){
					nodeList.add(j);
				}					
			}else{
				if(dist[selectedNode][j] == selectedP){
					nodeList.add(j);
				}
			}
		}
		
		if(nodeList.size() == 0)
			return null;
		
		return nodeList;
	}
	
	private int randomSelectNextNode(List<Integer> nodeList){
		int nextNode = 0;			
		
		Random random = new Random();
		nextNode = random.nextInt(nodeList.size());
		
		return nodeList.get(nextNode);
	}
	
	private void updateDist(int selectedNode, int nextNode){
		dist[selectedNode][nextNode] = dist[nextNode][selectedNode] = 1;
		
		long d1,d2;
		for(int j = 0; j < totalNode; j++){
			d1 = dist[selectedNode][j];
			d2 = dist[nextNode][j];
			
			if(d1 + 1 < d2){
				dist[nextNode][j] = (int)(d1+1);
				dist[j][nextNode] = dist[nextNode][j];
			}else if(d2 + 1 < d1){
				dist[selectedNode][j] = (int)(d2+1);
				dist[j][selectedNode] = dist[selectedNode][j];
			}			
		}		
		
		/*
		for(int i = 0; i < totalNode; i++){
			System.out.print(i + ": ");
			for(int j = 0; j < totalNode; j++){
				if(dist[i][j] < Integer.MAX_VALUE)
					System.out.print("  " + dist[i][j]);
				else
					System.out.print(" -1");
			}
			System.out.println("");
		}
		*/
	}
	
}
