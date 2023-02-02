package org.sbitnev.part2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "third_task")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThirdTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "initial_array")
    private String array1;

    @Column(name = "magic_array")
    private String array2;

    @Column(name = "cost")
    private int cost;

    @Column(name = "number")
    private int number;

    public ThirdTask(String array1, String array2, int cost, int number) {
        this.array1 = array1;
        this.array2 = array2;
        this.cost = cost;
        this.number = number;
    }
}

