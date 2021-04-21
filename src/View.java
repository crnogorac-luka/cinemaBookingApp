public class View {

    private LoginPage loginPage;
    private HomeUserPage homeUserPage;
    private HomeCashierPage homeCashierPage;
    private SeatsPage seatsPage;


    public View() {

            loginPage = new LoginPage();
/*
            VBox loginPageBox = new LoginBox();
            homeUserPage = new Scene(loginPageBox);

            VBox loginPageBox = new LoginBox();
            seatsPage = new Scene(loginPageBox);

            VBox loginPageBox = new LoginBox();
            homeCashierPage = new Scene(loginPageBox);

            VBox homeUserPageBox = FXMLLoader.<VBox>load(getClass().getResource("/javafx_files/homeUser.fxml"));
            homeUserPage = new HomeUserScene(homeUserPageBox);

            VBox seatsPageBox = FXMLLoader.<VBox>load(getClass().getResource("/javafx_files/seats.fxml"));
            seatsPage = new SeatsScene(seatsPageBox);

            VBox homeCashierPageBox = FXMLLoader.<VBox>load(getClass().getResource("/javafx_files/homeCashier.fxml"));
            homeCashierPage = new HomeUserScene(homeCashierPageBox);


 */


    }


    public LoginPage getLoginPage() {
        return loginPage;
    }

    public HomeUserPage getHomeUserPage() {
        return homeUserPage;
    }

    public HomeCashierPage getHomeCashierPage() {
        return homeCashierPage;
    }

    public SeatsPage getSeatsPage() {
        return seatsPage;
    }
}
