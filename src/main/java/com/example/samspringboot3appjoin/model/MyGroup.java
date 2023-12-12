package com.example.samspringboot3appjoin.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

/**
 * <pre>
 * User: clean_brain
 * Date: 2023-12-12
 * Comments:
 * </pre>
 */
@Entity
@Getter
@ToString
public class MyGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private Date createDate = new Date();

    private Date updateDate = new Date();

    public MyGroup() {
    }

    public MyGroup(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
