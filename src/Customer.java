public class Customer {
    public int personID;
    public String firstName;
    public String lastName;
    public String phone;
    public String email;


    public Customer() {
        this.personID = -1;
        this.firstName = "";
        this.lastName = "";
        this.phone = "";
        this.email = "";
    }

    /**
     * @param personID
     * @param firstName
     * @param lastName
     * @param phone
     * @param email
     */
    // PARAMETERIZED CONSTRUCTOR
    public Customer(int personID, String firstName, String lastName, String phone, String email) {
        this.personID = personID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }


    // ACCESSORS

    /**
     * @return personID
     */
    public int getPersonID() {
        return personID;
    }

    /**
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    // MUTATORS

    /**
     * @param personID sets new personID
     */
    public void setPersonID(int personID) {
        this.personID = personID;
    }

    /**
     * @param firstName sets new firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param lastName sets new lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @param phone sets new phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @param email sets new email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
