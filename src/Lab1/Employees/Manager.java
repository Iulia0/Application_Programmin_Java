package Lab1.Employees;

/**
 * Created by petri on 10/16/2017.
 */
public class Manager extends Employee {
    protected String itemStock;
    protected double stockNo;

    public Manager(String itemStock, double stockNo){
        this.category = "Manager";
        this.itemStock = itemStock;
        this.stockNo = stockNo;
    }

    @Override
    public void information() {
        System.out.println("Name: " + firstName + " " + lastName + ", address: " + address +  ", phone number: " + phoneNo
                + ", e-mail address: "+ eMail + ", salary: " + salary + ", category: " + category +  ", itemStock: " + itemStock + ", stock number:" +
                " " + stockNo);

    }
}
