package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Build;
import model.Catalogue;
import model.Part;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 *
 */
public class BuildController extends Controller implements Initializable{
    private List<Part> parts = new ArrayList<>();
    private ObservableList<Part> data;
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<Part,String> type;
    @FXML
    private TableColumn<Part,String> name;
    @FXML
    private TableColumn<Part,Double> price;
    @FXML
    private Label labTotal;
    @FXML
    private void checkBuild(ActionEvent event){
        Map<String,Integer> res = Build.getSelectToBuild();
        List<Part> total = Catalogue.getPartList();
        List<String> buildTypes = new ArrayList<>();
        for(String key : res.keySet()){
            for(Part p : total){
                if(p.getName().equals(key)){
                    buildTypes.add(p.getType());
                }
            }
        }
        if(buildTypes == null){

        }
        if(!buildTypes.contains("CPU")){

        }

    }
    @FXML
    private void removeFromBuild(ActionEvent event){
        Part select = (Part) tableView.getSelectionModel().getSelectedItem();
        String selectedName = select.getName();
        parts = getPartListFromMap(Build.getSelectToBuild());
        Iterator<Part> it = parts.iterator();
        while(it.hasNext()){
            Part p = it.next();
            if(p.getName().equals(selectedName)){
                it.remove();
            }
        }

    }
    @FXML
    private void closeBuild(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Build.clear();
        ViewLoader.showStage(new Catalogue(),"/view/catalogue.fxml","Catalogue",stage);
    }
    public void initialize(URL location, ResourceBundle resource){
        this.tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.type.setCellValueFactory(new PropertyValueFactory("type"));
        this.name.setCellValueFactory(new PropertyValueFactory("name"));
        this.price.setCellValueFactory(new PropertyValueFactory("price"));
        Map<String,Integer> res = Build.getSelectToBuild();
        List<Part> total = Catalogue.getPartList();
        for(String key : res.keySet()){
            for(Part p : total){
                if(p.getName().equals(key)){
                    parts.add(p);
                }
            }
        }
        this.data = FXCollections.observableArrayList(parts);
        this.updateTableView(data);
    }
    private void updateTableView(ObservableList data) {
        this.tableView.setItems(data);
    }
    public List<Part> getPartListFromMap(Map<String,Integer> map){
        List<Part> list = new ArrayList<>();
        List<Part> total = Catalogue.getPartList();
        for(String key : map.keySet()){
            for(Part p : total){
                if(p.getName().equals(key)){
                    list.add(p);
                }
            }
        }
        return list;
    }
}
