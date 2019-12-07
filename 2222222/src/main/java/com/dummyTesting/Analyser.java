package com.dummyTesting;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Analyser {
    public String SAMPLE_CSV_FILE_PATH = "";

    public int csvFileRecording(String SAMPLE_CSV_FILE_PATH, String POJO) throws CSVFileException, IOException, ClassNotFoundException {
        System.out.println(SAMPLE_CSV_FILE_PATH);
        int noOfRecord = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            List<StateCensusData> list = new ArrayList();
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Class.forName(POJO))
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator csvUserIterator = csvToBean.iterator();
            while (csvUserIterator.hasNext()) {
                StateCensusData data = (StateCensusData) csvUserIterator.next();
                list.add(data);
                noOfRecord++;
            }
        } catch (NoSuchFileException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            throw new CSVFileException("Please enter proper fileName Or Delimiter Problem Or Header Problem ", CSVFileException.ExceptionType.RUNTIME_ERROR);
        }
        return noOfRecord;
    }
}


