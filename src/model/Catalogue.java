package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SingleHe on 2018/9/27.
 */
public class Catalogue {
   private static  List<Part> partList;
   public Catalogue(){

   }
   private static void init(){
      List<Part> partList = new ArrayList<>();
      Part storage = new Part("STORAGE","evo 860",155.00);
      Part keyboard = new Part("KEYBOARD","evo 860",239.00);
      Part cpu = new Part("CPU","evo 860",365.00);
      Part motherboard = new Part("MOTHERBOARD","evo 860",159.00);
      Part case1 = new Part("CASE","evo 860",39.00);
      Part memory = new Part("MEMORY","evo 860",299.00);
      partList.add(storage);
      partList.add(keyboard);
      partList.add(cpu);
      partList.add(motherboard);
      partList.add(case1);
      partList.add(memory);
   }

   public static List<Part> getPartList() {
      return partList;
   }
   public static void  add(Part part){
      partList.add(part);
   }
   public static List<Part> searchPartList(String type){
      List<Part> result = new ArrayList<>();
      for(Part p : partList){
         if(type.equals(p.getType())){
            result.add(p);
         }
      }
      return result;
   }
}
