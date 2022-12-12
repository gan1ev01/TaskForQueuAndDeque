import service.PersonService;
import service.WhatsappService;
import service.impl.PersonImpl;
import service.impl.WhatsappImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        PersonImpl personService = new PersonImpl();
        WhatsappImpl whatsappService = new WhatsappImpl();
        while (true) {
            System.out.println("""
                     * =================================== *
                    ||      >>>>> * COMMANDS * <<<<<       ||
                    ||   1. - Get all passports.           ||
                    ||   2. - Get passport by first name.  ||
                    ||   3. - Get all Whatsapp Users.      ||
                    ||   4. - Go to your profile.          ||                
                    ||   5. - Get all countries.           ||
                    ||   6. - Get Whatsapp Status.         ||
                    ||   7. - Create passport.             ||
                    ||   8. - Install Whatsapp.            ||
                    ||   9. - Change Status.               ||
                    ||   10.- Add contact.                 ||
                    ||   11.- Send Message.                ||
                    ||   12.- See Status.                  ||
                     * =================================== *
                         """);
            int number = new Scanner(System.in).nextInt();
            if(number == 0)
                break;
            else if(number == 1) System.out.println(personService.getAllPassports());
            else if(number == 2) System.out.println(personService.getPassportByFirstName());
            else if(number == 3) System.out.println(whatsappService.getAllWhatsappUsers());
            else if(number == 4) System.out.println(whatsappService.getProfile());
            else if(number == 5) System.out.println(personService.getAllCountries());
            else if(number == 6) System.out.println(whatsappService.getWhatsappStatus());
            else if(number == 7) System.out.println(personService.createPassport());
            else if(number == 8) System.out.println(whatsappService.installWhatsapp());
            else if(number == 9) System.out.println(whatsappService.changeStatus());
            else if(number == 10) System.out.println(whatsappService.addContact());
            else if(number == 11) continue;
            else if(number == 12) System.out.println(whatsappService.getAllWhatsappStatuses());
        }
    }
}




