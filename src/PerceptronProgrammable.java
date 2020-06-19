//Weights of Hidden units are determined by trial/error and intuition 

//(Excel Spreadsheet for visualization of how this works)

public class PerceptronProgrammable {
    double inputs[]        = {1,4,0,0}; //2,2,0,0
    double hiddenUnits[][] = {
            {1,1,0,0},
            {1,0,0,0},
            {0,1,0,0}
    };
    double outputs[]       = {0,0,0};
    String conclusions[]   = {"A","B","C"};
    
    double threshold = 1.0;

    void calculate() {
        int i,j;
        double sum;

        for(j=0;j<outputs.length;j++) {
            sum = 0.0;
            for (i = 0; i < inputs.length; i++) {
                sum += inputs[i] * hiddenUnits[j][i];
            }
            outputs[j] = sum;
            
        }
    }

    void printResult() {
        double maxScore=outputs[0];
        int maxIndex=0;
        int i;

        // max score and position
        for(i=1;i<outputs.length;i++) {
            if (outputs[i] > maxScore) {
                maxScore = outputs[i];
                maxIndex = i;
            }
        }

        // display results
        System.out.printf("\nMax Score = %f  (%s)\n\n", outputs[maxIndex],conclusions[maxIndex]);
        for(i=0;i<outputs.length;i++)
       System.out.printf("Output %d: %s, = %10.2f\n",i,conclusions[i],outputs[i]);
    }
    
    void thresholdResults() {
    	System.out.println("Threshold: " + threshold);
    	for (int i = 0; i<outputs.length;i++) {
    		if (outputs[i] > threshold) {
    			System.out.printf("Output: %s, Score: %f\n",conclusions[i],outputs[i]);
    		}
    	}
    }
    
   void thresholdResultsToList() {
	   Tuple x = new Tuple();
	   for (int i = 0; i<outputs.length;i++) {
   		if (outputs[i] > threshold) {
   			String outputString = outputs[i] + "";
   			x.addToList("NN", conclusions[i], outputString);
   		}
   	}
		x.printList();
   }
    

}
