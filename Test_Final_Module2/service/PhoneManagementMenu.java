package service;

import Model.Phone;
import Model.OfficialPhone;
import Model.ImportedPhone;
import exception.NotFoundProductException;

import java.util.List;
import java.util.Scanner;

public class PhoneManagementMenu {
    private PhoneManagement phoneManagement;
    private Scanner scanner;

    public PhoneManagementMenu() {
        this.phoneManagement = new PhoneManagement();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        phoneManagement.loadPhoneData();
        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Thêm mới điện thoại");
            System.out.println("2. Xóa điện thoại");
            System.out.println("3. Xem danh sách điện thoại");
            System.out.println("4. Tìm kiếm điện thoại");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addPhone();
                    break;
                case 2:
                    deletePhone();
                    break;
                case 3:
                    viewPhoneList();
                    break;
                case 4:
                    searchPhone();
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private void addPhone() {
        System.out.println("Thêm mới điện thoại.");

        String name = InputValidator.getValidName();
        double price = InputValidator.getValidPrice();
        int quantity = InputValidator.getValidQuantity();
        String manufacturer = InputValidator.getValidManufacturer();

        int type = InputValidator.getValidPhoneType();

        Phone phone;

        if (type == 1) {
            // Điện thoại chính hãng
            int warrantyTime = InputValidator.getValidWarrantyTime();
            String warrantyScope = InputValidator.getValidWarrantyScope();
            phone = new OfficialPhone(0, name, price, quantity, manufacturer, warrantyTime, warrantyScope);
        } else {
            // Điện thoại xách tay
            String importCountry = InputValidator.getValidImportCountry();
            String status = InputValidator.getValidStatus();
            phone = new ImportedPhone(0, name, price, quantity, manufacturer, importCountry, status);
        }

        phoneManagement.addPhone(phone);
        System.out.println("Điện thoại đã được thêm vào.");
    }

    private void deletePhone() {
        System.out.print("Nhập ID điện thoại cần xóa: ");
        int id = scanner.nextInt();
        try {
            phoneManagement.deletePhone(id);
            System.out.println("Điện thoại đã được xóa.");
        } catch (NotFoundProductException e) {
            System.out.println(e.getMessage());
        }
    }

    private void viewPhoneList() {
        phoneManagement.displayPhoneList();
    }

    private void searchPhone() {
        System.out.print("Nhập từ khóa tìm kiếm: ");
        String keyword = scanner.nextLine();
        List<Phone> result = phoneManagement.searchPhones(keyword);
        if (result.isEmpty()) {
            System.out.println("Không tìm thấy điện thoại.");
        } else {
            for (Phone phone : result) {
                System.out.println(phone);
            }
        }
    }
}
