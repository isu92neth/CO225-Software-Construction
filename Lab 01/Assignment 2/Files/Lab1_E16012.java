class Lab1_E16012 { 
	
	/*Method to find local maxima of an array*/

    public static void showMaxima(int [] array) { 
	// implement 
    	int count=0;
    	for(int i=1;i<array.length-1;i++) {
    		if(array[i]>=array[i-1] && array[i]>=array[i+1]) {
    			count++;
    			System.out.println(array[i]);
    		}
    	}
		
		/*Check if there are no local maxima in the array*/
		
    	if(count==0) {
    		System.out.println("There are no local maxima");
    	}
    }

    public static void main(String [] args) { 
    int [] array = {0, 1, 2, 1, 0, -1, 2, 3, 5, 6, 7, 4, 3, 4, 6, 5, 4};
	showMaxima(array);
    }
}