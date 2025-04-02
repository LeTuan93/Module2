package src.service;

import src.model.Contact;

public interface IContactService {
    void showListContact();
    void addContact();
    void updateContact();
    void deleteContact();
    void searchContact();
    void sortContact();
    void writeContact(String fileNamePath);
    void readContact(String fileNamePath);
}
