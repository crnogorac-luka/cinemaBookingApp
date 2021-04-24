import javax.sound.midi.ShortMessage;

public class View {

    private LoginPage loginPage;
    private RegisterPage registerPage;
    private HomeUserPage homeUserPage;
    private HomeCashierPage homeCashierPage;
    private SeatsPage seatsPage;


    public View() {

            loginPage = new LoginPage();
            registerPage = new RegisterPage();
            homeUserPage = new HomeUserPage();
            homeCashierPage = new HomeCashierPage();
            seatsPage = new SeatsPage();

    }


    public LoginPage getLoginPage() {
        return loginPage;
    }

    public RegisterPage getRegisterPage() {
        return registerPage;
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
