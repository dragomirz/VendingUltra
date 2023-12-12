public class Products {
    final private int product_id;
    private String product_name;
    private String product_type;
    public Products(int product_id, String product_name, String product_type){
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_type = product_type;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_type() {
        return product_type;
    }
}
