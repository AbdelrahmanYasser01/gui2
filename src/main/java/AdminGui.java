import javafx.application.Application;
import javafx.stage.Stage;

public class AdminGui extends Application {
    public Admin admin = new Admin();


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        admin.getid();

    }
}