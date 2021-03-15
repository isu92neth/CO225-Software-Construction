class Student {
	String name;     /*Attribute to save student name*/
	int attendence;  /*Attribute to save student attendance*/
	
	/*Constructor to get student name and attendance*/
	
	Student(String name,int attendence){
		this.name=name;
		this.attendence=attendence;
	}
	
	/*Empty constructor*/
	Student(){}
	/*Method to get the attendance percentage of a student*/
	int getAttendencePercent(int attendence1) {
		int percent=(attendence*100)/45;
		return percent;
	}
	/*Method to get the average attendance percentage of all the students*/
	float averageAttendence(Student[] a,int noOfStu) {
		float total=0;
		for(int i=0;i<noOfStu;i++) {
			total+=a[i].getAttendencePercent(a[i].attendence);
		}
	
		float avg=total/noOfStu;
		return avg;
	}
}