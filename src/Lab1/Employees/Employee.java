package Lab1.Employees;


/**
 * Created by petri on 10/16/2017.
 */
abstract public class Employee {
    protected String firstName = "Alex";
    protected String lastName = " Les";
    protected String category = "";
    protected String address =" Some street";
    protected String phoneNo = "07743574107 " ;
    protected String eMail = "da@essex.ac.uk";
    protected double salary = 1200;


    public abstract void information();

}

