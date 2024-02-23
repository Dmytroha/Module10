package org.example.dto;

public class JsonEventLogRecord {
    private JsonEventLogRecord(){}
    private static HeaderDto header;

    public static void setHeader(HeaderDto header) {
        JsonEventLogRecord.header = header;
    }

    public static String eventLogRecordToJson(String eventLogRecord){
       String[] fieldNames = header.getFiledNames().split(";");
       String[] eventLogRecordValues = eventLogRecord.split(";");
       StringBuilder resultSb = new StringBuilder();
       int i=0;
        resultSb.append("{");
        for (String fieldName: fieldNames) {
            if(i < eventLogRecordValues.length) {
                resultSb.append('"').append(fieldName).append('"').append(':').append('"')
                        .append(eventLogRecordValues[i].trim()).append('"').append(',');
            }
            i++;
        }
        resultSb.deleteCharAt(resultSb.length()-1);
        resultSb.append("}");

        return resultSb.toString();
    }
}
