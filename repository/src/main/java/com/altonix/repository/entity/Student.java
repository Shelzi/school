package com.altonix.repository.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"id"}, callSuper = false)
@ToString(exclude = {"id"})
@Entity
@Table(name = "students")
public class Student {
    // TODO: 5/23/2023 Delete class
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    @Setter(value = AccessLevel.NONE)
    private long id;

    @Column(name = "student_name")
    private String name;
}
