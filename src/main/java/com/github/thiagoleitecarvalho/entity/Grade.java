package com.github.thiagoleitecarvalho.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Class responsible for representing the student's grades in a discipline.
 * @author Thiago Leite e Carvalho
 * @see My linkedIn profile: https://www.linkedin.com/in/thiago-leite-e-carvalho-1b337b127/
 */
@Entity
@Table(name = "tb_grade")
public class Grade {

    /**
     * Id.
     */
    @Id
    @SequenceGenerator(allocationSize = 1, name = "tb_grade_id_seq", sequenceName = "tb_grade_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_grade_id_seq")
    @Column(name = "id")
    private Integer id;

    /**
     * The student who owns the grade.
     */
    @ManyToOne
    @JoinColumn(name = "id_student", nullable = false)
    private Student student;

    /**
     * The grade in a discipline.
     */
    @Column(name = "nr_grade", nullable = false, precision = 10, scale = 2)
    private double grade;

    /**
     * Name of the discipline.
     */
    @Column(name = "ds_discipline", nullable = false, length = 200)
    private String discipline;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public double getGrade() {
        return this.grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getDiscipline() {
        return this.discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;

        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Grade) {

            Grade grade = (Grade) obj;
            return this.id.equals(grade.getId());
        }

        return false;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "[".concat(String.valueOf(this.grade)).concat(",")
                .concat(this.discipline).concat(",")
                .concat(this.student.getName()).concat("]");
    }
}
