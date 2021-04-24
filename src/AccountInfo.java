public class AccountInfo {

    public String email;
    private String password;

    /**
     *
     */
    public AccountInfo() {
    }

    /**
     * @param email
     * @param password
     */
    public AccountInfo(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
