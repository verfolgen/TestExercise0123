package org.sbitnev.part1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class ArraySubstringer {
    public static String [] arraySubstringContains(String [] a1, String [] a2) {
        List<String> arrayList = new ArrayList<>();
        for(int i = 0; i < a1.length; i ++) {
            for(int j = 0; j < a2.length; j++) {
                if (Pattern.compile(".*" + a1[i] + ".*").matcher(a2[j]).find() && !arrayList.contains(a1[i])) {
                    arrayList.add(a1[i]);
                }
            }
        }
        return arrayList
                .stream()
                .sorted(Comparator.naturalOrder())
                .toArray(String[] :: new);
    }
}
