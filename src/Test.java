import javax.swing.*;
import java.awt.*;

public class Test {
		
		//Tut 2
		
		private JFrame f; //frame is like a window
		private JPanel p;
		private JButton b1;
		private JLabel lab;
		
		public Test() {
			
			gui();
			
		}
		
		public void gui() {
			f = new JFrame("name pf Jframe");
			f.setVisible(true);
			f.setSize(600,400);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			p = new JPanel();
			p.setBackground(Color.CYAN);
			
			b1 = new JButton("Test");
			lab = new JLabel("This is a test label");
			
			p.add(b1);
			p.add(lab);
			
			f.add(p);
			
			
		}
		
		public static void main (String [] args) {
		
			//Tut 1
			
			/*Simulator s = new Simulator();
			s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			s.setSize(275,180);
			s.setVisible(true);*/
			
			//Tut 2
			
			new Test();
			
		}
}

