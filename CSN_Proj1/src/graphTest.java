import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import graph.GraphBuilder;

public class graphTest {
	
	private static GraphBuilder gb;
	private static int totalNode;
	
	@BeforeClass
    public static void beforeClass() {
       totalNode = 10;
       gb = new GraphBuilder(totalNode, 0);
    }
	
	@Test
	public void testRandomSelectNode() {
		int[] mem = new int[totalNode];
		double up = 1000;
		for(int i = 0 ; i< up*totalNode; i++){
			mem[gb.randomSelectNode()]++;
		}
		System.out.println("Testando Random Select Number");
		for(int i = 0 ; i< up*totalNode; i++){
			System.out.println((i+1) + ": " + Math.floor((1 - mem[i]/up)*100) + "%");
		}
	}

	@Test
	public void testRandomSelectP() {
		int[] mem = new int[7];
		double up = 1000;
		for(int i = 0 ; i< up; i++){
			mem[gb.randomSelectP()]++;
		}
		System.out.println("Testando Random Select P");
		for(int i = 2 ; i< 7; i++){
			System.out.println((i) + ": " + Math.floor((mem[i]/up)*100) + "%");
		}
	}
	
}
