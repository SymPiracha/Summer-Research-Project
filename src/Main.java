
public class Main {

    public static void main(String[] args) {
	    PerceptronProgrammable x = new PerceptronProgrammable();
//	    x.calculate();;
//	    x.printResult();

	    PerceptronLearning y = new PerceptronLearning();
	    do {
			y.calculate();
			y.printResult();
			y.backPropagation();
		} while (!y.done());

	    y.printResult();
    
//	    y.calculate();
//	    y.printResult();
//	    y.backPropagation();
//	    
//	    System.out.println(y.hiddenUnits[0][0]);
//	    System.out.println(y.hiddenUnits[1][0]);
//	    System.out.println(y.hiddenUnits[2][0]);
//	    System.out.println(y.hiddenUnits[3][0]);
//	    
//	    y.calculate();
//	    y.printResult();
//	    y.backPropagation();
//	    
//	    System.out.println(y.hiddenUnits[0][0]);
//	    System.out.println(y.hiddenUnits[1][0]);
//	    System.out.println(y.hiddenUnits[2][0]);
//	    System.out.println(y.hiddenUnits[3][0]);
	    
    }
}

