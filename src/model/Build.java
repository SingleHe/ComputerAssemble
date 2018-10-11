package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SingleHe on 2018/9/27.
 */
public class Build {
    //存放已选择的配件
    private static Map<String,Integer> selectToBuild = new HashMap<>();
    private static List<String> complete;
    private String type;
    private String name;
    private Double price;
    private Double cost;
    public Build(){
        complete = new ArrayList<>();
        complete.add("CPU");
        complete.add("motherboard");
        complete.add("RAM");
        complete.add("CASE");
        complete.add("storage");
    }

    public Build(String type, String name, Double price, Double cost) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public static List<String> getComplete() {
        return complete;
    }

    public static Map<String, Integer> getSelectToBuild() {
        return selectToBuild;
    }
    public static void clear(){
        selectToBuild = null;
    }

}
