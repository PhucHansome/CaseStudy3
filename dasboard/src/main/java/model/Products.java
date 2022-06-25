package model;

public class Products {
    private long productId;
    private String nameProduct;
    private String priceProduct;
    private String quantityProduct;
    private String typeProduct;
    private String description;
    private String image;
    private String createDate;
    private String updateDate;
    private String status;

    public Products(long productId, String nameProduct, String priceProduct, String quantityProduct, String typeProduct, String description, String image, String createDate, String updateDate, String status) {
        this.productId = productId;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.quantityProduct = quantityProduct;
        this.typeProduct = typeProduct;
        this.description = description;
        this.image = image;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.status = status;
    }

    public Products(long productId, String nameProduct, String priceProduct, String quantityProduct, String typeProduct, String description, String image, String createDate, String updateDate) {
        this.productId = productId;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.quantityProduct = quantityProduct;
        this.typeProduct = typeProduct;
        this.description = description;
        this.image = image;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Products(long productId, String nameProduct, String priceProduct, String quantityProduct, String typeProduct, String description, String image) {
        this.productId = productId;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.quantityProduct = quantityProduct;
        this.typeProduct = typeProduct;
        this.description = description;
        this.image = image;
    }

    public Products(String nameProduct, String priceProduct, String quantityProduct, String typeProduct, String description, String image) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.quantityProduct = quantityProduct;
        this.typeProduct = typeProduct;
        this.description = description;
        this.image = image;
    }

    public Products(long productId, String nameProduct, String princeProduct, String quantityProduct, String typeProduct, String description, String image, String status) {
    }
//    productId, nameProduct, princeProduct, quantityProduct, typeProduct, description, image,status

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getPriceProduct() {
        return priceProduct;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public void setPriceProduct(String priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(String quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
