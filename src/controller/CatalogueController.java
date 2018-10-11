package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Build;
import model.Catalogue;
import model.ComputerBuilder;
import model.Part;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by SingleHe on 2018/9/27.
 */
public class CatalogueController extends Controller implements Initializable{
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
    @FXML
    private TextField typeField;
    @FXML
    private TextField priceFieldFrom;
    @FXML
    private TextField priceFieldTo;
    public CatalogueController(){}

    /**
     * 将选中的原件保存起来，并进行计数
     * @param event
     */
    @FXML
    private void btnAddSelected(ActionEvent event) throws IOException {
        Part select = (Part) tableView.getSelectionModel().getSelectedItem();
        if(select == null){
            ViewLoader.showStage(new Build(), "/view/build.fxml", "Current Build", stage);
        }else {
            String selectedName = select.getName();
            if (Build.getSelectToBuild().containsKey(selectedName)) {
                Integer count = Build.getSelectToBuild().get(selectedName);
                Build.getSelectToBuild().put(selectedName, Integer.valueOf(count.intValue() + 1));
            } else {
                Build.getSelectToBuild().put(selectedName, Integer.valueOf(1));
            }
            ViewLoader.showStage(new Build(), "/view/build.fxml", "Current Build", stage);
        }
    }
    @FXML
    private void btnAddNew(ActionEvent event) throws IOException {
        ViewLoader.showStage(new Part(),"/view/addtocatalogue.fxml","Add New Part to Catalogue",stage);
    }
    @FXML
    private void btnRemoveSelected(ActionEvent event){
        Part select = (Part) tableView.getSelectionModel().getSelectedItem();
        String selectedName = select.getName();
        Iterator<Part> it = Catalogue.getPartList().iterator();
        while(it.hasNext()){
            Part p = it.next();
            if(p.getName().equals(selectedName)){
                it.remove();
            }
        }
    }
    @FXML
    private void btnClose(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
        ViewLoader.showStage(new ComputerBuilder(),"/view/computerbuilder","Guillermo's Computer Store",stage);
        //System.exit(0);
    }

    /**
     * 根据配件的类别或价钱进行查询
     * @param event
     */
    @FXML
    public void findByTypeOrPrice(ActionEvent event){
        String type = this.typeField.getText().trim();
        String priceFrom = this.priceFieldFrom.getText().trim();
        String priceTo = this.priceFieldTo.getText().trim();
        Double from = 0.00;
        Double to = 0.00;
        if(type == null || "".equals(type)){
            type = null;
        }
        if(priceFrom != null && "".equals(priceFrom)){
            from = Double.valueOf(priceFrom);
        }else{
            priceFrom = null;
        }
        if(priceTo !=null && "".equals(priceTo)){
            to = Double.valueOf(priceTo);
        }else{
            priceTo = null;
        }
        List<Part> total = Catalogue.getPartList();
        if(type != null && priceFrom != null && priceTo != null){
            for(Part p : total){
                if(type.equals(p.getType()) && from.compareTo(p.getPrice()) <= 0 && to.compareTo(p.getPrice()) >=0 ){
                    parts.add(p);
                }
            }
        }else if(type != null && priceFrom != null && priceTo == null){
            for(Part p : total){
                if(type.equals(p.getType()) && from.compareTo(p.getPrice()) <= 0 ){
                    parts.add(p);
                }
            }
        }else if(type != null && priceFrom == null && priceTo != null){
            for(Part p : total){
                if(type.equals(p.getType()) && to.compareTo(p.getPrice()) >= 0 ){
                    parts.add(p);
                }
            }
        }else if(type == null && priceFrom != null && priceTo != null){
            for(Part p : total){
                if(from.compareTo(p.getPrice()) <= 0 && to.compareTo(p.getPrice()) >= 0 ){
                    parts.add(p);
                }
            }
        }else if(type == null && priceFrom != null && priceTo == null){
            for(Part p : total){
                if(from.compareTo(p.getPrice()) <= 0 ){
                    parts.add(p);
                }
            }
        }else{
            for(Part p : total){
                if(to.compareTo(p.getPrice()) >= 0 ){
                    parts.add(p);
                }
            }
        }
        filter(parts);
    }
    public void initialize(URL location, ResourceBundle resource){
        this.tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.cataType.setCellValueFactory(new PropertyValueFactory("type"));
        this.cataName.setCellValueFactory(new PropertyValueFactory("name"));
        this.cataPrice.setCellValueFactory(new PropertyValueFactory("price"));
        parts = Catalogue.getPartList();
        if(parts == null){
            System.out.println("fuck, CatalogueController中的catalogue为空！");
        }else{
            for(Part p : parts){
                System.out.println(p.getType());
            }
        }
        this.data = FXCollections.observableArrayList(parts);
        this.updateTableView(data);
    }
    private void updateTableView(ObservableList data) {
        this.tableView.setItems(data);
    }
    private void filter(List<Part> filterdList){
        this.tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.cataType.setCellValueFactory(new PropertyValueFactory("type"));
        this.cataName.setCellValueFactory(new PropertyValueFactory("name"));
        this.cataPrice.setCellValueFactory(new PropertyValueFactory("price"));
        this.data = FXCollections.observableArrayList(filterdList);
        updateTableView(data);
    }
}
