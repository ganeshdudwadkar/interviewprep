package designpatterns.mvc;

public class StudentView {
    private Student model;

    public StudentView(Student model) {
        this.model = model;
    }

    public void printStudentDetails() {
        System.out.println("Student: ");
        System.out.println("Name: " + model.getName());
        System.out.println("Roll No: " + model.getRollNo());
    }
}
