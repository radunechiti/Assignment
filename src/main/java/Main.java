import Controller.MainController;
import View.AdminView;
import View.CasierView;
import View.LoginView;



public class Main {

    public static void main(String[] args){
        LoginView loginView = new LoginView();
        AdminView adminView = new AdminView();
        CasierView casierView = new CasierView();
        MainController mainController = new MainController(loginView, adminView, casierView);
    }
}
