package service;

import Model.Phone;
import Model.OfficialPhone;
import Model.ImportedPhone;
import exception.NotFoundProductException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class PhoneManagement {
    private static final String FILE_PATH = "C:/Users/min/IdeaProjects/Module_2/Test_Final_Module2/data/mobiles.csv";
    private List<Phone> phoneList = new ArrayList<>();

    public void loadPhoneData() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                int quantity = Integer.parseInt(data[3]);
                String manufacturer = data[4];

                Phone phone = null;

                // Nếu trường thứ 5 là số nguyên thì là điện thoại chính hãng
                if (isNumeric(data[5])) {
                    int warrantyTime = Integer.parseInt(data[5]);
                    String warrantyScope = data[6];
                    phone = new OfficialPhone(id, name, price, quantity, manufacturer, warrantyTime, warrantyScope);
                }
                // Nếu trường thứ 5 là chuỗi thì là điện thoại xách tay
                else {
                    String importCountry = data[5];
                    String status = data[6];
                    phone = new ImportedPhone(id, name, price, quantity, manufacturer, importCountry, status);
                }

                if (phone != null) {
                    phoneList.add(phone);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void addPhoneFromFile(String line) {
        String[] data = line.split(",");
        int id = Integer.parseInt(data[0]);
        String name = data[1];
        double price = Double.parseDouble(data[2]);
        int quantity = Integer.parseInt(data[3]);
        String manufacturer = data[4];

        if (data.length == 6) {
            int warrantyTime = Integer.parseInt(data[5]);
            String warrantyScope = data[6];
            phoneList.add(new OfficialPhone(id, name, price, quantity, manufacturer, warrantyTime, warrantyScope));
        } else if (data.length == 7) {
            String importCountry = data[5];
            String status = data[6];
            phoneList.add(new ImportedPhone(id, name, price, quantity, manufacturer, importCountry, status));
        }
    }

    public void savePhoneData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Phone phone : phoneList) {
                bw.write(phone.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addPhone(Phone phone) {
        int newId = generateNewPhoneId();
        phone = assignNewPhoneId(phone, newId);
        phoneList.add(phone);
        savePhoneData();
    }

    private int generateNewPhoneId() {
        return phoneList.isEmpty() ? 1 : phoneList.get(phoneList.size() - 1).getId() + 1;
    }

    private Phone assignNewPhoneId(Phone phone, int newId) {
        if (phone instanceof OfficialPhone) {
            OfficialPhone officialPhone = (OfficialPhone) phone;
            return new OfficialPhone(newId, officialPhone.getName(), officialPhone.getPrice(),
                    officialPhone.getQuantity(), officialPhone.getManufacturer(),
                    officialPhone.getWarrantyTime(), officialPhone.getWarrantyScope());
        } else if (phone instanceof ImportedPhone) {
            ImportedPhone importedPhone = (ImportedPhone) phone;
            return new ImportedPhone(newId, importedPhone.getName(), importedPhone.getPrice(),
                    importedPhone.getQuantity(), importedPhone.getManufacturer(),
                    importedPhone.getImportCountry(), importedPhone.getStatus());
        }
        return null;
    }

    public void deletePhone(int id) throws NotFoundProductException {
        Phone phoneToDelete = findPhoneById(id);
        if (phoneToDelete != null) {
            phoneList.remove(phoneToDelete);
            savePhoneData();
        } else {
            throw new NotFoundProductException("ID điện thoại không tồn tại.");
        }
    }

    private Phone findPhoneById(int id) {
        for (Phone phone : phoneList) {
            if (phone.getId() == id) {
                return phone;
            }
        }
        return null;
    }

    public List<Phone> searchPhones(String keyword) {
        List<Phone> result = new ArrayList<>();
        String lowerCaseKeyword = keyword.toLowerCase();

        for (Phone phone : phoneList) {
            if (phone.getName().toLowerCase().contains(lowerCaseKeyword) ||
                    String.valueOf(phone.getId()).contains(lowerCaseKeyword)) {
                result.add(phone);
            }
        }
        return result;
    }

    public void displayPhoneList() {
        if (phoneList.isEmpty()) {
            System.out.println("Không có điện thoại nào trong danh sách.");
        } else {
            for (Phone phone : phoneList) {
                System.out.println(phone);
                phone.displayDetails();
            }
        }
    }
}
