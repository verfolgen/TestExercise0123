package org.sbitnev.part2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "one_task")
@Data
@NoArgsConstructor
public class OneTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "array1")
    private String array1;

    @Column(name = "array2")
    private String array2;

    @Column(name = "number")
    private int number;


}
