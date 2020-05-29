public class PerceptronProgrammable {
    double inputs[]        = {2,2,0,0};
    double hiddenUnits[][] = {
            {1,1,0,0},
            {1,0,0,0},
            {0,1,0,0}
    };
    double outputs[]       = {0,0,0};
    String conclusions[]   = {"A","B","C"};

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
        int maxPos=0;
        int i;

        // max score
        for(i=1;i<outputs.length;i++) {
            if (outputs[i] > maxScore) {
                maxScore = outputs[i];
                maxPos = i;
            }
        }

        // display results
        System.out.printf("\nMax Score = %f  (%s)\n\n", outputs[maxPos],conclusions[maxPos]);
        for(i=0;i<outputs.length;i++)
            System.out.printf("Score = %10.2f  Conclusion = %s\n",outputs[i],conclusions[i]);
    }
}
