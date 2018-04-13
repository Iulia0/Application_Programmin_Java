package Lab1.Employees;

/**
 * Created by petri on 10/16/2017.
 */
public class testEmployees {
    public static void main(String[] args) {
        Employee[] employee = new Employee[3];
        employee[0] = new Sales(10, 1000);
        employee[1] = new Development("nothing at the moemnt");
        employee[2] = new Manager("Pens", 555);
        for(Employee employees : employee)

        {
            employees.information();
        }
    }
}
