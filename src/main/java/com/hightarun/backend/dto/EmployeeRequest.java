package com.hightarun.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Request will come from client.
@Getter
@Setter
@AllArgsConstructor(staticName="build")
@NoArgsConstructor
public class EmployeeRequest {
    private String firstName;
    private String lastName;
    private String emailId;
}
