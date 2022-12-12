package service;

import classes.Profile;
import classes.Whatsapp;
import enums.Status;

import java.util.List;

public interface WhatsappService {
    String installWhatsapp();

    List<Whatsapp> getAllWhatsappUsers();

    List<Status> getAllWhatsappStatuses();

    String changeStatus() throws Exception;

    Profile getProfile() throws Exception;

    Status getWhatsappStatus() throws Exception;

    String addContact();

    String addContact(List<Whatsapp> whatsappList, Whatsapp whatsapp);

    String getMessage();
}
