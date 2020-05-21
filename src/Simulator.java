import java.awt.FlowLayout;
import javax.swing.JLabel;


import javax.swing.JFrame; //imports JFrame library
import javax.swing.JButton; //imports JButton library
import java.awt.GridLayout; //imports GridLayout library

public class Simulator extends JFrame {

	private JLabel item1;
	
	public Simulator() {
		super("The Title bar");
		setLayout(new FlowLayout());
		
		item1 = new JLabel("this is a sentence");
		item1.setToolTipText("This is gonna show up on hover");
		add(item1);
		
	}
	
}