public class Products {
    final private int product_id;
    private String product_name;
    private String product_type;
    private Ingredients [] ingredients;
    private int price;
    public Products(int product_id, String product_name, String product_type, Ingredients [] ingredients, int price ){
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_type = product_type;
        this.ingredients = ingredients;
        this.price = price;
    }
    public Products(int product_id, String product_name, String product_type, int price ){
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_type = product_type;
        this.price = price;
    }
    public int getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public Ingredients[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients[] ingredients) {
        this.ingredients = ingredients;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
