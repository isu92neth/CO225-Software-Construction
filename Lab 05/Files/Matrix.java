/* CO225 Lab 5: Java threads */
/* Author : Adikari A.M.I.N. */
/* Reg No : E/16/012 */

/* 1. How to use threads to parallelize the operation?
		We can use one thread to calculate one element in the output matrix c.
		Therefore more than one threads are used to calculate elements in the output matrix c.
		Since all the threads can be run parallely, the  operation of calculating elements of the output matrix c is parallelized.
		
   2. How may threads to use?
		Number of threads to use = Number of elements of the output matrix calculate
		                         = x (Number of rows of first matrix) * y (Number of columns of second matrix)

   3. How to allocate work for each thread (recall it is the run function which all the threads
execute) 
		Each thread is used to calculate each element of the output matrix c.
		Since run method is called when a thread starts, the calculation of each element can be done in run method.
		Therefore the run method calculates one element per thread.
		
   4. How to synchronize?
		Since the calculation of elements is done in the run method and no other methods are used we do not need synchronization.
		Because each thread is allowed to access the run method without restriction, as there is only one thread actually accessing the method.
		But if there were any other methods or objects shared by all the threads that method or object need to be synchronized */
	

public class Matrix extends Thread { 

    private static int [][] a; /* First matrix */
    private static int [][] b; /* Second matrix */
    private static int [][] c; /* Output matrix */
	
	
	private static Matrix threads[][];

    /* You might need other variables as well */
	/* i1 : To store i
	   j1 : To store j
	   z : To store z1 */
	private int i1, j1, z;

    public Matrix(int i1, int j1, int z, int[][]a1, int[][]b1) { // need to change this, might need some information
    	this.i1 = i1;
    	this.j1 = j1;
    	this.z = z;
    	a = a1;
    	b = b1;
    }

	/* Run method will calculate each element of the matrix c */
	public void run() {
    	int  k, s;
    		for(s=0, k=0; k<z; k++) 
    		    s += a[i1][k] * b[k][j1];
    		c[i1][j1] = s;
    	    
    }
	
    public static int [][] multiply(int [][] a, int [][] b) {

	/* check if multipication can be done, if not 
	 * return null 
	 * allocate required memory 
	 * return a * b
	 */

	int x = a.length;    /* Number of rows of first matrix */
	int y = b[0].length; /* Number of columns of second matrix */

	int z1 = a[0].length; /* Number of columns of the first matrix */
	int z2 = b.length;    /* Number of rows of the second matrix */

	if(z1 != z2) { 
	    System.out.println("Cannnot multiply");
	    return null;
	}

	/* Create number of threads equal to the number of elements of the output matrix */
	threads = new Matrix[x][y];
	
	c = new int [x][y];

	/* Start the threads */
	for(int i = 0;i < x;i++) {
		for(int j = 0;j < y;j++) {
			threads[i][j] = new Matrix(i, j, z1, a, b);
			threads[i][j].start(); /* run method is called */
		}
	}
	
	/* Wait for finishing all the threads */
	for(int i = 0;i < x;i++) {
		for(int j = 0;j < y;j++) {
			try {
				threads[i][j].join();
			} catch (InterruptedException e) {
				System.out.println("InterruptedException is occurred");
			}
		}
	}

	return c; 
    }

}