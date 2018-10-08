import au.edu.uts.ap.javafx.ViewLoader;
import javafx.application.Application;
import javafx.stage.Stage;
import model.ComputerBuilder;

/**
 * Created by SingleHe on 2018/9/27.
 */
public class ComputerBuilderApplication extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ViewLoader.showStage(new ComputerBuilder(), "/view/computerbuilder.fxml", "Guillermo's Computer Store", stage);
    }
}
