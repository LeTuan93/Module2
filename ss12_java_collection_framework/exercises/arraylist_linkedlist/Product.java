package exercises.arraylist_linkedlist;

public class Product implements Comparable<Product> {
    private String productName;
    private double productPrice;
    private static int cnt = 0;
    private int id ;

    public Product(){
        this.productName = "";
        this.productPrice = 0;
    }

    public Product(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.id = cnt;
        cnt +=1;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product [productName=" + productName + ", productPrice=" + productPrice + ", productID=" + this.id + "]";
    }

    @Override
    public int compareTo(Product o) {
        return Double.compare(this.getProductPrice(), o.getProductPrice());
    }
}
