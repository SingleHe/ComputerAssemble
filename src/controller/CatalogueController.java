package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Part;

import java.util.List;

/**
 * Created by SingleHe on 2018/9/27.
 */
public class CatalogueController extends Controller{
    private List<Part> parts;
    private ObservableList<Part> data;
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<Part,String> cataType;
    @FXML
    private TableColumn<Part,String> cataName;
    @FXML
    private TableColumn<Part,Double> cataPrice;
    public CatalogueController(){}
    @FXML
    private void btnAddSelected(Event event){

    }
    @FXML
    private void btnAddNew(Event event){

    }
    @FXML
    private void btnRemoveSelected(Event event){

    }
    @FXML
    private void btnClose(Event event){

    }
    private void updateTableView(ObservableList data) {
        this.tableView.setItems(data);
    }
}
