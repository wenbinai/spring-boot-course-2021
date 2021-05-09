package edu.nefu.backendexamples.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO {
    private String name;
    private String number;
    private String title;
}
