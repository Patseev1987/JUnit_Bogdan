package seminars.sixth;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class AverageSumAndComparatorTest {

    ListWithNumbers<Integer> list1;
    ListWithNumbers<Double> list2;

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();


    @BeforeEach
    public void init() {
        list1 = new ListWithNumbers<>(1, 2, 3, 4, 5);
    }

    @Test
    public void getAverageSum() {
        assertThat(list1.averageSum()).isNotNull().isEqualTo(3.0);
    }


    @Test
    public void getAverageSumForFirstListTest() {
        ListWithNumbers integers = mock(ListWithNumbers.class);

        AverageSumAndComparator averageSumAndComparator = new AverageSumAndComparator(integers, integers);
        when(integers.averageSum()).thenReturn(3.0);
        double result = averageSumAndComparator.getAverageSumForFirstList();
        verify(integers, times(1)).averageSum();
        assertThat(result).isEqualTo(3.0);
    }


    @Test
    public void getAverageSumForFirstSecondTest() {
        ListWithNumbers integers = mock(ListWithNumbers.class);
        ListWithNumbers doubles = mock(ListWithNumbers.class);

        AverageSumAndComparator averageSumAndComparator = new AverageSumAndComparator(integers, doubles);
        when(doubles.averageSum()).thenReturn(3.0);
        double result = averageSumAndComparator.getAverageSumForSecondList();
        verify(doubles, times(1)).averageSum();
        assertThat(result).isEqualTo(3.0);
    }

    @BeforeEach
    public void initStringWriter() {
        System.setOut(new PrintStream(outputStream));
    }


    @Test
    public void initStringWriterAndLargestFirstList() {
        list1 = new ListWithNumbers<>(3, 3, 3, 3);
        list2 = new ListWithNumbers<>(2.0, 2.0);
        AverageSumAndComparator averageSumAndComparator = new AverageSumAndComparator(list1, list2);
        averageSumAndComparator.compareTwoLists();
        String answer = "Первый список имеет большее среднее значение";
        String result = outputStream.toString();
        assertThat(result).isEqualTo(answer);
    }


    @Test
    public void compareToListsTestFirstListSmaller() {
        list1 = new ListWithNumbers<>(2, 2, 2);
        list2 = new ListWithNumbers<>(3.0, 3.0, 3.0);
        AverageSumAndComparator averageSumAndComparator = new AverageSumAndComparator(list1, list2);
        averageSumAndComparator.compareTwoLists();
        String answer = "Второй список имеет большее среднее значение";
        String result = outputStream.toString();
        assertThat(result).isEqualTo(answer);
    }


    @Test
    public void compareToListsTestListsSame() {
        list1 = new ListWithNumbers<>(1, 1, 1);
        list2 = new ListWithNumbers<>(1.0, 1.0, 1.0);
        AverageSumAndComparator averageSumAndComparator = new AverageSumAndComparator(list1, list2);
        averageSumAndComparator.compareTwoLists();
        String answer = "Средние значения равны";
        String result = outputStream.toString();
        assertThat(result).isEqualTo(answer);
    }


}
