package com.github.thiagoleitecarvalho.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.github.thiagoleitecarvalho.entity.Grade;
import com.github.thiagoleitecarvalho.entity.Student;

/**
 * HelperClass to create Students and Grades.
 * @author Thiago Leite e Carvalho
 * @see My linkedIn profile: https://www.linkedin.com/in/thiago-leite-e-carvalho-1b337b127/
 */
public final class EntityUtils {

    private EntityUtils() {
        throw new AssertionError("EntityUtils is an HelperClass class and must not be instantiated.");
    }

    /**
     * Some fake names for Students.
     */
    private static String[] NAMES = new String[] {"Foo", "Bar", "Baz", "Qux"};

    /**
     * Some disciplines for a grade.
     */
    private static String[] DISCIPLINES =
            new String[] {"Object Orientation", "Formal Languages and Automata", "Compilers", "Logic"};

    /**
     * Create a student.
     * @return A new fake student
     */
    public static Student createStudent() {

        Student student = new Student();

        student.setName(getName());
        student.setRegistrationNumber(getRegistrationNumber());

        return student;
    }

    /**
     * Create two grades for a student.
     * @param student Student to create your notes
     * @return Two grades for a student
     */
    public static List<Grade> createGrades(Student student) {

        List<Grade> grades = new ArrayList<>();

        Grade grade1 = new Grade();
        grade1.setStudent(student);
        grade1.setGrade(getGrade());
        grade1.setDiscipline(getDiscipline());
        grades.add(grade1);

        Grade grade2 = new Grade();
        grade2.setStudent(student);
        grade2.setGrade(getGrade());
        grade2.setDiscipline(getDiscipline());
        grades.add(grade2);

        return grades;
    }

    /**
     * Get a random name.
     * @return A name for a student
     */
    private static String getName() {

        int index = (int) (Math.random() * 4);
        return NAMES[index];
    }

    /**
     * Get a random registration number.
     * @return A registration number for a student
     */
    private static String getRegistrationNumber() {

        int number = (int) (Math.random() * 999999999);
        String registrationNumber = String.valueOf(number);

        return registrationNumber.substring(0, 8).concat("-").concat(registrationNumber.substring(8));
    }

    /**
     * Get a random grade between 0 and 10.
     * @return A fake grade
     */
    private static double getGrade() {

        double randomGrade = (double) (Math.random() * 10);
        double grade = new BigDecimal(randomGrade).setScale(2, RoundingMode.CEILING).doubleValue();

        return grade;
    }

    /**
     * Get a random discipline.
     * @return A name for a discipline
     */
    private static String getDiscipline() {

        int index = (int) (Math.random() * 4);
        return DISCIPLINES[index];
    }

}
