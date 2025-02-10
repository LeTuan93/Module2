import java.util.Date;
import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập số tiền (USD):");
        int money = sc.nextInt();
        System.out.println("Số tiền chuyển thành VNĐ:"+money*23000);
    }
}
