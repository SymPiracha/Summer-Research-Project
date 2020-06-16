import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class World {

	 JFrame frame=new JFrame("World"); //creates frame
	 JButton world[][];
	 JPanel grid = new JPanel();
     
     //Constructor
     
     public World(int xLength,int yLength) {
    	 makeGrid(xLength,yLength);
     }
     
     private void makeGrid(int xLength,int yLength) {
    	 //Build a window
    	 this.frame.setSize(1000,1000);
    	 this.frame.setLayout(new GridLayout(1, 1));
    	 //Build the world
    	 world = new JButton[xLength][yLength];
    	 //The GUI that will store the world
         this.grid.setLayout(new GridLayout(xLength, yLength));
    	 //adding GUI to window
         this.frame.add(grid);
         
         //Create each cell of our world as a JButton and add it to the grid (GUI)
         int i,j;
         for(i=0;i<xLength;i++) {
             for(j=0;j<yLength;j++) {
                 world[i][j] = new JButton(i+","+j);
                 grid.add(world[i][j]);
             }
         }
         frame.setVisible(true);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     }
     
     public static void pauseForOneSecond() {
         try {
             TimeUnit.SECONDS.sleep(1);
         }
         catch(InterruptedException e) {
             System.out.println("Wait issue");
         }

     }
    
     public void addTextToButton(int x,int y, String text) {
    	 this.world[x][y].setText(text);
    	 grid.revalidate();
         grid.repaint();
     }
     
     //make object move horizontally, specify start and end coord, as well as the row you would like it to move on
     public void makeObjectMoveAcrossX(int startX, int endX, int rowY) {
    	 String old = null;
    	 for(int i=startX;i<endX;i++) {
           // add the moving text to the world
           if (old != null) {
        	   world[rowY][i-1].setText(old);
           }
           old = world[rowY][i].getText();
           world[rowY][i].setText("MOVED");
           world[rowY][i].setBackground(Color.blue);
           
  
           // redraw the window
           grid.revalidate();
           grid.repaint();
  
           // give time for the user to see it
           pauseForOneSecond();
    	 }
     }
   //make object move vertically, specify start and end coord, as well as the column you would like it to move on
     public void makeObjectMoveAcrossY(int startY, int endY, int colX) {
    	 String old = null;
    	 for(int i=startY;i<endY;i++) {
           // add the moving text to the world
           if (old != null) {
        	   world[i-1][colX].setText(old);
           }
           old = world[i][colX].getText();
           world[i][colX].setText("MOVED");
           world[i][colX].setBackground(Color.yellow);
  
           // redraw the window
           grid.revalidate();
           grid.repaint();
  
           // give time for the user to see it
           pauseForOneSecond();
    	 }
     }
     
     public static void main(String [] args) {
    	 World x = new World(10,10);
    	 x.addTextToButton(1, 1, "LOL");
    	 x.makeObjectMoveAcrossX(2, 7, 5);
    	 x.makeObjectMoveAcrossY(2, 10, 4);
     }
	
}
//private void makeGrid(int xLength,int yLength) {
//frame.setLayout(new GridLayout(1,1)); //set layout to a 20x20 grid
//
//grid=new JButton[xLength][yLength]; //allocate the size of grid
//for(int y=0; y<yLength; y++){
//        for(int x=0; x<xLength; x++){
//       	 JButton b = new JButton(); //creates new button
//       	 if (x==1 && ( y>=1 && y<=7)) {
//       		b.setBackground(Color.green);
//       	 }
//       	 
//       	 if (y==5 && ( x>=10 && x<=10)) {
//        		b.setBackground(Color.blue);
//        	 }
//       	 
//       	 if ( (x>=3 && x<=5) && (y>=10 && y<=10) ) {
//       		 b.setBackground(Color.yellow);
//       	 }
//       	 //JButton b = new JButton("("+x+","+y+")"); //creates new button
//       	
//       	 //b.setBackground(Color.cyan);
//       	 grid[x][y]= b;
//            frame.add(grid[x][y]); //adds button to grid
//        }
//}
//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//frame.pack(); //sets appropriate size for frame
//frame.setVisible(true);  
//}
//
