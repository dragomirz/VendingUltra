public class Ingredients {
    final private int ingredient_id;
    private String ingredient_name;
    private int quantity_available;
    private String unit;
    public Ingredients(int ingredient_id, String ingredient_name, int quantity_available, String unit){
        this.ingredient_id = ingredient_id;
        this.ingredient_name = ingredient_name;
        this.quantity_available = quantity_available;
        this.unit = unit;
    }
    public int getIngredient_id() {
        return ingredient_id;
    }
    public String getIngredient_name() {
        return ingredient_name;
    }

    public void setIngredient_name(String ingredient_name) {
        this.ingredient_name = ingredient_name;
    }

    public int getQuantity_available() {
        return quantity_available;
    }

    public void setQuantity_available(int quantity_available) {
        this.quantity_available = quantity_available;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
