public interface Person {

    // ACCESSORS

    /**
     * @return personID
     */
    public int getPersonID();

    /**
     * @return firstName
     */
    public String getFirstName();

    /**
     * @return lastName
     */
    public String getLastName();

    /**
     * @return phone
     */
    public String getPhone();

    /**
     * @return email
     */
    public String getEmail();

    /**
     * @return cashierID
     */
    public int getCashierID();

    /**
     * @return name
     */
    public String getName();

    /**
     * @return salary
     */
    public double getSalary();

    // MUTATORS

    /**
     * @param personID sets new personID
     */
    public void setPersonID(int personID);

    /**
     * @param firstName sets new firstName
     */
    public void setFirstName(String firstName);

    /**
     * @param lastName sets new lastName
     */
    public void setLastName(String lastName);

    /**
     * @param phone sets new phone
     */
    public void setPhone(String phone);

    /**
     * @param email sets new email
     */
    public void setEmail(String email);

    /**
     * @param cashierID sets new cashierID
     */
    public void setCashierID(int cashierID);


    /**
     * @param name sets new name
     */
    public void setName(String name);

    /**
     * @param salary sets new salary
     */
    public void setSalary(double salary);


}
