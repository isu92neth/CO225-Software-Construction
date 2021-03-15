/*******************************************************************
                         E/16/012 
********************************************************************/

public class Quit extends GenericCommand { 

    /* Quit command 
     * Only quit should be there. 
     * no arguments, 
     */ 
    public void handleCommand(String [] args) { 

	if(!args[0].equals("quit")) someThingWrong(); 

	if(args.length != 1) { 
	    System.out.println("Usage: quit");
	    return;
	}

	/***
	 * ###### You need to print the number of commands 
	 * that was executed before exiting
	 */
	
	/*Include the quit command as an executed command*/
	 Shell shell=new Shell();
	int j=shell.i+1;
	 System.out.println("Executed "+j+" commands since starting");

	  

	/* OK, so just die */ 
	System.exit(0); 
    }

}