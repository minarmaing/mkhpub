package com.mkh.opencsv;

import com.opencsv.CSVIterator;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

public class AnalyticsCsvToBeans {

    public static void main(String[] args) throws IOException, CsvValidationException, CsvRequiredFieldEmptyException {
        Reader reader = new BufferedReader(new FileReader("src/main/resources/analytics.csv"));

        /*CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(csvParser).build();

        reader.mark(100);
        String[] header = csvReader.readNext();
        System.out.println("print header: "+header[7]);
        reader.reset();*/

        /*HeaderColumnNameMappingStrategy<AnalyticsCsvRecursion> strategy = new HeaderColumnNameMappingStrategy<AnalyticsCsvRecursion>();
        strategy.setType(AnalyticsCsvRecursion.class);
        strategy.generateHeader(new AnalyticsCsvRecursion());*/


        CSVReaderHeaderAware csvReaderHeaderAware = new CSVReaderHeaderAware(reader);
        //csvReaderHeaderAware.skip(0);
        Map<String, String> record = csvReaderHeaderAware.readMap();
        //System.out.println(record.keySet().toString().split(";")[6].replace("]",""));
        String type = record.keySet().toString().split(";")[6].replace("]", "");

        reader.reset();

        ColumnPositionMappingStrategy<AnalyticsCsvRecursion> positionMappingStrategy = new ColumnPositionMappingStrategyBuilder<AnalyticsCsvRecursion>().build();
        positionMappingStrategy.setType(AnalyticsCsvRecursion.class);
        //String[] columns = new String[] {"organization","environment","apiproxy","api_product","developer_app","time","sum(message_count)"};
        String[] columns = new String[]{"organization", "environment", "apiproxy", "api_product", "developer_app", "time", type};
        positionMappingStrategy.setColumnMapping(columns);

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
                .withMappingStrategy(positionMappingStrategy)
                .withSeparator(';')
                //.withSkipLines(1)
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreEmptyLine(true)
                .build().parse();


        analyticsCsvRecursionList.stream().map(analyticsCsvRecursion -> analyticsCsvRecursion.getMetrics().getCount()).forEach(System.out::println);

        /*List<AnalyticsCsvRecursion> analyticsCsvRecursionList = new CsvToBeanBuilder<AnalyticsCsvRecursion>(reader)
                .withType(AnalyticsCsvRecursion.class)
                .withSeparator(';')
                //.withSkipLines(1)
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreEmptyLine(true)
                .build().parse();


        analyticsCsvRecursionList.stream().map(analyticsCsvRecursion -> analyticsCsvRecursion.getDimensions().getDeveloper_app()).forEach(System.out::println);*/

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


        /*CsvToBean csv = new CsvToBean();
        List list = csv.parse(positionMappingStrategy, reader);*/ //issue with parse method

        /*CsvToBean csvToBean2 = new CsvToBeanBuilder(reader)
                .withMappingStrategy(positionMappingStrategy)
                //.withType(AnalyticsCsvRecursion.class)
                .withSeparator(';')
                //.withSkipLines(0)
                //.withIgnoreLeadingWhiteSpace(true)
                //.withIgnoreEmptyLine(true)
                .build();
        List<AnalyticsCsvRecursion> results2 = csvToBean2.parse();
        results2.stream().map(analyticsCsvRecursion -> analyticsCsvRecursion.getDimensions().getDeveloper_app()).forEach(System.out::println);*/




       /* CSVIterator iterator = new CSVIterator(csvReaderHeaderAware);
        for (CSVIterator it = iterator; it.hasNext(); ) {
            String[] nextLine = it.next();
            // nextLine[] is an array of values from the line
            System.out.println(nextLine[0] + nextLine[1] + "etc...");
        }*/


    }
}
