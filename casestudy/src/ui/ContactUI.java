package src.ui;

import java.util.LinkedList;
import java.util.Scanner;
import src.model.Contact;
import src.service.ContactService;

public class ContactUI {

    public static Scanner scanner;
    public static LinkedList<Contact> listContact;
    public ContactService service;
    private static final String CONTACTS_FILE_PATH = "C:/Users/min/IdeaProjects/Module_2/casestudy/data/contacts.csv";

    public ContactUI() {
        scanner = new Scanner(System.in);
        listContact = new LinkedList<>();
        service = new ContactService();
    }


    public void showChoice() {
        while (true){
            menuShow();
            int choice = getUserChoice();
            switch (choice) {
                case 1 -> service.showListContact();
                case 2 -> service.addContact();
                case 3 -> service.updateContact();
                case 4 -> service.deleteContact();
                case 5 -> service.searchContact();
                case 6 -> service.sortContact();
                case 7 -> service.writeContact(CONTACTS_FILE_PATH);
                case 8 -> service.readContact(CONTACTS_FILE_PATH);
                case 0 -> {
                    System.out.println("Thoát chương trình.");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại!");
            }
        }
    }

    private int getUserChoice() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Lỗi! Vui lòng nhập số từ 0-8: ");
            }
        }
    }

    private void menuShow() {
        System.out.println("---CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ---");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Sửa");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Sắp xếp");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Đọc từ file");
        System.out.println("0. Thoát");
        System.out.print("Chọn chức năng: ");
    }
}
