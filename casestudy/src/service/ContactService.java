package src.service;

import src.exception.FileReadException;
import src.exception.FileWriteException;
import src.exception.InvalidPhoneNumberException;
import src.model.Contact;

import java.sql.SQLOutput;
import java.util.*;

import static src.ui.ContactUI.*;
import src.service.FileService;

public class ContactService implements IContactService {

    private FileService fileService = new FileService();
    @Override
    public void showListContact() {
        int pageSize = 5;
        int totalContacts = listContact.size();

        for (int i = 0; i < totalContacts; i++) {
            System.out.println(listContact.get(i).toString());

            if((i+1)%pageSize == 0  && (i+1) < totalContacts) {
                System.out.println("Nhấp enter để xem tiếp...");
                scanner.nextLine();
            }
        }
        System.out.println("Đã hiển thị hết danh bạ");
    }
    @Override
    public void addContact() {
        String message = "thêm người dùng";
        try {
            Contact newContact = typeNewContact();
            listContact.add(newContact);
            actionMessageSuccess(message);
        } catch (Exception e) {
            actionMessageFailure(message);
        }
    }


    @Override
    public void updateContact() {
        String messageSuccess = "cập nhật người dùng";
        String messageCustome = "Không tìm được danh bạ với số điện thoại trên";
        System.out.printf("Yêu cầu nhập số điện thoại danh bạ cần sửa:");
        String newPhoneNumberNeedFix = scanner.nextLine().trim();
        if (newPhoneNumberNeedFix.equals("")) {
            return;
        }
        if (newPhoneNumberNeedFix.isEmpty()) {
            System.out.println("Thoát cập nhật danh bạ.");
            return;
        }
        for (int i = 0; i < listContact.size(); i++) {
            if(listContact.get(i).getPhoneNumber().equals(newPhoneNumberNeedFix)) {
                typeFixContact(listContact.get(i));
                actionMessageSuccess(messageSuccess);
                return;
            }
        }
        actionMessageCustome(messageCustome);
        actionMessageTryAgain();
        updateContact();
    }

    @Override
    public void deleteContact() {
        String delete = "xóa";
        String messageCustome = "Không tìm được danh bạ với số điện thoại trên";
        System.out.println("Yêu cầu nhập số điện thoại danh bạ cần xóa:");
        String newPhoneNumberNeedDelete = scanner.nextLine();
        for (Contact tmp: listContact){
            if (tmp.getPhoneNumber().equals(newPhoneNumberNeedDelete)) {
                boxConfirmation(delete);
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("Y")){
                    listContact.remove(tmp);
                    actionMessageSuccess(delete);
                }  else if(confirm.equalsIgnoreCase("N")){
                    actionMessageFailure(delete);
                } else{
                    actionMessageTryAgain();
                }
                return;
            }
        }
        actionMessageCustome(messageCustome);
        actionMessageTryAgain();
        deleteContact();
    }

    @Override
    public void searchContact() {
        String search = "tìm kiếm";
        System.out.println("Yêu cầu nhập số điện thoại danh bạ hoặc họ và tên cần tìm:");
        String keywordSearch = scanner.nextLine();
        Boolean searched = false;
        for (Contact tmp: listContact){
            if (tmp.getPhoneNumber().toLowerCase().contains(keywordSearch.toLowerCase()) || tmp.getFullName().toLowerCase().contains(keywordSearch.toLowerCase())) {
                actionMessageCustome(tmp.toString());
                searched = true;
            }
        }
        if (searched == false) {
            actionMessageFailure(search);
        }
    }

    @Override
    public void sortContact() {
        System.out.println("DANH SÁCH SẮP XẾP THEO HỌ TÊN");
        Collections.sort(listContact);
        for(Contact tmp: listContact){
            actionMessageCustome(tmp.toString());
        }
        actionMessageCustome("\n");
    }

    @Override
    public void writeContact(String fileNamePath) {
        messageWarningSaveFileFromList();
        String choice = scanner.nextLine().trim();

        if (choice.equalsIgnoreCase("Y")) {
            fileService = new FileService(); // Không cần thiết khởi tạo lại nếu đã có sẵn

            StringBuilder content = new StringBuilder();
            content.append("Số điện thoại,Nhóm,Họ tên,Giới tính,Địa chỉ,Ngày sinh,Email\n");

            for (Contact contact : listContact) {
                content.append(contact.getPhoneNumber()).append(",")
                        .append(contact.getContactGroup()).append(",")
                        .append(contact.getFullName()).append(",")
                        .append(contact.getSex()).append(",")
                        .append(contact.getAddress()).append(",")
                        .append(contact.getBirthday()).append(",")
                        .append(contact.getEmail()).append("\n");
            }

            try {
                fileService.writeFile(fileNamePath, content.toString());
                System.out.println("Ghi danh bạ vào file thành công.");
            } catch (FileWriteException e) {
                System.out.println("Lỗi khi ghi file: " + e.getMessage());
            }
        }
    }

    @Override
    public void readContact(String fileNamePath) {
        try {
            String content = fileService.readFile(fileNamePath);

            System.out.println("Nội dung file:");
            System.out.println(content);

            if (!listContact.isEmpty()) {
                System.out.printf("Cảnh báo dữ liệu hiện tại chưa được lưu, \n" +
                        "Chọn Y: thực hiện đọc từ file (xóa dữ liệu hiện tại)\n" +
                        "Chọn N: quay lại\n" +
                        "Vui lòng nhập lựa chọn: ");

                String choice = scanner.nextLine().trim();
                if (choice.equalsIgnoreCase("Y")) {
                    listContact.clear();
                    writeCurrentListFromFile(content);
                }
                return;
            }

            // Xử lý đọc từ file lên danh sách
            writeCurrentListFromFile(content);

        } catch (FileReadException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }


    private void actionMessageSuccess(String message){
        System.out.println("Thành công thực hiện " + message);
    }
    private void actionMessageFailure(String message){
        System.out.println("Thất bại thực hiện " + message);
    }

    private void actionMessageCustome(String message){
        System.out.println(message);
    }

    private void actionMessageTryAgain(){
        System.out.println("Bạn hãy nhập lại");

    }

    private void boxConfirmation(String message){
        String inform = "Bạn xác nhận muốn ";
        System.out.println(inform + message +"\n"+
                    "Có(Y)       Không(N)\n");
    }
    private Contact typeNewContact() {
        String newPhoneNumber = inputPhoneNumber();
        String newNameContact = inputText("Nhập nhóm danh bạ:");
        String fullName = inputText("Nhập họ và tên:");
        String sex = inputText("Nhập giới tính:");
        String address = inputText("Nhập địa chỉ:");
        String birthDate = inputBirthDate();
        String email = inputEmail();

        return new Contact(newPhoneNumber, newNameContact, fullName, sex, address, birthDate, email);
    }


    private void typeFixContact(Contact contact) {
        contact.setContactGroup(inputText("Nhập nhóm danh bạ:"));
        contact.setFullName(inputText("Nhập họ và tên:"));
        contact.setSex(inputText("Nhập giới tính:"));
        contact.setAddress(inputText("Nhập địa chỉ:"));
        contact.setBirthday(inputBirthDate());
        contact.setEmail(inputEmail());
    }

    private void writeCurrentListFromFile(String content) {
        String[] lines = content.split("\n");
        for (String line : lines) {
            Contact contact = parseContactFromLine(line);
            listContact.add(contact);
        }
    }

    // Hàm này sẽ tách một dòng thành các chi tiết và tạo đối tượng Contact
    private Contact parseContactFromLine(String line) {
        String[] detailLine = line.split(", ");
        Contact contact = new Contact();

        for (String detail : detailLine) {
            String[] keyValue = detail.split(":");
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();
            updateContactWithKeyValue(contact, key, value);
        }

        return contact;
    }

    // Hàm này sẽ cập nhật đối tượng Contact với key-value
    private void updateContactWithKeyValue(Contact contact, String key, String value) {
        switch (key) {
            case "Số điện thoại":
                contact.setPhoneNumber(value);
                break;
            case "Nhóm":
                contact.setContactGroup(value);
                break;
            case "Họ tên":
                contact.setFullName(value);
                break;
            case "Giới tính":
                contact.setSex(value);
                break;
            case "Địa chỉ":
                contact.setAddress(value);
                break;
            case "Ngày sinh":
                contact.setBirthday(value);
                break;
            case "Email":
                contact.setEmail(value);
                break;
        }
    }

    private void messageWarningSaveFileFromList(){
        System.out.printf("Bạn có chắc chắn muốn cập nhật file danh bạ, dữ liệu trong danh bạ sẽ bị thay thế, \n" +
                "Chọn Y: Có (xóa dữ liệu hiện tại)\n" +
                "Chọn N: Không\n" +
                "Vui lòng nhập lựa chọn:");
    }

    private String inputPhoneNumber() {
        while (true) {
            System.out.printf("Nhập số điện thoại:");
            String phoneNumber = scanner.nextLine().trim();
            if (phoneNumber.matches("\\d{10}")) {
                if (checkExistedContact(phoneNumber) == false) {
                    return phoneNumber;
                }
            }
            System.out.println("Số điện thoại không hợp lệ hoặc đã tồn tại.");
        }
    }

    private boolean checkExistedContact(String phoneNumber) {
        for (Contact contact : listContact) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    private String inputBirthDate() {
        while (true) {
            System.out.printf("Nhập ngày sinh (yyyy-MM-dd):");
            String birthDate = scanner.nextLine().trim();
            if (birthDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                return birthDate;
            }
            System.out.println("Ngày sinh không hợp lệ. Vui lòng nhập lại (yyyy-MM-dd).");
        }
    }

    private String inputEmail() {
        while (true) {
            System.out.printf("Nhập email:");
            String email = scanner.nextLine().trim();
            if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.(?:com|vn|net|org|edu|gov)$")) {
                return email;
            }
            System.out.println("Email không hợp lệ. Vui lòng nhập lại.");
        }
    }

    private String inputText(String message) {
        System.out.printf(message);
        return scanner.nextLine().trim();
    }
}
