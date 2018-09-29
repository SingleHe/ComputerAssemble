package au.edu.uts.ap.javafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by SingleHe on 2018/9/27.
 */
public class ViewLoader {
    public static <T> void showStage(T model, String fxml, String title, Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Controller.class.getResource(fxml), null, null,
                type -> {
                    try {
                        @SuppressWarnings("unchecked")
                        Controller<T> controller = (Controller<T>)type.newInstance();
                        controller.model = model;
                        controller.stage = stage;
                        return controller;
                    } catch (Exception e) { throw new RuntimeException(e); }
                });
        Parent root = loader.load();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.sizeToScene();
        stage.show();
    }
}
