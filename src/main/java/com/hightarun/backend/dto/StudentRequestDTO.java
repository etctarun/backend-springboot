package com.hightarun.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

//Request will come from client.
@Getter
@Setter
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class StudentRequestDTO {

    @NotNull
    private long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Min(0)
    @NotNull
    private long rollNo;

    @Email(message = "Invalid Email Address")
    private String emailId;

    @NotBlank(message = "department is required")
    private String departmentName;

}
