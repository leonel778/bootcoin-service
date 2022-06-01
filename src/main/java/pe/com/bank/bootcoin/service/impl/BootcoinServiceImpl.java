package pe.com.bank.bootcoin.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import pe.com.bank.bootcoin.document.BootcoinDocument;
import pe.com.bank.bootcoin.dto.BootCoinTrade;
import pe.com.bank.bootcoin.dto.GenerateTrade;
import pe.com.bank.bootcoin.dto.TradingDto;
import pe.com.bank.bootcoin.repository.BootcoinRepository;
import pe.com.bank.bootcoin.service.BootcoinService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@AllArgsConstructor
public class BootcoinServiceImpl implements BootcoinService {

    BootcoinRepository bootcoinRepository;

    StreamBridge streamBridge;

    public Mono<BootcoinDocument> findBootCoinById(String id) {
        return bootcoinRepository.findById(id);
    }


    public Mono<GenerateTrade> createTrading(GenerateTrade generateTrade) {
        streamBridge.send("bootcoin-trading-out-0", generateTrade);
        return null;
    }


    @Bean
    public Function<Flux<BootCoinTrade>, Mono<Void>> tradingUpdBootcoin() {
        return flux -> flux.flatMap(this::updateBootCoinAmount).then();
    }

    public Mono<BootcoinDocument> updateBootCoinAmount(BootCoinTrade bootCoinTrade) {
        BootcoinDocument boot = new BootcoinDocument();
        boot.setAmount(bootCoinTrade.getAmount());
        return updateBootCoin(boot, bootCoinTrade.getBootcoidId());
    }

    public Mono<BootcoinDocument> updateBootCoin(BootcoinDocument bootcoinDocument, String id) {
        return bootcoinRepository.findById(id).flatMap(boot -> {
            boot.setAmount(bootcoinDocument.getAmount() != 0 ? bootcoinDocument.getAmount() : boot.getAmount());
            boot.setDocumentNumber(bootcoinDocument.getDocumentNumber() != null ? bootcoinDocument.getDocumentNumber() : boot.getDocumentNumber());
            boot.setEmail(bootcoinDocument.getEmail() != null ? bootcoinDocument.getEmail() : boot.getEmail());
            boot.setPhoneNumber(bootcoinDocument.getPhoneNumber() != 0 ? bootcoinDocument.getPhoneNumber() : boot.getPhoneNumber());
            boot.setDocumentType(bootcoinDocument.getDocumentType() != null ? bootcoinDocument.getDocumentType() : boot.getDocumentType());
            return bootcoinRepository.save(boot);
        });
    }

}
