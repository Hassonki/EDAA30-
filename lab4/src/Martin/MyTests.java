package Martin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyTests {

	SudokuSolver s;

	@BeforeEach
	void setUp() throws Exception {
		s = new SudokuSolver();
	}

	@AfterEach
	void tearDown() throws Exception {
		s = null;
	}

	@Test
	void testEmpty() {
		assertEquals(true, s.solve(), "cant solve empty sudoku");
	}
	
	@Test
	void testFig1() {
		int[][] start = {   {0,0,8,0,0,9,0,6,2},
								 {0,0,0,0,0,0,0,0,5},
					   		 	 {1,0,2,5,0,0,0,0,0},
				 			     {0,0,0,2,1,0,0,9,0},
							     {0,5,0,0,0,0,6,0,0},
							 	 {6,0,0,0,0,0,0,2,8},
								 {4,1,0,6,0,8,0,0,0},
								 {8,6,0,0,3,0,1,0,0},
							     {0,0,0,0,0,0,4,0,0}
				          	};
		
		int[][]end = new int[9][9];
				
	    s.setMatrix(start);
	    
		System.out.print(s.solve());
		assertEquals(true, s.solve(), "cant solve the matrix");
	}
	
	@Test
	void testUnsolvableBox() {
		int[][] start = { {1,0,0,0,0,0,0,0,0},
				              {0,0,1,0,0,0,0,0,0},
	   		 	              {0,0,0,0,0,0,0,0,0},
				              {0,0,0,8,0,0,0,0,0},
	   		              	  {0,0,0,0,8,0,0,0,0},
				              {0,0,0,0,0,0,0,0,0},
	   		 	              {0,0,0,0,0,0,0,0,0},
				              {0,0,0,0,0,0,0,0,0},
	   		 	              {0,0,0,0,0,0,0,0,0}
         	};
		
	    s.setMatrix(start);
		System.out.print(s.solve());
		assertEquals(false, s.solve(), "cant solve empty sudoku");
	}
	
	@Test
	void testUnsolvableRow() {
		
		int[][] start = { {6,0,0,0,0,0,6,0,0},
	   		 	               {0,0,0,0,0,0,0,0,0},
				               {0,0,0,0,0,0,0,0,0},
	   	        	 	       {0,0,0,0,0,0,0,0,0},
				               {0,0,0,0,0,0,0,0,0},
	   		 	               {0,0,0,0,0,0,0,0,0},
				               {0,0,0,0,0,0,0,0,0},
	   		 	               {0,0,0,0,0,0,0,0,0},
	   		 	               {0,0,0,0,0,0,0,0,0}
         	};
		
	    s.setMatrix(start);
		System.out.print(s.solve());
	    
		assertEquals(false, s.solve(), "cant solve empty sudoku");
	}
	
	@Test
	void testUnsolvableCol() {
		
		int[][] start = {{0,0,0,0,0,0,0,0,8},
	   		 	              {0,0,0,0,0,0,0,0,0},
				              {0,0,0,0,0,0,0,0,0},
	   		 	              {0,0,0,0,0,0,0,0,0},
				              {0,0,0,0,0,0,0,0,0},
	   		 	              {0,0,0,0,0,0,0,0,0},
				              {0,0,0,0,0,0,0,0,0},
	   		 	              {0,0,0,0,0,0,0,0,8},
	   		 	              {0,0,0,0,0,0,0,0,0}
         	};
		
	    s.setMatrix(start);
		System.out.print(s.solve());
	    
		assertEquals(false, s.solve(), "cant solve empty sudoku");
	}

}
