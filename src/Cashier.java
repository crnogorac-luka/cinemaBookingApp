/**
 * A class that represents data about cashier
 *
 * @author Igor
 */
public class Cashier {

    public int cashierID;
    public String name;
    public double salary;
    public String email;

    /**
     * @param cashierID
     * @param name
     * @param salary
     * @param email
     */
    public Cashier(int cashierID, String name, double salary, String email) {
        this.cashierID = cashierID;
        this.name = name;
        this.salary = salary;
        this.email = email;
    }

    // ACCESSORS

    /**
     * @return cashierID
     */
    public int getCashierID() {
        return cashierID;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    // MUTATORS

    /**
     * @param cashierID sets new cashierID
     */
    public void setCashierID(int cashierID) {
        this.cashierID = cashierID;
    }


    /**
     * @param name sets new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param salary sets new salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * @param email sets new email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
