package service;

import classes.Passport;
import enums.Country;

import java.util.List;

public interface PersonService {
    List<Passport> getAllPassports();

    List<Passport> getPassportByFirstName();

    String createPassport();

    List<Country> getAllCountries();
}
