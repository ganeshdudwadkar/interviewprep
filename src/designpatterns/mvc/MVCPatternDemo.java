package designpatterns.mvc;

/*

MVC Pattern stands for Model-View-Controller Pattern. This pattern is used to separate application's concerns.

Model - Model represents an object or JAVA POJO carrying data. It can also have logic to update controller if its data changes.

View - View represents the visualization of the data that model contains.

Controller - Controller acts on both model and view. It controls the data flow into model object and updates the view whenever data changes. It keeps view and model separate.

Step 1 - Create Model - Student.java
Step 2 - Create View - StudentView.java
Step 3 - Create Controller - StudentController.java
Step 4 - Use the StudentController methods to demonstrate MVC design pattern usage.

 */
public class MVCPatternDemo {
    public static void main(String[] args) {

        //fetch student record based on his roll no from the database
        Student model = retriveStudentFromDatabase();

        //Create a view : to write student details on console
        StudentView view = new StudentView(model);

        StudentController controller = new StudentController(model, view);

        controller.printView();

        //update model data
        controller.setStudentName("John");

        controller.printView();
    }

    private static Student retriveStudentFromDatabase() {
        Student student = new Student();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }
}