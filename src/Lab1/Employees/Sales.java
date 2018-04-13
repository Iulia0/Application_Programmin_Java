package Lab1.Employees;

/**
 * Created by petri on 10/16/2017.
 */
public class Sales extends Employee {
    protected int noOfSales;
    protected double valueSales;

    public Sales(int noOfSales, double valueSales){
        this.category = "Sales";
        this.noOfSales = noOfSales;
        this.valueSales = valueSales;

    }

    @Override
    public void information() {
        System.out.println("Name: " + firstName + " " + lastName + ", address: " + address + ", phone number: " + phoneNo
        + ", e-mail address: "+ eMail + ", salary: " + salary + ", category: " + category +  ", number of sales: " + noOfSales + ", total value of sales: "
                + valueSales);
    }
}
