package com.busanit501.helloworld.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class MemDTO {
    private Long mno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;

}
