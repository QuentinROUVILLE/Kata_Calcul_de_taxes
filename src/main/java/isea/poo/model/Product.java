package isea.poo.model;

import java.math.BigDecimal;

public class Product
{
    private String name;
    private BigDecimal price_excl_tax;
    private boolean isImported;
    private boolean isExempted;

    private Product (String name, BigDecimal price_excl_tax, boolean isImported, boolean isExempted)
    {
        this.name = name;
        this.price_excl_tax = price_excl_tax;
        this.isImported = isImported;
        this.isExempted = isExempted;
    }

    public static Product of(String name, double price_excl_tax, boolean isImported, boolean isExempted)
    {
        return new Product(name, BigDecimal.valueOf(price_excl_tax), isImported, isExempted);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice_excl_tax() {
        return price_excl_tax;
    }

    public boolean isImported() {
        return isImported;
    }

    public boolean isExempted() {
        return isExempted;
    }
}
