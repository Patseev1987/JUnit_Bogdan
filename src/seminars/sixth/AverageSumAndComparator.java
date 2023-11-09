package seminars.sixth;

public class AverageSumAndComparator {
    private ListWithNumbers list1;
    private ListWithNumbers list2;

    public AverageSumAndComparator(ListWithNumbers list1, ListWithNumbers list2) {
        this.list1 = list1;
        this.list2 = list2;
    }

    public double getAverageSumForFirstList(){
        return list1.averageSum();
    }
    public double getAverageSumForSecondList(){
        return list2.averageSum();
    }

     public void compareTwoLists (){
     if (getAverageSumForFirstList()>getAverageSumForSecondList()){
         System.out.print("Первый список имеет большее среднее значение");
     }else if (getAverageSumForFirstList()<getAverageSumForSecondList()){
         System.out.print("Второй список имеет большее среднее значение");
     }else{
         System.out.print("Средние значения равны");
     }
 }

}
