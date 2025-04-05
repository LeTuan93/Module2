package service;

import java.util.Scanner;

public class InputValidator {

    private static Scanner scanner = new Scanner(System.in);

    public static String getValidName() {
        String name;
        while (true) {
            System.out.print("Tên điện thoại: ");
            name = scanner.nextLine();
            if (name == null || name.trim().isEmpty()) {
                System.out.println("Tên điện thoại không được để trống. Vui lòng nhập lại.");
            } else {
                break;
            }
        }
        return name;
    }

    public static double getValidPrice() {
        double price = 0;
        while (true) {
            System.out.print("Giá bán: ");
            try {
                price = Double.parseDouble(scanner.nextLine());
                if (price <= 0) {
                    System.out.println("Giá điện thoại phải là một số dương. Vui lòng nhập lại.");
                } else {
                    break; // Tiến hành khi giá hợp lệ
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số hợp lệ cho giá bán.");
            }
        }
        return price;
    }

    public static int getValidQuantity() {
        int quantity = 0;
        while (true) {
            System.out.print("Số lượng: ");
            try {
                quantity = Integer.parseInt(scanner.nextLine());
                if (quantity < 0) {
                    System.out.println("Số lượng điện thoại phải là số nguyên không âm. Vui lòng nhập lại.");
                } else {
                    break; // Tiến hành khi số lượng hợp lệ
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ cho số lượng.");
            }
        }
        return quantity;
    }

    public static String getValidManufacturer() {
        String manufacturer;
        while (true) {
            System.out.print("Nhà sản xuất: ");
            manufacturer = scanner.nextLine();
            if (manufacturer == null || manufacturer.trim().isEmpty()) {
                System.out.println("Nhà sản xuất không được để trống. Vui lòng nhập lại.");
            } else {
                break;
            }
        }
        return manufacturer;
    }

    public static String getValidWarrantyScope() {
        String warrantyScope;
        while (true) {
            System.out.print("Phạm vi bảo hành (Toan Quoc/Quoc Te): ");
            warrantyScope = scanner.nextLine().trim();
            if (!warrantyScope.equalsIgnoreCase("Toan Quoc") && !warrantyScope.equalsIgnoreCase("Quoc Te")) {
                System.out.println("Phạm vi bảo hành không hợp lệ. Vui lòng nhập 'Toan Quoc' hoặc 'Quoc Te'.");
            } else {
                break;
            }
        }
        return warrantyScope;
    }

    public static int getValidPhoneType() {
        int type;
        while (true) {
            System.out.print("Loại điện thoại (1: Chính hãng, 2: Xách tay): ");
            try {
                type = Integer.parseInt(scanner.nextLine());
                if (type != 1 && type != 2) {
                    System.out.println("Chọn loại điện thoại không hợp lệ. Vui lòng nhập lại.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số 1 hoặc 2 để chọn loại điện thoại.");
            }
        }
        return type;
    }

    public static int getValidWarrantyTime() {
        int warrantyTime = 0;
        while (true) {
            System.out.print("Thời gian bảo hành (số ngày): ");
            try {
                warrantyTime = Integer.parseInt(scanner.nextLine());
                if (warrantyTime <= 0) {
                    System.out.println("Thời gian bảo hành phải là số dương. Vui lòng nhập lại.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ cho thời gian bảo hành.");
            }
        }
        return warrantyTime;
    }

    public static String getValidImportCountry() {
        String importCountry;
        while (true) {
            System.out.print("Quốc gia xách tay: ");
            importCountry = scanner.nextLine();
            if (importCountry == null || importCountry.trim().isEmpty()) {
                System.out.println("Quốc gia xách tay không được để trống. Vui lòng nhập lại.");
            } else {
                break;
            }
        }
        return importCountry;
    }

    public static String getValidStatus() {
        String status;
        while (true) {
            System.out.print("Trạng thái (Da sua chua/Chua sua chua): ");
            status = scanner.nextLine();
            if (status == null || status.trim().isEmpty()) {
                System.out.println("Trạng thái điện thoại không được để trống. Vui lòng nhập lại.");
            } else {
                break;
            }
        }
        return status;
    }
}
