import javax.swing.*;
import java.awt.*;

public class Test {
		
		private JFrame f; //frame is like a window
		
		public Test() {
			
			f = new JFrame("name of Jframe");
			
//			JButton b1,b2, b3, b4,b5;		
//			b1 = new JButton("Button 1");
//			f.add(b1);

			JButton b;
			
			for (int i = 1 ; i<=6 ; i++) {
				b = new JButton("Button " + i);
				f.add(b);
			}
			
			f.setLayout(new GridLayout(2,3));
			
			f.setVisible(true);
			f.setSize(600,400);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			

		}
		
		
		public static void main (String [] args) {
	
			new Test();
			
		}
}

