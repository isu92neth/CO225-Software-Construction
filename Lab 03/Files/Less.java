/*******************************************************************
                         E/16/012 
********************************************************************/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Less extends GenericCommand{
	 public void handleCommand(String [] args) {
		 
		 if(!args[0].equals("less")) someThingWrong();
		 
		 /*Increment the varaible i to count less as an executed command*/
		 Shell shell=new Shell();
	     shell.i+=1;
         
		 File file =null;
		 
		 /*Check if command executed has 2 arguments*/
		 
		 if(args.length==2){
			 file= new File(args[1]);
		 }
		 else {
			 System.out.println("Usage: less TextFileToBeRead.txt");
			 return;				
		 }
		 
		 /*Check if the input argument is a text file with extension .txt*/
		 
		 String text1=args[1];
		 if(text1.contains(".") ) {
			 String text=args[1].substring(args[1].lastIndexOf("."));
			 if(!text.equals(".txt")) {
				 System.out.println("This is not a text file");
				 System.out.println("Usage: less TextFileToBeRead.txt");
				 return;
			 }
		 }
		 else {
			 System.out.println("This is not a text file");
			 System.out.println("Usage: less TextFileToBeRead.txt");
			 return;
		 }
		 
		 /*Read and print the content in text file*/
		 
		 try {
			 BufferedReader br=new BufferedReader(new FileReader(file));
			 String st;
			 while((st=br.readLine())!=null) {
				 System.out.println(st);
			 }
		}
		 
		 /*FileNotFoundException is handled*/
		 
		 catch(FileNotFoundException nf) {
				System.out.println("FileNotFoundException occurred");
				return;
		 }
		 
		 /*IOException is handled*/
		 
		 catch (IOException e) {
			System.out.println("IOException occurred");
			return;
		 }
		 
	 }
}