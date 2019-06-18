package edu.handong.csee;

import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException {
		
		int numThreads = 5;
		Thread[] t = new Thread[numThreads];
		
		for(int i=0;i<numThreads;i++) {
			JavaFinalProject project = new JavaFinalProject(); 
			project.setArg(args);
			t[i] = new Thread(project);
			t[i].start();
		}
		
		
		
			//JavaFinalProject project = new JavaFinalProject();
			//project.run(args);
			
}
}
