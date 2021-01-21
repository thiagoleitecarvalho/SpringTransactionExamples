package com.github.thiagoleitecarvalho.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Class responsible for representing a student.
 * @author Thiago Leite e Carvalho
 * @see My linkedIn profile: https://www.linkedin.com/in/thiago-leite-e-carvalho-1b337b127/
 */
@Entity
@Table(name = "tb_student")
public class Student {

    /**
     * Id.
     */
    @Id
    @SequenceGenerator(allocationSize = 1, name = "tb_student_id_seq", sequenceName = "tb_student_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_student_id_seq")
    @Column(name = "id")
    private Integer id;

    /**
     * Registration number at the school.
     */
    @Column(name = "nr_registration", nullable = false, length = 10)
    private String registrationNumber;

    /**
     * Name of the student.
     */
    @Column(name = "tx_name", nullable = false, length = 200)
    private String name;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;

        result = prime * result + ((this.registrationNumber == null) ? 0 : this.registrationNumber.hashCode());
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Student) {

            Student student = (Student) obj;
            return this.registrationNumber.equals(student.getRegistrationNumber());
        }

        return false;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "[".concat(this.name).concat(",")
                .concat(this.registrationNumber).concat("]");
    }
}
