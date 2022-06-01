package pe.com.bank.bootcoin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerateTrade {

    private String tradingId;
    private String bootcoinId;
}
