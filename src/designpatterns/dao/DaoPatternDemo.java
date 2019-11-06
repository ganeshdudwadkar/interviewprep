package designpatterns.dao;

/*

Data Access Object Pattern or DAO pattern is used to separate low level data accessing API or operations from
high level business services. Following are the participants in Data Access Object Pattern.

Data Access Object Interface - This interface defines the standard operations to be performed on a model object(s).

Data Access Object concrete class - This class implements above interface. This class is responsible to get data from
a data source which can be database / xml or any other storage mechanism.

Model Object or Value Object - This object is simple POJO containing get/set methods to store data retrieved using DAO class.

Step 1 - Create Value Object - Student.java
Step 2 - Create Data Access Object Interface - StudentDao.java
Step 3 - Create concrete class implementing above interface - StudentDaoImpl.java
Step 4 - Use the StudentDao to demonstrate Data Access Object pattern usage.

 */
public class DaoPatternDemo {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();

        //print all students
        for (Student student : studentDao.getAllStudents()) {
            System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
        }


        //update student
        Student student = studentDao.getAllStudents().get(0);
        student.setName("Michael");
        studentDao.updateStudent(student);

        //get the student
        studentDao.getStudent(0);
        System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
    }
}

/*

Step 5 - Verify the output.

Student: [RollNo : 0, Name : Robert ]
Student: [RollNo : 1, Name : John ]
Student: Roll No 0, updated in the database
Student: [RollNo : 0, Name : Michael ]

 */