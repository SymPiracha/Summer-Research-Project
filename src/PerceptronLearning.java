//Back propagation added which adjusts the weights of nodes.

//(Excel Spreadsheet for visualization of how this works)

public class PerceptronLearning {
    double inputs[]        = {2,2,0,0};
    double hiddenUnits[][] = {
            {1,0,0,0},
            {1,0,0,0},
            {1,1,0,0}
    };
    double percentageError[][] = {
            {1,0,0,0},
            {1,0,0,0},
            {1,1,0,0}
    };
    double increaseByError[][] = {
            {1,0,0,0},
            {1,0,0,0},
            {1,1,0,0}
    };
    double outputs[]       = {0,0,0};
    double error[]         = {0,0,0};
    double expected[]      = {4,2,2};
    String conclusions[]   = {"A","B","C"};

    double maxScore;
    int maxPos;

    void calculate() {
        int i,j;
        double sum;

        for(j=0;j<outputs.length;j++) {
            sum = 0.0;
            for (i = 0; i < inputs.length; i++) {
                sum += inputs[i] * hiddenUnits[j][i];
            }
            outputs[j] = sum;
            //System.out.println(sum);
        }
    }

    void max(double array[]) {
        maxScore=array[0];
        maxPos=0;
        int i;

        for(i=1;i<array.length;i++) {
            if (array[i] > maxScore) {
                maxScore = array[i];
                maxPos = i;
            }
        }
    }

    void printResult() {
        int i;

        // max score
        max(outputs);

        // display results
        System.out.printf("\nMax Score = %f  (%s)\n\n", outputs[maxPos],conclusions[maxPos]);
        for(i=0;i<outputs.length;i++)
            System.out.printf("Score = %10.2f  Conclusion = %s\n",outputs[i],conclusions[i]);
    }

    void backPropagation() {
        int i, j, k;
        double sumOfWeights; //sum for one "column"

        // calculate the error (expected - actual output)

        for(i=0;i<outputs.length;i++) error[i] = expected[i]-outputs[i];

        // calculate back propagation increase/decrease

        for(j=0;j<outputs.length;j++) {
            sumOfWeights=0.0;
            for(k=0;k<inputs.length;k++) sumOfWeights += hiddenUnits[j][k];

            for(i=0;i<inputs.length;i++) {
                percentageError[j][i] = hiddenUnits[j][i]/sumOfWeights;
                increaseByError[j][i] = percentageError[j][i]*error[j];
            }
        }

        // update hidden units

        for(j=0;j<outputs.length;j++) {
            for(i=0;i<inputs.length;i++) {
                hiddenUnits[j][i] = hiddenUnits[j][i] * increaseByError[j][i];
            }
        }
    }

    boolean done() {
        int maxPos1, maxPos2;
        double epsilon = 0.5; // error sum is below this limit
        double sumError = 0.0;
        calculate();
        max(outputs);
        maxPos1 = maxPos;
        max(expected);
        maxPos2 = maxPos;

        for(int i=0;i<error.length;i++) {
        	System.out.println(error[i]);
        	sumError += error[i];
        }
        System.out.println("Sum error: " + sumError);
        System.out.println("Epislon: " + epsilon);
        
        if (sumError <= epsilon)  {
        	return true;
        } else {
        	return false;
        }

    }
}
