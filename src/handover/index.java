package handover;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class index extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index frame = new index();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	int[][] TALs = new int[6][5];
	Color[] TALsColors = new Color[6];
	/**
	 * Create the frame.
	 */
	public index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 959, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		int x = 20;
		int y = 20;
		Random rand = new Random();
		
		
		TALs[0] = new int []{1,6,11,7, 16};
		TALs[1] = new int []{2,3,4,9, 1};
		TALs[2] = new int []{8,12,13,14, 15, 7};
		TALs[3] = new int []{5,10,15,20};
		TALs[4] = new int []{16,17,21,22 , 23};
		TALs[5] = new int []{23,24,25,18,19};
		
		
		
    	for(int i =0; i< TALs.length ; i++){
    		float r = rand.nextFloat();
        	float g = rand.nextFloat();
        	float b = rand.nextFloat();
        	Color randomColor = new Color(r, g, b, 0.2f);
        	TALsColors[i] = randomColor;
    	}
		
		
		int cells_counter = 0;
		JLabel[][] grid = new JLabel[5][5];
		for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
            	cells_counter++;
            	
            	grid[row][col] = new JLabel(cells_counter+"");
            	grid[row][col].setBounds(x, y, 100, 100);
            	
            	grid[row][col].setOpaque(true);
            	grid[row][col].setHorizontalAlignment(JLabel.CENTER);
            	grid[row][col].setVerticalAlignment(JLabel.CENTER);
            	
            	if(getCellTALs(cells_counter).length == 1)
            		grid[row][col].setBackground(TALsColors[getCellTALs(cells_counter)[0]]);
            	else{
            		grid[row][col].setBackground(new Color(255,255,255));
            	}
            	
            	contentPane.add(grid[row][col]);
            	x = x+100;
            }
            y = y+100;
            x = 20;
		}
		
		procedure1();
	}
	
	private int[] getCellTALs(int cell){
		int[] ts = new int[2];
		int counter = 0;
		for(int i =0; i< TALs.length ; i++){
			boolean contains = IntStream.of(TALs[i]).anyMatch(x -> x == cell);
			if(contains){
				ts[counter] = i;
				counter++;
			}
    	}
		
		int[] tscopy = new int[counter];
		System.arraycopy(ts, 0, tscopy, 0, tscopy.length);
		return tscopy;
	}
	
	private void procedure1(){
		UE ue1 = new UE();
		ue1.location = 1;
		ue1.speed = 10;
		ue1.eNOB = 1;
		ue1.TAL = 0;
		ue1.path = new int[]{2 ,7 , 12 , 17 , 22};
	}
}
