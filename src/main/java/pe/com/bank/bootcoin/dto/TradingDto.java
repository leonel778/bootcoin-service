package pe.com.bank.bootcoin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradingDto {

    private String tradingId;
    private int amountChange;
    private String paymentType;
    private String bootcoindId;
    private String state;
}