package Lab1.Employees;

/**
 * Created by petri on 10/16/2017.
 */
public class Development extends Employee {
    protected String idea;

    public Development(String idea){
        this.category = "Development";
        this.idea = idea;
    }
    @Override
    public void information() {
        System.out.println("Name: " + firstName + " " + lastName + ", address: " + address  + ", phone number: " + phoneNo
                + ", e-mail address: "+ eMail + ", salary: " + salary + ", category: " + category + ", idea: " + idea);
    }
}
