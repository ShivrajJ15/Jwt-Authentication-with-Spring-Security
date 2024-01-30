package org.shiv.jwtauth.models;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private String userId;
    private String name;
    private String email;
}
