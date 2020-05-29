import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.*;
import javax.swing.JFrame; //imports JFrame library
import javax.swing.JButton; //imports JButton library

import java.awt.Color;
import java.awt.GridLayout; //imports GridLayout library


public class World {

	 JFrame frame=new JFrame(); //creates frame
     JButton[][] grid; //names the grid of buttons
     
     //Constructor
     
     public World() {
    	 makeGrid();
     }
     
     private void makeGrid() {
    	 frame.setLayout(new GridLayout(20,20)); //set layout to a 20x20 grid
    	 
    	 grid=new JButton[20][20]; //allocate the size of grid
         for(int y=0; y<20; y++){
                 for(int x=0; x<20; x++){
                	 JButton b = new JButton(); //creates new button
                	 if (x==1 && ( y>=1 && y<=7)) {
                		b.setBackground(Color.green);
                	 }
                	 
                	 if (y==5 && ( x>=10 && x<=16)) {
                 		b.setBackground(Color.blue);
                 	 }
                	 
                	 if ( (x>=3 && x<=5) && (y>=12 && y<=16) ) {
                		 b.setBackground(Color.yellow);
                	 }
                	 //JButton b = new JButton("("+x+","+y+")"); //creates new button
                	
                	 //b.setBackground(Color.cyan);
                	 grid[x][y]= b;
                     frame.add(grid[x][y]); //adds button to grid
                 }
         }
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.pack(); //sets appropriate size for frame
         frame.setVisible(true);  
     }
     
     public static void main(String [] args) {
    	 new World();
     }
	
}
