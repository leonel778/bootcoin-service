package pe.com.bank.bootcoin.api;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pe.com.bank.bootcoin.document.BootcoinDocument;
import pe.com.bank.bootcoin.dto.GenerateTrade;
import pe.com.bank.bootcoin.dto.TradingDto;
import pe.com.bank.bootcoin.service.BootcoinService;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/v1")
public class BootcoinApi {

    BootcoinService bootcoinService;

    @GetMapping("/getBootCoin")
    public Mono<BootcoinDocument> getBootCoinById(@RequestParam(value = "id") String bootcoinId) {
        return bootcoinService.findBootCoinById(bootcoinId);
    }

    @PostMapping("/acceptTrade")
    public Mono<GenerateTrade> acceptTrading(@RequestBody GenerateTrade generateTrade){
        return bootcoinService.createTrading(generateTrade);
    }



}
