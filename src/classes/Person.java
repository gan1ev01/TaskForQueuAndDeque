package classes;

import enums.Country;
import enums.Gender;

import java.time.LocalDate;

public class Person extends Passport {

    public Person(long id, String firstName, String lastName, Gender gender, Country country, LocalDate dateOfBirth) {
        super(id, firstName, lastName, gender, country, dateOfBirth);
    }
}
