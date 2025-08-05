package com.lmcadev.client.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDTOResponse {
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;

}
