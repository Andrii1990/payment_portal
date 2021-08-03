package com.test.payment_portal.entity;

import com.test.payment_portal.enums.AccountType;
import com.test.payment_portal.enums.PSQLEnumType;
import lombok.*;
import org.apache.tomcat.util.json.JSONParser;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
@TypeDef(name = "pgsql_enum", typeClass = PSQLEnumType.class)
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer accountId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Clients clientId;

    @Column(name = "account_num")
    private String accountNum;

    @Enumerated(EnumType.STRING)
    @Type(type = "pgsql_enum")
    @Column(name = "account_type", columnDefinition = "account_type")
    private AccountType type;

    @Column
    private BigDecimal balance;


}
