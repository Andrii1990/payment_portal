package com.test.payment_portal.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.payment_portal.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountsDto {



    @JsonProperty("account_num")
    @NotBlank
    @Size(max = 50)
    private String number;

    @JsonProperty("account_type")
    @NotNull
    private AccountType type;

    @Digits(integer = 14, fraction = 2)
    private BigDecimal balance;
}
