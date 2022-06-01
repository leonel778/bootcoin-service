package pe.com.bank.bootcoin.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "bootcoin")
public class BootcoinDocument {

    @Id
    private String bootcoinId;
    private String documentNumber;
    private String documentType;
    private int phoneNumber;
    private String email;
    private Double amount;
}
