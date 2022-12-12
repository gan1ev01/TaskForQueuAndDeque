package service.impl;

import classes.Passport;
import enums.Country;
import enums.Gender;
import service.PersonService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonImpl implements PersonService {
    private List<Passport> passportList = new ArrayList<>();

    public List<Passport> getPassportList(){
        return passportList;
    }

    public void setPassportList(List<Passport> passportList){
        this.passportList = passportList;
    }
    @Override
    public List<Passport> getAllPassports() {
        return passportList;
    }

    @Override
    public List<Passport> getPassportByFirstName() {
        List<Passport> result = new ArrayList<>();
        System.out.print("First Name : ");
        String getfirstName  = new Scanner(System.in).nextLine();
        for (Passport p : passportList)
            if(p.getFirstName().equals(getfirstName))
                result.add(p);
        return result;
    }

    @Override
    public String createPassport() {
        boolean a = false;
        try {
            System.out.print("ID : ");
            int id = new Scanner(System.in).nextInt();
            System.out.print("First Name : ");
            String firstName = new Scanner(System.in).nextLine();
            System.out.print("Last Name : ");
            String lastName = new Scanner(System.in).nextLine();
            System.out.print("Date of birth (Year_Month_Day):");
            String[] birthDateList = new Scanner(System.in).nextLine().trim().split("_");
            System.out.print("Gender: ");
            String gender = new Scanner(System.in).next();
            System.out.print("Country : ");
            String country = new Scanner(System.in).next();
            LocalDate dateOfBirth = LocalDate.of(
                    Integer.parseInt(birthDateList[0]),
                    Integer.parseInt(birthDateList[1]),
                    Integer.parseInt(birthDateList[2]));


            Passport passport = new Passport(
                    id, firstName, lastName, Gender.valueOf(gender), Country.valueOf(country), dateOfBirth);
            a = passportList.add(passport);
        }catch (Exception e){
            e.printStackTrace();
        }
        return a ? "Passport created sucessfuly.\n" : "Error: \n";
    }

    @Override
    public List<Country> getAllCountries() {
        return List.of(Country.values());
    }
}
