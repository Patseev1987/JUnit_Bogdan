package seminars.sixth;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class AverageSumAndComparatorTest {
    @Test
    public void getAverageSumTest(){
        ListWithNumbers integers = mock(ListWithNumbers.class);

        AverageSumAndComparator averageSumAndComparator = new AverageSumAndComparator(integers,integers);
        when(integers.averageSum()).thenReturn(3.0);
        double result = averageSumAndComparator.getAverageSumForFirstList();
        verify(integers,times(1)).averageSum();
        assertThat(result).isEqualTo(3.0);
    }
}
