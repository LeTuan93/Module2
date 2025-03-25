package exercises.arraylist_linkedlist;

import java.sql.SQLOutput;
import java.util.*;

public class ProductManager {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        while(true) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter chức năng: ");
            System.out.println("" +
                    "1. Thêm sản phẩm. \n" +
                    "2. Sửa thoogn tin sản phẩm. \n" +
                    "3. Xóa sản phẩm theo id. \n" +
                    "4. Hiển thị danh sách sản phẩm. \n" +
                    "5. Tìm kiếm sản phẩm. \n" +
                    "6. Sắp xếp sản phẩm tăng dần, giảm dần theo giá.");
            int ch = input.nextInt();
            switch(ch) {
                case 1:
                    add(products);
                    break;
                case 2:
                    fix(products);
                    break;
                case 3:
                    erase(products);
                    break;
                case 4:
                    screen(products);
                    break;
                case 5:
                    find(products);
                    break;
                case 6:
                    sort(products);
                    break;
                default:
                    System.out.println("Mời nhập lại");
                    break;
            }
        }

    }

    public static void add(List<Product> listProduct) {
        System.out.printf("Nhập tên sản phẩm:");
        String nameOfProduct = new Scanner(System.in).nextLine();
        System.out.printf("Nhập giá sản phẩm");
        Double priceOfProduct = new Scanner(System.in).nextDouble();
        listProduct.add(new Product(nameOfProduct, priceOfProduct));
        System.out.println("Cập nhật thành công");
    }
    public static void fix(List<Product> listProduct) {
        System.out.println("Nhập id sản phẩm");
        int id = new Scanner(System.in).nextInt();
        Product tmpProduct = new Product();
        int check = 0;
        for (Product p : listProduct) {
            if (p.getId() == id) {
                tmpProduct = p;
                check =1;
            }
        }

        if (check == 0) {
            System.out.println("Không tồn tại product");
            return;
        }
        System.out.printf("Nhập tên sản phẩm:");
        String nameOfProduct = new Scanner(System.in).nextLine();
        System.out.printf("Nhập giá sản phẩm");
        Double priceOfProduct = new Scanner(System.in).nextDouble();
        tmpProduct.setProductName(nameOfProduct);
        tmpProduct.setProductPrice(priceOfProduct);
        System.out.println("Cập nhật thành công");
    }
    public static void erase(List<Product> listProduct) {
        System.out.println("Nhập id sản phẩm");
        int id = new Scanner(System.in).nextInt();
        Product tmpProduct = new Product();
        int check = 0;
        for (Product p : listProduct) {
            if (p.getId() == id) {
                tmpProduct = p;
                check =1;
            }
        }

        if (check == 0) {
            System.out.println("Không tồn tại product");
            return;
        }
        listProduct.remove(tmpProduct);
        System.out.println("Xóa thành công");
    }
    public static void screen(List<Product> listProduct) {
        for (Product p : listProduct) {
            System.out.println(p);
        }
    }
    public static void find(List<Product> listProduct) {
        System.out.println("Nhập tên sản phẩm");
        String nameProduct = new Scanner(System.in).nextLine();
        Product tmpProduct = new Product();
        int check = 0;
        for (Product p : listProduct) {
            if (p.getProductName().equals(nameProduct)) {
                tmpProduct = p;
                check =1;
            }
        }

        if (check == 0) {
            System.out.println("Không tồn tại product");
            return;
        }
        System.out.println("Thông tin sản phẩm: "+tmpProduct);
    }
    public static void sort(List<Product> listProduct) {
        Collections.sort(listProduct);
        System.out.println("Sắp xếp thành công!");
    }
}
