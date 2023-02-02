package org.sbitnev.part2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.sbitnev.part2.entity.OneTask;
import org.sbitnev.part2.entity.ThirdTask;
import org.sbitnev.part2.repository.ThirdTaskRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MagicSquareService {

    private final ThirdTaskRepository thirdTaskRepository;
    private static int[][] squares = new int[][]{
            {1, 5, 9, 6, 7, 2, 8, 3, 4},
            {1, 5, 9, 8, 3, 4, 6, 7, 2},
            {1, 6, 8, 9, 2, 4, 5, 7, 3},
            {1, 8, 6, 9, 4, 2, 5, 3, 7},
            {2, 4, 9, 6, 8, 1, 7, 3, 5},
            {2, 6, 7, 9, 1, 5, 4, 8, 3},
            {3, 4, 8, 5, 9, 1, 7, 2, 6},
            {3, 7, 5, 8, 6, 1, 4, 2, 9}
    };

    public  String [] calculateMagicSquare(String one, String two, String three,
                                        String four, String five, String six,
                                        String seven, String eight, String nine) {

        int[][] s = readingDataSquare(one, two, three, four, five, six, seven, eight, nine);


        int [] val = new int[2];
        int cost;
        int k;

        val = formingMagicSquare(s, squares);
        k = val[0];

        cost = val[1];

        String coinString = String.valueOf(cost);
        String kString = Arrays.toString(squares[k]);
        String initialString = one + ", " + two + ", " + three + ", " + four + ", " + five + ", " + six + ", " + seven + ", " + eight + ", " + nine;

        log.info("Calculate result for third task");
        String [] result = new String[] {coinString, kString, initialString};
        return result;
    }

    public void saveThirdTask(String one, String two, String three,
                              String four, String five, String six,
                              String seven, String eight, String nine) {
        if (one != null && two != null  && three != null && four != null && five != null && six != null && seven != null) {
            ThirdTask thirdTask = new ThirdTask();
            String [] resultCalculate = calculateMagicSquare(one, two, three, four, five, six, seven, eight, nine);
            thirdTask.setArray1(resultCalculate[2]);
            thirdTask.setArray2(resultCalculate[1]);
            thirdTask.setCost(Integer.parseInt(resultCalculate[0]));
            thirdTask.setNumber(2);
            log.info("Save third task");
            thirdTaskRepository.save(thirdTask);
        }
    }

    public List<ThirdTask> downloadThird() {
        return thirdTaskRepository.
                findAll();
    }

    public void exportThree(Writer writer) {
        log.info("Finding all third tasks in export method");
        List<ThirdTask> tasks = thirdTaskRepository.findAll();
        try(CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            log.info("Write third task to csv");
            for (ThirdTask thirdTask: tasks) {
                csvPrinter.printRecord(thirdTask.getId(), thirdTask.getArray1(), thirdTask.getArray2(), thirdTask.getCost(), thirdTask.getNumber());
            }
        } catch (IOException e) {
            log.error("Error while writing third CSV ", e);
        }
    }

    private int[] formingMagicSquare(int [][] s, int [][] squares){
        log.info("Forming magic square");
        int min = Integer.MAX_VALUE;
        int[] val = new int[2];
        int k = 0;

        for (int i = 0; i < squares.length; i++) {
            int total = 0;
            for (int j = 0; j < squares[i].length; j++) {
                total += Math.abs(s[j/3][j%3] - squares[i][j]);
            }
            if (total < min) {min = total;k = i;}
        }
        val[0] = k;
        val[1] = min;
        return val;
    }


    private int [] [] readingDataSquare(String one, String two, String three,
                                       String four, String five, String six,
                                       String seven, String eight, String nine) {

        int[][] s = new int[3][3];
        s [0] [0] = Integer.parseInt(one);
        s [0] [1] = Integer.parseInt(two);
        s [0] [2] = Integer.parseInt(three);
        s [1] [0] = Integer.parseInt(four);
        s [1] [1] = Integer.parseInt(five);
        s [1] [2] = Integer.parseInt(six);
        s [2] [0] = Integer.parseInt(seven);
        s [2] [1] = Integer.parseInt(eight);
        s [2] [2] = Integer.parseInt(nine);


        return s;
    }
}
