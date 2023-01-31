package org.sbitnev.part2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sbitnev.part1.ArraySubstringer;
import org.sbitnev.part2.entity.OneTask;
import org.sbitnev.part2.repository.OneTaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArraySubstringerService {

    private final OneTaskRepository oneTaskRepository;

    public String [] arraySubstringerCalculate(String a1, String a2) {
        String [] initialArray = a1.split(", ");
        String [] array = a2.split(", ");
        log.info("Calculate one task");
        return ArraySubstringer.arraySubstringContains(initialArray, array);
    }

    public void saveOneTask(String initialArray, String array) {
        OneTask oneTask = new OneTask();
        oneTask.setArray1(initialArray);
        oneTask.setArray2(array);
        oneTask.setNumber(1);
        log.info("Save one task");
        oneTaskRepository.save(oneTask);
    }
}
