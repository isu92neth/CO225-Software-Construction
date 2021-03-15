/*******************************************************************
                         E/16/012 
********************************************************************/
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class Copy extends GenericCommand{
	public void handleCommand(String [] args) {
		
		if(!args[0].equals("copy")) someThingWrong();
		
		/*Increment the varaible i to count less as an executed command*/
		 Shell shell=new Shell();
	     shell.i+=1;
        
        /*Check if command executed has 3 arguments*/
        
		if(args.length!=3) {
			System.out.println("Usage: copy SourceFileName DestinationFileName");
			return;
		}
		
		/*Copy the Source file to Destination file*/
		
		FileInputStream is=null;
		FileOutputStream os=null;
		try {
			File inFile=new File(args[1]);
			File outFile=new File(args[2]);
			
			/*Check if Source file exists*/
			
			if(!inFile.exists()) {
				System.out.println("Source file doesn't exist");
			}
			
			/*Check if Destination file exists*/
			
			if(!outFile.exists()) {
				System.out.println("Destination file doesn't exist.");
			}
			
			is=new FileInputStream(inFile);
			os=new FileOutputStream(outFile);
			byte[] buffer=new byte[1024];
			int length;
			while ((length=is.read(buffer))>0) {
				os.write(buffer, 0, length);
				
			}
			is.close();
			os.close();
			System.out.println("File copied successfully");

		}
		
		/*FileNotFoundException is handled*/
		
		catch(FileNotFoundException nf) {
			System.out.println("FileNotFoundException occurred");
			return;
		}
		
		/*NoSuchFileException is handled*/
		
		catch(NoSuchFileException nf) {
			
		    System.out.println("NoSuchFileException occurred");
			return;
		}
		
		/*IOException is handled*/

		catch (IOException e) {
			System.out.println("IOException occurred");
			return;
		}
	 
	}
}



