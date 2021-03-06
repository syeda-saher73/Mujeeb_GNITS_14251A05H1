import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) throws IllegalArgumentException{
		// Add your implementation here
		if (students == null)
			throw new IllegalArgumentException("null argument");
		this.students = students;
	}

	@Override
	public Student getStudent(int index) throws IllegalArgumentException{
		// Add your implementation here
		if(index<0||index>=students.length)
			throw new IllegalArgumentException("invalid index");
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) throws IllegalArgumentException{
		// Add your implementation here
		if(index<0||index>=students.length)
			throw new IllegalArgumentException("invalid index");
		Student[] res = new Student[students.length];
		for(int i=0;i<index;i++)
			res[i]=students[i];
		res[index]= student;
	this.students = res;
	}

	@Override
	public void addFirst(Student student) throws IllegalArgumentException{
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException("invalid index");
		Student[] result = new Student[students.length];
    result[0] = student;
    for(int i = 1; i < students.length; i++)
        result[i] = students[i - 1];
	this.students= result;
		
	}

	@Override
	public void addLast(Student student) throws IllegalArgumentException{
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException("invalid index");
		Student[] result = new Student[students.length];
		result[students.length]=student;
		this.students=result;
	}

	@Override
	public void add(Student student, int index)  throws IllegalArgumentException{
		// Add your implementation here
		if(index<0||index>=students.length)
			throw new IllegalArgumentException("invalid index");
		Student[] res = new Student[students.length];
		for(int i=0;i<index;i++)
			res[i]=students[i];
		res[index]= student;
		 for(int i = index + 1; i < students.length; i++)
        res[i] = students[i - 1];
	this.students = res;
	}

	@Override
	public void remove(int index)  throws IllegalArgumentException{
		// Add your implementation here
		if(index<0||index>=students.length)
			throw new IllegalArgumentException("invalid index");
		  int shift = 0;                             
    for (int i = 0; i < students.length; i++) {       
        if (shift < index && i == index)  // i-th item needs to be removed
            shift++;                            // increment `shift`
        else 
            students[i - shift] = students[i];                // move i-th item `shift` positions left
    }
    for (int i = students.length - shift; i < students.length; i++)
        students[i] = null; 
	}

	@Override
	public void remove(Student student) throws IllegalArgumentException{
		// Add your implementation here
		int index=-1;
		if(student==null)
			throw new IllegalArgumentException("Student not exist");
		   for (int i = 0; i < students.length; i++) {
            if (students[i].equals(student)) {
                index = i;
                break;
            }
        }
		int shift = 0;                             
    for (int i = 0; i < students.length; i++) {       
        if (shift < index && i == index)  // i-th item needs to be removed
            shift++;                            // increment `shift`
        else 
            students[i - shift] = students[i];                // move i-th item `shift` positions left
    }
    for (int i = students.length - shift; i < students.length; i++)
        students[i] = null; 

		
		
	}

	@Override
	public void removeFromIndex(int index) throws IllegalArgumentException{
		// Add your implementation here
		if(index<0||index>=students.length)
			throw new IllegalArgumentException("invalid index");
		Student[] res = new Student[students.length];
		for(int i=0;i<=index;i++)
			res[i]=students[i];
		this.students = res;
		
	}

	@Override
	public void removeFromElement(Student student)  throws IllegalArgumentException{
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException("invalid index");
		int index=-1;
		for (int i = 0; i < students.length; i++) {
            if (students[i].equals(student)) {
                index = i;
                break;
            }
        }
		Student[] res = new Student[students.length];
		for(int i=0;i<=index;i++)
			res[i]=students[i];
		this.students = res;
		
	}

	@Override
	public void removeToIndex(int index) throws IllegalArgumentException{
		// Add your implementation here
		if(index<0||index>=students.length)
			throw new IllegalArgumentException("invalid index");
		
		Student[] res = new Student[students.length];
		for(int i=index;i<students.length;i++)
			res[i]=students[i];
		this.students = res;
		
	}

	@Override
	public void removeToElement(Student student) throws IllegalArgumentException{
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException("invalid index");
		int index=-1;
		for (int i = 0; i < students.length; i++) {
            if (students[i].equals(student)) {
                index = i;
                break;
            }
        }
			Student[] res = new Student[students.length];
		for(int i=index;i<students.length;i++)
			res[i]=students[i];
		this.students = res;
	
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		       int n = students.length;  
        Student temp;  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(students[j-1].compareTo(students[j])==0){  
                                 //swap elements  
                                 temp = students[j-1];  
                                 students[j-1] = students[j];  
                                 students[j] = temp;  
                         }  
                          
                 }  
         }  
	}

	@Override
	public Student[] getByBirthDate(Date date) throws IllegalArgumentException{
		// Add your implementation here
		if(date==null)
			throw new IllegalArgumentException("invalid date");
		Student[] res = new Student[students.length];
		for(int i=0;i<students.length;i++)
		{
			if(students[i].getBirthDate().compareTo(date)==0){
				res[i]=students[i];
			}
		}
		
		return res;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) throws IllegalArgumentException{
		// Add your implementation here
		if(firstDate==null||lastDate==null)
			throw new IllegalArgumentException("invalid date");
		Student[] res = new Student[students.length];
		for(int i=0,k=0;i<students.length;i++)
		{
			if(students[i].getBirthDate().compareTo(firstDate)>0||students[i].getBirthDate().compareTo(lastDate)<0){
				res[k]=students[i];
				k++;
			}
		}
		return res;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		
		Student[] res = new Student[students.length];
		
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		double max=0.0;
		Student[] res =  new Student[students.length];
		for(int i=0;i<students.length;i++)
		{
			max=students[i].getAvgMark();
			if((students[i].getAvgMark())>max)
				max=students[i].getAvgMark();
		}
	for(int i=0,k=0;i<students.length;i++)
		{
		  if((students[i].getAvgMark())==(max))
		  {
			  res[k]=students[i];
			  k++;
		  }
		}
		return res;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
			int index=-1;
		//	Student[] res= new Student[students.length];
			Student res;
		for (int i = 0; i < students.length; i++) {
            if (students[i].equals(student)) {
                index = i;
                break;
            }
        }
		res = students[index+1];
		
		return res;
	}
}
