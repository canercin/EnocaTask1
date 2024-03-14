package org.example.enocatask1.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressRequestDTO {
    private Long address_id;
    private String address;
    private Long user_id;
}
