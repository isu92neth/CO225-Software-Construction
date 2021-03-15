import java.util.Arrays;

/* my array list: an array that behaves like a list 
 * E/16/012
 */

public class MySet<T/* Can we have any T - YES */> { 

    int nextItem; 
    int currentCapacity; 
    T[] data; // DO NOT CHANGE

    private static int defaultSizeToCreate = 10; // how many elements to create 


	@SuppressWarnings("unchecked")
	public MySet(int elements) { 
	this.nextItem = 0; 
	defaultSizeToCreate = elements; 
	this.currentCapacity = elements; 

	this.data = (T[]) new Object[defaultSizeToCreate]; 
    }

    public MySet() { 
	this(defaultSizeToCreate); 
    }

    /* Used if array is empty */
    public boolean isEmpty() { return this.nextItem == 0; } 
    /* Used if array is full */
    public boolean isFull() { return nextItem == currentCapacity ; /* never get filled */} 
    
    /* Method used to resize the array when it is full */
    public void array_resize(T item) {
    	/* New array with new size */
    	T[] newArray = Arrays.copyOf(data,currentCapacity+defaultSizeToCreate);               
        data = newArray;
        /* Add the new item to the resized array */
        data[currentCapacity] = item; 
        currentCapacity = currentCapacity + defaultSizeToCreate;
        nextItem++;
    }

    public boolean add(T item) { 
    	/* if there is any element delete it 
    	 * then add the new element. 
    	 * How do you handle when the array is full: 
    	 * crate a new array with currentCapacity+defaultSizeToCreate, 
    	 * copy the old conents into that
    	 * Accessing array when full might be a problem
    	 */
    	
    	/* Add the item to the array if the item is not there */
    	try {
    		for(Object element :data){
    			/* Check if elements in the set or the item to be added is null */
    			if(element == null){
    				if(item == null)return false;
    			}
    			/* Check if the item is already in the set */
    			else if (element.equals(item))return false;
    	    }
		} catch (NullPointerException e) {
			/* NullPointerException is handled */
			System.out.println("NullPointerException occurred");
		}
    	/* Check if the array is full */
    	if(isFull()){
        	array_resize(item);
            /* The new item is added */
            return true;
        }
    	/* Add the new item to the list */
    	else {
    		data[nextItem] = item;
    		nextItem++;
    		try {
    			data[nextItem] = null; // DO NOT CHANGE
    			
			} catch (ArrayIndexOutOfBoundsException e) {
				/* ArrayIndexOutOfBoundsException is handled */
			}
    		return true;
    	}	
	//return false; // CHANGE ME

    }


    public T remove() { 
	/* remove the first element in the array 
	 * and copy the rest front. 
	 * FIFO structure. 
	 * If the ArrayList is empty return null
	 */
	/* Option 1: */
	if(isEmpty()) return null; 
	// IMPLEMENT THE REST 
	else
	{
		/* To return the element */
		T output = null;
		try {
			/* Return the first element of the set */
			output = data[0];
			int i=0;
			for(T element : data) {
				/* Copy the rest of the elements to the front */
				if(i<currentCapacity-1) {
					data[i] = data[i+1];
				}
				i++;
			}		
			/* Last item of the set is set to null */
			data[currentCapacity-1] = null;
			
		} catch (ArrayIndexOutOfBoundsException e) {
			/* ArrayIndexOutOfBoundsException is handled */
			System.out.println("ArrayIndexOutOfBoundsException occurred");
		}
		
		
		return output;
	}

	/* Option 2: */
	/*if(!isEmpty()) { 
	    // IMPLEMENT THE REST
	    T output;
		output = data[0];
		int i=0;
		for(T element : data) {
			if(i<currentCapacity-1) {
				data[i]=data[i+1];
			}
			i++;
		}
		data[currentCapacity-1]=null;
		return output;
		
	}
	return null;
	*/
	// which option is better? why? - Option 1 is better as it increases the readability
    }


}
	 

	
	