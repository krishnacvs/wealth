package com.cgi.wealth.lib.multithreading.bulkinsert;

import com.cgi.wealth.lib.multithreading.entity.AppUser;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.jeasy.random.EasyRandom;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class BulkFileWriter {

    public BulkFileWriter() {
    }

    public static void main(String[] args) {
        BulkFileWriter bulkFileWriter = new BulkFileWriter();
        bulkFileWriter.appUserGenerator(10);
    }

    private void appUserGenerator(int count) {
        String fileName;
        for (int i = 0; i < count; i++) {
            EasyRandom easyRandom = new EasyRandom();
            List<AppUser> appUserList = easyRandom.objects(AppUser.class,1000).collect(Collectors.toList());
            fileName = String.format("c:\\temp\\user-%s.csv",i);
            try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
                StatefulBeanToCsv<AppUser> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                        .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                        .build();
                beanToCsv.write(appUserList);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (CsvRequiredFieldEmptyException e) {
                throw new RuntimeException(e);
            } catch (CsvDataTypeMismatchException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
