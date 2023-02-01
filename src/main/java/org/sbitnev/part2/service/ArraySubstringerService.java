package org.sbitnev.part2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.sbitnev.part1.ArraySubstringer;
import org.sbitnev.part2.entity.OneTask;
import org.sbitnev.part2.repository.OneTaskRepository;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArraySubstringerService {
    private final ArraySubstringer arraySubstringer;

    private final OneTaskRepository oneTaskRepository;

    public String [] arraySubstringerCalculate(String a1, String a2) {
        String [] initialArray = a1.split(", ");
        String [] array = a2.split(", ");
        log.info("Calculate one first task");
        return arraySubstringer.arraySubstringContains(initialArray, array);
    }

    public void saveOneTask(String initialArray, String array) {
        if (initialArray != null && array != null) {
            OneTask oneTask = new OneTask();
            oneTask.setArray1(initialArray);
            oneTask.setArray2(array);
            oneTask.setNumber(1);
            log.info("Save one first task");
            oneTaskRepository.save(oneTask);
        }
    }

    public void exportOne(Writer writer) {
        log.info("Finding all first tasks in export method");
        List<OneTask> tasks = oneTaskRepository.findAll();
        try(CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            log.info("Write first task to csv");
            for (OneTask oneTask: tasks) {
                csvPrinter.printRecord(oneTask.getId(), oneTask.getArray1(), oneTask.getArray2(), oneTask.getNumber());
            }
        } catch (IOException e) {
            log.error("Error while writing CSV ", e);
        }
    }

    public List<OneTask> downloadOne() {
        return oneTaskRepository.
                findAll();
    }

    public void importOne(InputStream is, BufferedReader fileReader) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT)) {
            Iterable<CSVRecord> oneTasksRecords = csvParser.getRecords();
            for(CSVRecord csvRecord : oneTasksRecords) {
                OneTask oneTask = new OneTask(
                        Long.parseLong(csvRecord.get("Id")),
                        csvRecord.get("Array1"),
                        csvRecord.get("Array2"),
                        Integer.parseInt("Number"));
            }
        } catch (IOException e) {
            log.error("File for first task not exist or don't read");
        }

    }
}
