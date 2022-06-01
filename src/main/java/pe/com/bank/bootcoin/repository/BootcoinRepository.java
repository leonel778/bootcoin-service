package pe.com.bank.bootcoin.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pe.com.bank.bootcoin.document.BootcoinDocument;

@Repository
public interface BootcoinRepository extends ReactiveMongoRepository<BootcoinDocument,String> {

}
