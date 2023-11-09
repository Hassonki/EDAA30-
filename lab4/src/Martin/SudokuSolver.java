package Martin;

import java.util.HashSet;

public class SudokuSolver {
	
	private int[][] gameboard;
	
	public SudokuSolver()
	{
		 gameboard = new int[9][9];
	}
	
	/**
	 * Solves the sudoku
	 * @return true if it was possible to solve, if not return false
	 */
	public boolean solve()
	{	
		boolean holder = true;
		for(int r = 0; r < 9; r++)
		{
			for(int c = 0; c < 9; c++)
			{
				if(gameboard[r][c] != 0)
				{
					int temp = gameboard[r][c];
					gameboard[r][c] = 0;
					if(!legal(r, c,temp))
					{
						holder = false;
					}
					gameboard[r][c] = temp;
				}
			}
		}
		
		if(holder == false)
		{
			return false;
		}
		
		return help();
	}
	
	/**
	 * helping function to solve sudoku
	 * @return true if it was possible to solve, if not return false
	 */
	private boolean help()
	{
		for(int r = 0; r < 9; r++)
		{
			for(int c = 0; c < 9; c++)
			{
				if(gameboard[r][c] == 0)
				{
					for(int nbr = 1; nbr <= 9; nbr++)
					{
						
						if(legal(r, c, nbr))
						{
							gameboard[r][c] = nbr;
							
							if(solve())
							{
								return true;
							}
							else {
								gameboard[r][c] = 0;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * checks row if it contains number
	 * @param row
	 * @param number
	 * @return true if containing number, false if not
	 */
	private boolean isInRow(int row, int number)
	{
		for(int i = 0; i < 9; i++)
		{
			if(gameboard[row][i] == number)
			return true;
		}
		
		return false;
	}
	
	/**
	 * checks column if it contains number
	 * @param col
	 * @param number
	 * @return true if containing number, false if not
	 */
	private boolean isInCol(int col, int number)
	{
		for(int i = 0; i < 9; i++)
		{
			if(gameboard[i][col] == number)
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * checks box if it contains number
	 * @param row
	 * @param col
	 * @param number
	 * @return true if box is containing number, false if not
	 */
	private boolean isInBox(int row, int col, int number)
	{
		int r = row - row % 3;
		int c = col - col % 3;
		
		for(int i = r; i < r + 3; i++)
		{
			for(int j = c; j < c + 3; j++)
			{
				if(gameboard[i][j]==number)
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * checks if x is within interval
	 * @param x
	 * @return true if x is within interval, otherwise false
	 */
	private boolean alignLegal(int x)
	{
		return x >= 0 && x <9;
	}
	
	/**
	 * checks if nbr is within interval
	 * @param nbr
	 * @return true if nbr is within interval, otherwise false
	 */
	private boolean nbrLegal(int nbr)
	{
		return nbr > 0 && nbr < 10;
	}
	
	/**
	 * checks if nbr is legal to put at (row,col)
	 * @param row
	 * @param col
	 * @param nbr
	 * @return true if its legal
	 */
	private boolean legal(int row, int col, int nbr)
	{
		return !isInRow(row, nbr) && !isInCol(col, nbr) && !isInBox(row, col, nbr);
	}
	
/*
	public void setBox(int row, int col, int nbr)
	{
		gameboard[row][col] = nbr;
	}
	
	public int getBox(int row, int col)
	{
		return gameboard[row][col];
	}*/
	
	/**
	 * puts nbr in array at [row][col], if its not a valid number or if row or col is out of bounds throw exception
	 * @param row
	 * @param col
	 * @param nbr
	 */
	public void set(int row, int col, int nbr)
	{
		if(nbrLegal(nbr) && alignLegal(row) && alignLegal(col))
			gameboard[row][col] = nbr;
		
		else throw new IllegalArgumentException();
	}
	
	/**
	 * remove number at [row][col],if row or col is out of bounds throw exception
	 * @param row
	 * @param col
	 */
	public void remove(int row, int col)
	{
		if(alignLegal(row) && alignLegal(col))
			gameboard[row][col] = 0;
		
		else throw new IllegalArgumentException();
	}
	
	/**
	 * check if matrix have the right lengths
	 * @param matrix
	 * @return return true if matrix have the right lengths otherwise return false
	 */
	private boolean legalMatrix(int[][] matrix)
	{
		return matrix.length == 9 && matrix[0].length == 9;
	}
	
	/**
	 * reboot array
	 */
	public void clear()
	{
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				gameboard[j][i] = 0;
			}
		}
	}

	/**
	 * Set the current gameboard to the new matrix, if size is to big or if numbers are not between 1-9 throw exception
	 * @param matrix
	 */
	public void setMatrix(int[][] matrix)
	{
		HashSet<Integer> temp = new HashSet<>();
		int max= 9, min = 0;
		
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				temp.add(matrix[j][i]);
				
				if(matrix[j][i]< min)
					min = matrix[j][i];
				
				if(matrix[j][i] > max)
					max = matrix[j][i];
			}
		}
		
		if(temp.size() > 10 && (max > 9 || min < 0) && legalMatrix(matrix))
		{
			throw new IllegalArgumentException();
		}
		
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				gameboard[j][i] = matrix[j][i];
			}
		}
	}
	
	/**
	 * @return return the gameboard
	 */
	public int[][] getMatrix()
	{
		return gameboard;
	}

}
