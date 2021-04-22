import javax.sound.midi.ShortMessage;

public class View {

    private LoginPage loginPage;
    private HomeUserPage homeUserPage;
    private HomeCashierPage homeCashierPage;
    private SeatsPage seatsPage;


    public View() {

            loginPage = new LoginPage();
            homeUserPage = new HomeUserPage();
            homeCashierPage = new HomeCashierPage();
            seatsPage = new SeatsPage();

            homeUserPage.setVisible(false);
            homeCashierPage.setVisible(false);
            seatsPage.setVisible(false);
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
