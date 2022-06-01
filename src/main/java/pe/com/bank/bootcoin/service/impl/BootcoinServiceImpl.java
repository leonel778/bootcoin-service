package pe.com.bank.bootcoin.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import pe.com.bank.bootcoin.document.BootcoinDocument;
import pe.com.bank.bootcoin.dto.GenerateTrade;
import pe.com.bank.bootcoin.dto.TradingDto;
import pe.com.bank.bootcoin.repository.BootcoinRepository;
import pe.com.bank.bootcoin.service.BootcoinService;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class BootcoinServiceImpl implements BootcoinService {

    BootcoinRepository bootcoinRepository;

    StreamBridge streamBridge;

    public Mono<BootcoinDocument> findBootCoinById(String id) {
        return bootcoinRepository.findById(id);
    }


    public Mono<GenerateTrade> createTrading(GenerateTrade generateTrade){
        streamBridge.send("bootcoin-trading-out-0",generateTrade);
        return null;
    }


}
