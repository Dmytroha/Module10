package org.example.jsonfactories;

import org.example.jsonfactories.JsonFactory;

public class OrderLogRecordJsonFactoryImpl implements JsonFactory {
    @Override
    public String create(String fieldNames, String fieldValues) {
        String[] fieldNamesArray = fieldNames.split(";");
        String[] orderLogRecordValuesArray = fieldValues.split(";");
        StringBuilder resultJsonSb = new StringBuilder();
        int i=0;
        resultJsonSb.append("{");
        for (String fieldName: fieldNamesArray) {
            if(i < orderLogRecordValuesArray.length) {
                resultJsonSb.append('"').append(fieldName).append('"').append(':').append('"')
                        .append(orderLogRecordValuesArray[i].trim()).append('"').append(',');
            }
            i++;
        }
        resultJsonSb.deleteCharAt(resultJsonSb.length()-1);
        resultJsonSb.append("}");

        return resultJsonSb.toString();

    }
}
