package org.sbitnev.part2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "one_task")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
