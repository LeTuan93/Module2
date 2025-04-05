package Model;

public class ImportedPhone extends Phone {
    private String importCountry; // Quốc gia xách tay
    private String status; // Trạng thái (Da sua chua/Chua sua chua)

    public ImportedPhone(int id, String name, double price, int quantity, String manufacturer, String importCountry, String status) {
        super(id, name, price, quantity, manufacturer);
        this.importCountry = importCountry;
        this.status = status;
    }


    // Override phương thức hiển thị chi tiết cho điện thoại xách tay
    @Override
    public void displayDetails() {
        System.out.println("Imported from: " + importCountry);
        System.out.println("Condition: " + status);
    }

    @Override
    public String toString() {
        // Trả về chuỗi chi tiết với các trường riêng biệt, dễ hiểu
        return "ID: " + id + ", Tên: " + name + ", Giá: " + price + ", Số lượng: " + quantity +
                ", Nhà sản xuất: " + manufacturer + ", Quốc gia xách tay: " + importCountry + ", Trạng thái: " + status;
    }

    public String getImportCountry() {
        return importCountry;
    }

    public void setImportCountry(String importCountry) {
        this.importCountry = importCountry;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}