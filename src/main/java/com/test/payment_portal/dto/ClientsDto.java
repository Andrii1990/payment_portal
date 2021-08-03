package com.test.payment_portal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientsDto {

    @JsonProperty("client_id")
    private Integer clientId;

    @JsonProperty("first_name")
    @NotBlank
    @Size(max = 50)
    private String firstName;

    @JsonProperty("last_name")
    @NotBlank
    @Size(max = 50)
    private String lastName;

    @NotEmpty
    private List<AccountsDto> accounts;
}
