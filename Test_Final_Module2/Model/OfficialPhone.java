package Model;

public class OfficialPhone extends Phone {
    private int warrantyTime; // Thời gian bảo hành (số ngày)
    private String warrantyScope; // Phạm vi bảo hành (Toan Quoc/Quoc Te)

    public OfficialPhone(int id, String name, double price, int quantity, String manufacturer, int warrantyTime, String warrantyScope) {
        super(id, name, price, quantity, manufacturer);
        this.warrantyTime = warrantyTime;
        this.warrantyScope = warrantyScope;
    }

    @Override
    public String toString() {
        // Trả về chuỗi chi tiết với các trường riêng biệt, dễ hiểu
        return "ID: " + id + ", Tên: " + name + ", Giá: " + price + ", Số lượng: " + quantity +
                ", Nhà sản xuất: " + manufacturer + ", Thời gian bảo hành: " + warrantyTime + " ngày" +
                ", Phạm vi bảo hành: " + warrantyScope;
    }

    // Override phương thức hiển thị chi tiết cho điện thoại chính hãng
    @Override
    public void displayDetails() {
        System.out.println("Warranty Time: " + warrantyTime + " days");
        System.out.println("Warranty Scope: " + warrantyScope);
    }

    public String getWarrantyScope() {
        return warrantyScope;
    }

    public void setWarrantyScope(String warrantyScope) {
        this.warrantyScope = warrantyScope;
    }

    public int getWarrantyTime() {
        return warrantyTime;
    }

    public void setWarrantyTime(int warrantyTime) {
        this.warrantyTime = warrantyTime;
    }
}