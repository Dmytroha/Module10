package org.example.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
public class EventLogRecordDto {
    @JsonProperty("Received")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss.SSS")
    private Date received;
    @JsonProperty("ExchTime")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss.SSS")
    private Date exchTime;
    @JsonProperty("OrderId")
    private long orderId;
    @JsonProperty("Price")
    private int price;
    @JsonProperty("Amount")
    private int amount;
    @JsonProperty("AmountRest")
    private int amountRest;
    @JsonProperty("DealId")
    private long dealId;
    @JsonProperty("DealPrice")
    private int dealPrice;
    @JsonProperty("OI")
    private int oi;
    @JsonProperty("Flags")
    private String flags;
    @JsonProperty("EditedBy")
    private String editedBy;

}
