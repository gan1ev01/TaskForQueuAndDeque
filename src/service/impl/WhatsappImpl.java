package service.impl;

import classes.Profile;
import classes.Whatsapp;
import enums.Status;
import service.WhatsappService;

import java.util.*;

public class WhatsappImpl implements WhatsappService {

    private List<Whatsapp> whatsappList = new ArrayList<>();

    public List<Whatsapp> getWhatsappList() {
        return whatsappList;
    }

    public void setWhatsappList(List<Whatsapp> whatsappList) {
        this.whatsappList = whatsappList;
    }

    @Override
    public String installWhatsapp() {
        boolean b = false;
        try {
            System.out.print("ID : ");
            long id = new Scanner(System.in).nextLong();
            System.out.print("Phone number : ");
            String phoneNumber = new Scanner(System.in).nextLine().trim();
            System.out.print("Create a password : ");
            String password = new Scanner(System.in).nextLine();
            System.out.print(" Username : ");
            String username = new Scanner(System.in).nextLine().toLowerCase();

            String images = "NURIK";
            List<String> messages = new Stack<>();
            List<Profile> contacts = new ArrayList<>();

            Whatsapp whatsapp = new Whatsapp(
                    id, username, password, contacts, messages, getWhatsappStatus(), "DEFAULT_IMAGE", phoneNumber);
            b = whatsappList.add(whatsapp);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return b ? "Passport  successfully created ." : "Error!";
    }

    @Override
    public List<Whatsapp> getAllWhatsappUsers() {
        return whatsappList;
    }

    @Override
    public List<Status> getAllWhatsappStatuses() {
        return List.of(Status.values());
    }

    @Override
    public String changeStatus() throws Exception {
        System.out.print("password: ");
        String password = new Scanner(System.in).next();
        for (Whatsapp whatsApp : whatsappList) {
            if (whatsApp.getPassword().equals(password)) {
                System.out.println("new Status");
                whatsApp.getProfile().setStatus(Status.valueOf(new Scanner(System.in).next()));
                return "Status successfully changed!";
            }
        }
        return "Status did not change !!";
    }
//        System.out.print("Enter your username : ");
//        String username = new Scanner(System.in).nextLine().toLowerCase();
//        System.out.print("Enter your password : ");
//        String password = new Scanner(System.in).nextLine().toLowerCase();
//        for (Whatsapp w : whatsappList) {
//            if (w.getUserName().equals(username) && w.getPassword().equals(password)) {
//
//            }
//        }
//        return changeStatus();
//    }

    @Override
    public Profile getProfile() throws Exception {
        System.out.print("Enter your username : ");
        String username = new Scanner(System.in).nextLine().toLowerCase();
        System.out.print("Enter your password : ");
        String password = new Scanner(System.in).nextLine();
        for (Whatsapp w : whatsappList) {
            if (w.getUserName().equals(username) && w.getPassword().equals(password)) {
                return w;
            }
        }
        return null;
    }

    @Override
    public Status getWhatsappStatus() throws Exception {
        System.out.print("Enter your username : ");
        String username = new Scanner(System.in).nextLine().toLowerCase();
        System.out.print("Enter your password : ");
        String password = new Scanner(System.in).nextLine();
        for (Whatsapp w : whatsappList) {
            if (w.getUserName().equals(username) && w.getPassword().equals(password)) {
                return w.getStatus();
            }
        }
        return null;
    }

    @Override
    public String addContact() {
        System.out.print("Write the password: ");
        String password = new Scanner(System.in).next();
        System.out.print("Write the phone number: ");
        String phoneNumber = new Scanner(System.in).next();
        for (Whatsapp whatsApp : whatsappList) {
            if(whatsApp.getPassword().equals(password)){
                for (Whatsapp whatsapp : whatsappList) {
                    if(whatsapp.getProfile().getPhoneNumber().equals(phoneNumber)){
                        System.out.println("Wrong password");
                    }

                }
            }
        }
        return "Wrong password!";
    }

    @Override
    public String addContact(List<Whatsapp> whatsappList, Whatsapp whatsapp) {
        return null;
    }

    @Override
    public String getMessage() {
        System.out.print("Write your password: ");
        String password = new Scanner(System.in).next();
        System.out.print("who do you want to write?");
        String userName = new Scanner(System.in).next();
        boolean correct = true;
        for (Whatsapp whatsApp : whatsappList) {
            if(whatsApp.getPassword().equals(password)){
                while (correct){
                    String massage = new Scanner(System.in).next();
                    if (massage.equals("SEND")){
                        correct = false;
                        return "massage successfully sent!";
                    }else {
                        this.getMessage().equals(whatsApp.getProfile().getUserName() +": " + massage);
                    }
                }
            }
        }
        return null;
    }
}







