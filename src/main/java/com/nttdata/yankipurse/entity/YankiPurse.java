package com.nttdata.yankipurse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@Document(collection = "yanki-purse")
public class YankiPurse {

    private String id;
    private Double balance;
    private String numberAccount;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date createdAt;
    private Boolean status;

}
