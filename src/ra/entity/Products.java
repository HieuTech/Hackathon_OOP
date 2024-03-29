package ra.entity;

import java.util.Date;

public class Products {

    private String productId;
    private String productName;
    private String descriptions;
    private float price;
    private Date created;
    private int catalogId;
    private String productStatus;

    @Override
    public String toString() {
        return "Products{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", price=" + price +
                ", created=" + created +
                ", catalogId=" + catalogId +
                ", productStatus='" + (productStatus.equals("ACTIVE") ? "Dang Ban" :
                (productStatus.equals("BLOCK") ? "Het Hang" : "Khong Ban")) + '\'' +
                '}';
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public Products() {
    }
}
