package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import model.Catalogue;
import model.Part;

import java.awt.*;

/**
 * Created by SingleHe on 2018/9/27.
 */
public class AddToCatalogueController extends Controller{
    @FXML
    private TextField addTypeField;
    @FXML
    private TextField addNameField;
    @FXML
    private TextField addPriceField;
    @FXML
    private void addToCatalogue() throws Exception{
        String type = addTypeField.getText();
        String name = addNameField.getText();
        String priceString = addPriceField.getText();
        Double price =0.00;
        try{
            price = Double.valueOf(priceString);
        }catch (NumberFormatException f){
            ViewLoader.showStage(new Catalogue(),"/view/error.fxml","Incorrect Input",stage);
        }
        Part newPart = new Part(type,name,price);
        Catalogue.add(newPart);
        ViewLoader.showStage(new Catalogue(),"/view/catalogue.fxml","Catalogue",stage);
    }
}
