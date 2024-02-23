package org.example;


import java.io.*;
import java.net.URL;

import java.time.LocalTime;
import java.util.*;

import org.apache.log4j.BasicConfigurator;
import org.example.dto.EventLogRecordDto;
import org.example.dto.HeaderDto;

import org.example.jsonfactories.JsonFactory;
import org.example.jsonfactories.OrderLogRecordJsonFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
public class Main {

    private static final JsonFactory orderLogRecordJson = new OrderLogRecordJsonFactoryImpl();
    private static final URL applicationProperties;

    private static String dataLogPath;


    static{
        applicationProperties=Main.class.getClassLoader().getResource("application.properties");
        dataLogPath= Objects.requireNonNull(Main.class.getClassLoader().getResource("DataLog")).getPath();
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws FileNotFoundException {

        BasicConfigurator.configure(); // configure logger
        Properties appProp = new Properties();
        try(FileInputStream fis = new FileInputStream(applicationProperties.getPath())){
            appProp.load(fis);
            LOGGER.info("Data Log path is: {}",dataLogPath);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }


        String logFile= dataLogPath+File.separator+"Sber_OrdLog_ETDonut.txt";
        HeaderDto headerDto = new HeaderDto();
        List<EventLogRecordDto> eventLogRecordDtoList = new ArrayList<>();

        try(BufferedReader logFileBuffReader = new BufferedReader(new FileReader(logFile))){
            // read file hearder (first 3 line)  and fill headerDto with data
            headerDto.setPlaza(logFileBuffReader.readLine());
            headerDto.setGap(logFileBuffReader.readLine());
            headerDto.setFiledNames(logFileBuffReader.readLine());

            LOGGER.info("File header --->: {}",headerDto);

            // save records data from logFile to eventLogRecordDtoList
            ObjectMapper objectMapper = new ObjectMapper();
            String orderLogRecord;
            LOGGER.info("records reading started at: {}", LocalTime.now());
            while(Objects.nonNull(orderLogRecord=logFileBuffReader.readLine())){
                eventLogRecordDtoList.add(
                        objectMapper.readValue(
                                orderLogRecordJson.create(headerDto.getFiledNames(),orderLogRecord),
                                EventLogRecordDto.class
                        )
                );
            }

        } catch(IOException ioe){
            ioe.printStackTrace();
        }
        LOGGER.info("records reading finished at: {}%n", LocalTime.now());

        // check if eventLogRecordDtoList filled properly
        eventLogRecordDtoList.stream().filter(elr->elr.getFlags().contains("Fill"))
                .filter(elr->elr.getOi()>0).limit(20).forEach(elr ->LOGGER.info(elr.toString()));

        // test task1: phone number validation
        (new ValidPhoneNumberConsolePrinter()).validateAndPrint();
        // test task2: TxtToJSON
        (new TxtToJSON()).convert();
        (new wordFrequencyCounter()).calculateAndPrint();

    }
}

