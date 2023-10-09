package com.mkh.opencsv;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class AnalyticsCsvToBeans {

    public static void main(String[] args) throws IOException, CsvValidationException, CsvRequiredFieldEmptyException {
        Reader reader = new BufferedReader(new FileReader("src/main/resources/analytics.csv"));

        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(csvParser).build();

        reader.mark(100);
        String[] header = csvReader.readNext();
        System.out.println("print header: "+header[7]);
        reader.reset();

        HeaderColumnNameMappingStrategy<AnalyticsCsvRecursion> strategy = new HeaderColumnNameMappingStrategy<AnalyticsCsvRecursion>();
        strategy.setType(AnalyticsCsvRecursion.class);
        strategy.generateHeader(new AnalyticsCsvRecursion());

        /*CsvToBean<AnalyticsCsv> csvToBean = new CsvToBeanBuilder(reader)
                .withType(AnalyticsCsv.class)
                .withSeparator(';')
                .withSkipLines(1)
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreEmptyLine(true)
                .build();

        List<AnalyticsCsv> results = csvToBean.parse();*/
        //results.stream().map(analyticsCsv -> analyticsCsv.getFrom()).forEach(System.out::println);

        List<AnalyticsCsvRecursion> analyticsCsvRecursionList = new CsvToBeanBuilder<AnalyticsCsvRecursion>(reader)
                .withType(AnalyticsCsvRecursion.class)
                .withSeparator(';')
                //.withSkipLines(1)
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreEmptyLine(true)
                .build().parse();


        analyticsCsvRecursionList.stream().map(analyticsCsvRecursion -> analyticsCsvRecursion.getDimensions().getConsumer()).forEach(System.out::println);
    }
}
