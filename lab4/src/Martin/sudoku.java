package Martin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import sud.SudokuSolver;

public class sudoku {

	public static void main(String[] args) {

		SudokuSolver s = new SudokuSolver();
		
		JFrame frame = new JFrame("fönster");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();
		
		JButton solve = new JButton("Solve");
		JButton clear = new JButton("Clear");
		
		
		JPanel panelTop = new JPanel();
		panelTop.setLayout(new GridLayout(9,0));
		
		JTextField [][] txt = new JTextField[9][9];
		
		for(int i = 0; i < 9; i ++)
		{
			for(int j = 0; j < 9; j ++)
			{
				JTextField temp = new JTextField("", 2);
				
				if((j>=0 && j <3 &&( i >= 0 && i< 3 || i<9 && i>5)) 
					|| ( j >5 && j<9 && (i >= 0 && i< 3 || i<9 && i>5)))
					temp.setBackground(Color.CYAN);	
				
				else if(j>=3 && j <6 && i<6 && i>=3)
					temp.setBackground(Color.CYAN);
				
				else
					temp.setBackground(Color.WHITE);
				
				txt[i][j] = temp;
				panelTop.add(txt[i][j]);
			}
		}
		
		solve.addActionListener(event -> {
			
			StringBuilder sb = new StringBuilder();
			
			int[][] temp = new int[9][9];
			
			int a, b;
			
			for(int i = 0; i < 9; i ++)
			{
				for(int j = 0; j < 9; j ++)
				{
					if(txt[i][j].getText().equals("1") || txt[i][j].getText().equals("2") || txt[i][j].getText().equals("3")
							||txt[i][j].getText().equals("4") || txt[i][j].getText().equals("5") || txt[i][j].getText().equals("6")
							||txt[i][j].getText().equals("7") || txt[i][j].getText().equals("8") || txt[i][j].getText().equals("9"))//!txt[i][j].getText().equals(""))
					{
						a = Integer.parseInt(txt[i][j].getText());
						b =Integer.parseInt(txt[i][j].getText());
						
							temp[j][i] = Integer.parseInt(txt[i][j].getText());
							
					}
					else if(txt[i][j].getText().equals(""))
					{
						temp[j][i] = 0;
					}
					else
					{
						txt[i][j].setText("");
						JOptionPane.showMessageDialog(null,"Fel inskrift", "Fel", JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
			
			s.setMatrix(temp);
			
			temp = s.getMatrix();
			
			if(!s.solve())
			{
				JOptionPane.showMessageDialog(null,"Finns ingen lösning till sudokut försök fylla i på nytt", "Fel", JOptionPane.PLAIN_MESSAGE);
				s.clear();	
			}
			
			for(int i = 0; i < 9; i ++)
			{
				for(int j = 0; j < 9; j ++)
				{
					if(temp[i][j] != 0)
						sb.append(temp[i][j]);
					
					else
						sb.append("");
						
					txt[j][i].setText(sb.toString());
					sb.delete(0, sb.length());
				}
			}
			/*
			for(int i = 0; i < 9; i ++)
			{
				for(int j = 0; j < 9; j ++)
				{
					System.out.print(" " +temp[j][i]);
				}
				System.out.print("\n");
			}*/
		});

		clear.addActionListener(event -> {
			s.clear();
			
			for(int i = 0; i < 9; i ++)
			{
				for(int j = 0; j < 9; j ++)
				{
					txt[i][j].setText("");
				}
			}
		});
		
		
		JPanel panelBot = new JPanel();
		
		panelBot.add(solve);
		panelBot.add(clear);
		
		pane.add(panelBot, BorderLayout.SOUTH);
		pane.add(panelTop, BorderLayout.NORTH);
		
		frame.pack();
		frame.setVisible(true);
	}

}

