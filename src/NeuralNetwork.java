//Forward Propagation Neural Network


public class NeuralNetwork {

	 double inputs[] = {10,10,1};
	 
	 double firstWeights[][] = {
			 {1,0,0,0.25},
	         {0,1,0,0.25},
	         {0,0,2,2},
	 };
	 
	 double hiddenLayerValues[] = {0,0,0,0};
	 
	 double secondWeights[][] = {
			 {0,0,1,1},
			 {0.25,0.25,0,-0.25},
	 };
	 
	 double outputs[] = {0,0};
	 
	 double desiredOutputs[] = {0,0,0};
	 
	 
	 void calculateHiddenNodes() {
		 
		 for (int i = 0 ; i<hiddenLayerValues.length;i++) {
			 double sum = 0;
			 for (int j = 0 ; j<firstWeights.length;j++) {
				 sum = sum + (inputs[j] * firstWeights[j][i]);	 
			 }
			 this.hiddenLayerValues[i] = sum;
//			 System.out.println(sum);
//			 System.out.println("___");
		 }	
	 }
	 
	 void calculateOutput() {

		 this.calculateHiddenNodes();
		 
		 for (int i = 0;i<outputs.length;i++) {
			 double sum = 0;
			 for (int j = 0; j<secondWeights[0].length;j++) {
				 sum = sum + (hiddenLayerValues[j] * secondWeights[i][j]);	 
			 }
			 this.outputs[i] = sum;
//			 System.out.println(sum);
		 }
	 }
	 
	 public static void main(String[] args) {
		 
		 NeuralNetwork x = new NeuralNetwork();
		 x.calculateOutput();
		 System.out.println("Hidden Layer Values: ");
		 for (int i  = 0; i<4;i++) {
			 System.out.print(x.hiddenLayerValues[i]+", ");
		 }
		 System.out.println();
		 System.out.println("Output Layer Values: ");
		 for (int i  = 0; i<2;i++) {
			 System.out.print(x.outputs[i]+", ");
		 }
		 
		 
	 }
	
	
	
}
