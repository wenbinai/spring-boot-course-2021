package edu.nefu.backendexamples.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private Long cid;
    List<StudentDTO> students;
}
