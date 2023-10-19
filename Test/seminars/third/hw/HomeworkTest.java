package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeworkTest {
    MainHW mainHW;
    @BeforeEach
    void init(){
        mainHW = new MainHW();
    }
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    public void checkEvenNumbers (int input){
       assertFalse(mainHW.evenOddNumber(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    public void checkOddNumbers (int input){
        assertTrue(mainHW.evenOddNumber(input));
    }

    @ParameterizedTest
    @ValueSource (ints = {2,10,20})
    void checkNumberBeforeInterval(int input){
        assertFalse( mainHW.numberInInterval(input));
    }

    @ParameterizedTest
    @ValueSource (ints = {101,200,300})
    void checkNumberAfterInterval(int input){
        assertFalse( mainHW.numberInInterval(input));
    }

    @ParameterizedTest
    @ValueSource (ints = {25,58,100})
    void checkNumberInInterval(int input){
        assertTrue( mainHW.numberInInterval(input));
    }
}
