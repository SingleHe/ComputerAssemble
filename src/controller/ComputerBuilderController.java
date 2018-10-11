package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Build;
import model.Catalogue;

/**
 * Created by SingleHe on 2018/9/27.
 */
public class ComputerBuilderController extends Controller{
    @FXML
    private void viewCatalogue(ActionEvent event) throws Exception{
        ViewLoader.showStage(new Catalogue(),"/view/catalogue.fxml","Catalogue",stage);
    }
    @FXML
    private void viewBuild(ActionEvent event) throws Exception{
        ViewLoader.showStage(new Build(),"/view/build.fxml","Current Build",stage);
    }
    @FXML
    private void quit(){
        System.exit(0);
    }
}
