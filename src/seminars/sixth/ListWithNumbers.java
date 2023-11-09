package seminars.sixth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListWithNumbers<T extends Number> {

   private List<T> list  ;

    public ListWithNumbers(T... numbers) {
        list=new ArrayList<>(Arrays.asList(numbers));
    }

    public double averageSum(){
     double result = 0;
     for (T number:list) {
         result += number.doubleValue();
     }
     return result/list.size();
 }




}
