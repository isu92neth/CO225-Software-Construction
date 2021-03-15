import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

class Main{
	public static void main(String args[]) {
		
		/*Read the class list text file*/
		
		BufferedReader descriptor = null; 
		//String line = null; 
		String [] names = new String[61]; // 61 names 
		try { 
		    descriptor = new BufferedReader(
				    new FileReader("D:\\Lab 1\\co225-classlist.txt"));

		    for(int i=0; i < names.length; i++) // assume file has 61 lines 
			names[i] = descriptor.readLine(); 

		    descriptor.close(); 

		} catch(IOException e) { 
		    // IOException is more generic (FileNotFound is a type of a 
		    // IOException, so catching only that is sufficient 
		    System.out.println("Bad things happen, what do you do!" + e);
		    return; 
		}
		
		/*Creates Student object*/
		
		Student[] stud=new Student[61];
		
		/*Creates Random object to generate random number for attendance*/
		
		Random rand = new Random();
		
		for(int i=0;i<names.length;i++) {
			stud[i]=new Student(names[i],rand.nextInt(45));
			
			/* Check if the attendance percentage of a student is less than 80% */
			
			if(stud[i].getAttendencePercent(stud[i].attendence)<80) {
				
				/*Prints the names of students with attendance less than 80% */
				System.out.println(stud[i].name);
			}
			
		}
		/*Student a=new Student();
		System.out.println((int)a.averageAttendence(stud, names.length)+"%");*/
		
	}
}
