//This a Neural Network Tree (forward propagation)
//Refer to Excel Spreadsheet screenshot for a better representation of what is happening

//3 different types of inputs at leaf nodes:
//Yellow input: Infrared Sensor - checks measurement at 5 different angles
//Orange input: Battery - checks battery at 3 different time units
//Pink input: Temperature Sensor - checks internal temp at 2 different time units

//The output from the Yellow and Orange Neural Networks get fed into the green Neural Network
//The output from the Green and Pink Neural Network gets fed into the Blue Neural Network which determines a final conclusion
public class NNTree {

	double yellowInputs[] = {0,0,0.33,0.2}; //Left 90,Left 45, Right 45, Right 90
	double orangeInputs[] = {0.5,0.5,0.5}; //time 0, time 1 , time 2
	double pinkInputs[] = {0.6,0.5}; ////time 0, time 1 
	
	double yellowHiddenUnits[][] = {
			{0.8,0.2,0,0},
			{0,0,0.2,0.8}
	};
	double orangeHiddenUnits[][] = {
			{0.45,0.45,0},
			{0.333333,0.333333,0.33333}
	};
	double pinkHiddenUnits[][] = {
			{0.45,0.45},
			{0.5,0.38}
	};
	
	double yellowOutputs[] = {0,0};
	String yellowConclusion[] = {"turn righ 90 degrees","turn left 90 degrees"};
	
	double orangeOutputs[] = {0,0};
	String orangeConclusion[]= {"100% battery used","0 %battery used"};
	
	double pinkOutputs[] = {0,0};
	String pinkConclusion[] = {"overheating","optimal temperature"};
	
	double greenInputs[] = {0,0,0,0};
	double greenHiddenUnits[][] = {
			{0.5,0,1,0},
			{0.5,0,0,1},
			{0,0.5,1,0},
			{0,0.5,0,1}
	};
	double greenOutputs[] = {0.45,0.5,0.56,0.613};
	
	double blueInputs[] = {0,0,0,0,0,0};
	double blueHiddenUnits[][] = {
			{0,0.3,0,0,0,0.5},
			{0,0,0,0,0.3,0.5},
			{0.3,0,0.3,0,1,0}
	};
	double blueOutputs[] = {0,0,0};
	String blueConclusion[] = {"Turn right","Turn left","Stop"};
   
	//general calculate function
	void calculate(String color,double[] inputs,double[][] hiddenUnits,double[] outputs) {
        int i,j;
        double sum;
        for(j=0;j<outputs.length;j++) {
            sum = 0.0;
            for (i = 0; i < inputs.length; i++) {
                sum += inputs[i] * hiddenUnits[j][i];
            }
          //  System.out.println(sum);
            if (color.equalsIgnoreCase("yellow")) {
            	this.yellowOutputs[j] = sum;
            }
            else if(color.equalsIgnoreCase("orange")){
            	this.orangeOutputs[j] = sum;
            }
            else if(color.equalsIgnoreCase("pink")){
            	this.pinkOutputs[j] = sum;
            }
            else if(color.equalsIgnoreCase("green")){
            	this.greenOutputs[j] = sum;
            }
            else if(color.equalsIgnoreCase("blue")){
            	this.blueOutputs[j] = sum;
            }
        }
     //   System.out.println("----------------------------------");
    }
	
	void forwardPropagation() {
	
		this.calculate("yellow",this.yellowInputs, this.yellowHiddenUnits, this.yellowOutputs);
		this.calculate("orange",this.orangeInputs, this.orangeHiddenUnits, this.orangeOutputs);
		this.calculate("pink",this.pinkInputs, this.pinkHiddenUnits, this.pinkOutputs);
		this.temperatureFunction();
		this.combineOutputsToGetGreenInput();
		this.calculate("green",this.greenInputs, this.greenHiddenUnits, this.greenOutputs);
		this.combineOutputsToGetBlueInput();
		this.calculate("blue",this.blueInputs, this.blueHiddenUnits, this.blueOutputs);
		this.displayResults();
		
	}
	
	//checks max of outputs and provides result with conclusion
	void displayResults() {
		double max = 0.0;
		String conclusion = "";
		for (int i = 0;i<this.blueOutputs.length;i++) {
			if (blueOutputs[i]>=max) {
				max = blueOutputs[i];
				conclusion = blueConclusion[i];
			}
		}
		System.out.printf("The result of the Neural Network Tree after the calculations from the inputs is: %s",conclusion);
	}

	//temperature functions checks output of the pink network, if it is overheating it makes that value 1 and the other 0. Vice Versa if it is at optimal temperature
	void temperatureFunction() {
		if (this.pinkOutputs[0]>=this.pinkOutputs[1]) {
			this.pinkOutputs[0] = 1;
			this.pinkOutputs[1] = 0;
		} else {
			this.pinkOutputs[0] = 0;
			this.pinkOutputs[1] = 1;
		}
	}
	
	//combine Yellow and Orange Output
	void combineOutputsToGetGreenInput() {
		int greenIndex = 0;
		for (int i = 0 ;i<this.yellowOutputs.length;i++) {
			this.greenInputs[greenIndex] = this.yellowOutputs[i];
			greenIndex++;
		}
		for (int i = 0 ; i<this.orangeOutputs.length;i++) {
			this.greenInputs[greenIndex] = this.orangeOutputs[i];
			greenIndex++;
		}
	}
	
	//combine Green and Pink Output
	void combineOutputsToGetBlueInput() {
		int blueIndex = 0;
		for (int i = 0 ;i<this.greenOutputs.length;i++) {
			this.blueInputs[blueIndex] = this.greenOutputs[i];
			blueIndex++;
		}
		for (int i = 0 ; i<this.pinkOutputs.length;i++) {
			this.blueInputs[blueIndex] = this.pinkOutputs[i];
			blueIndex++;
		}
	}
	
	public static void main(String args[]) {
		NNTree x = new NNTree();
		x.forwardPropagation();
		
	}
}
