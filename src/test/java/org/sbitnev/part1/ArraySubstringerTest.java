package org.sbitnev.part1;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@RequiredArgsConstructor
class ArraySubstringerTest {
    @Test
    void arraySubstringContains() {
        String [] a1 = new String[] {"live", "arp", "strong"};
        String [] a2 = new String[] {"lively", "alive", "harp", "sharp", "armstrong"};
        String [] result1 = new String[] {"arp", "live", "strong"};
        boolean boolResult1 = Arrays.equals(ArraySubstringer.arraySubstringContains(a1, a2), result1);
        assertThat(boolResult1).isTrue();
    }

    @Test
    void arraySubstringNotContains() {
        String [] a3 = new String[] {"tarp", "mice", "bull"};
        String [] a4 = new String[] {"lively", "alive", "harp", "sharp", "armstrong"};
        assertThat(ArraySubstringer.arraySubstringContains(a3, a4)).hasSize(0);
    }
}