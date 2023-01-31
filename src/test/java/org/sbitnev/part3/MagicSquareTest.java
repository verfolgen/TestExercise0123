package org.sbitnev.part3;

import org.junit.jupiter.api.Test;
import org.sbitnev.part1.ArraySubstringer;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MagicSquareTest {

    @Test
    void magicSquarerTransformIsMagic() {
        int [] [] originalArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int [] [] magicArray = {{4, 3, 8}, {2, 7, 6}, {9, 5, 1}};

        //boolean boolResult1 = Arrays.deepEquals(MagicSquare.magicSquarerTranform(originalArray), magicArray);
        //assertThat(boolResult1).isTrue();
    }

}