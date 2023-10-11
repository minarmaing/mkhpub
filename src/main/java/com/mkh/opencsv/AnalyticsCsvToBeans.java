package com.mkh.opencsv;

import com.opencsv.bean.*;
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

        /*CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(csvParser).build();

        reader.mark(100);
        String[] header = csvReader.readNext();
        System.out.println("print header: "+header[7]);
        reader.reset();*/

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

        /*List<AnalyticsCsvRecursion> analyticsCsvRecursionList = new CsvToBeanBuilder<AnalyticsCsvRecursion>(reader)
                .withType(AnalyticsCsvRecursion.class)
                .withSeparator(';')
                //.withSkipLines(1)
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreEmptyLine(true)
                .build().parse();


        analyticsCsvRecursionList.stream().map(analyticsCsvRecursion -> analyticsCsvRecursion.getDimensions().getConsumer()).forEach(System.out::println);*/


        /*MappingStrategy<AnalyticsCsvRecursion> mappingStrategy = new FuzzyMappingStrategyBuilder<AnalyticsCsvRecursion>().build();
        strategy.setType(AnalyticsCsvRecursion.class);

        CsvToBean csvToBean2 = new CsvToBeanBuilder(reader)
                .withMappingStrategy(mappingStrategy)
                //.withType(AnalyticsCsvRecursion.class)
                .withSeparator(';')
                //.withSkipLines(1)
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreEmptyLine(true)
                .build();
        List<AnalyticsCsvRecursion> results2 = csvToBean2.parse();

        results2.stream().map(analyticsCsvRecursion -> analyticsCsvRecursion.getMetrics().getCount()).forEach(System.out::println);*/


        ColumnPositionMappingStrategy<AnalyticsCsvRecursion> strat = new ColumnPositionMappingStrategyBuilder<AnalyticsCsvRecursion>().build();
        strat.setType(AnalyticsCsvRecursion.class);
        String[] columns = new String[] {"organization","environment","product","consumer","proxy","from","to","sum(message_count)"}; // the fields to bind to in your bean
        strat.setColumnMapping(columns);

        /*CsvToBean csv = new CsvToBean();
        List list = csv.parse(strat, reader);*/

        CsvToBean csvToBean2 = new CsvToBeanBuilder(reader)
                .withMappingStrategy(strat)
                //.withType(AnalyticsCsvRecursion.class)
                .withSeparator(';')
                //.withSkipLines(1)
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreEmptyLine(true)
                .build();
        List<AnalyticsCsvRecursion> results2 = csvToBean2.parse();
        results2.stream().map(analyticsCsvRecursion -> analyticsCsvRecursion.getMetrics().getCount()).forEach(System.out::println);

    }
}
