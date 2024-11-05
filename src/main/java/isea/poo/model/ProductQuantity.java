package isea.poo.model;

import isea.poo.service.TaxCalculator;

import java.math.BigDecimal;

public class ProductQuantity
{
    private Product product;
    private BigDecimal taxes;
    private int amount;

    private ProductQuantity(Product product, BigDecimal price_with_taxes, int amount)
    {
        this.product = product;
        this.taxes = price_with_taxes;
        this.amount = amount;
    }

    public static ProductQuantity of(Product product, int amount)
    {
        BigDecimal price_with_taxes = TaxCalculator.calculateTax(product.getPrice_excl_tax(), product.isImported(), product.isExempted());
        return new ProductQuantity(product, price_with_taxes, amount);
    }

    public BigDecimal getTaxes() {
        return taxes;
    }

    @Override
    public String toString() {
        return amount + " " + product.getName() + " : " + (product.getPrice_excl_tax().add(taxes));
    }
}
