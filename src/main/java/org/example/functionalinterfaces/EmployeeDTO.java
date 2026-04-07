package org.example.functionalinterfaces;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String name;
    private String department;
    private double salary;
    private LocalDate joiningDate;
}
