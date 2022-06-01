package pe.com.bank.bootcoin.service;

import pe.com.bank.bootcoin.document.BootcoinDocument;
import pe.com.bank.bootcoin.dto.GenerateTrade;
import reactor.core.publisher.Mono;

public interface BootcoinService {

    Mono<BootcoinDocument> findBootCoinById(String id);

    Mono<GenerateTrade> createTrading(GenerateTrade generateTrade);

}
