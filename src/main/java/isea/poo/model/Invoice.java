package isea.poo.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Invoice
{
    private final List<ProductQuantity> productQuantityList = new ArrayList<>();
    private BigDecimal totalPrice = new BigDecimal(0);
    private BigDecimal totalTax = new BigDecimal(0);

    public void add(Product product, int quantity)
    {
        ProductQuantity productQuantity = ProductQuantity.of(product, quantity);
        productQuantityList.add(productQuantity);

        addTotalPrice(product.getPrice_excl_tax().add(productQuantity.getTaxes()).multiply(new BigDecimal(quantity)));
        addTotalTax(productQuantity.getTaxes().multiply(new BigDecimal(quantity)));
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    private void addTotalPrice(BigDecimal totalPrice) {
       this.totalPrice = this.totalPrice.add(totalPrice);
    }

    private void addTotalTax(BigDecimal totalTax) {
        this.totalTax = this.totalTax.add(totalTax);
    }

    @Override
    public String toString() {
        return productQuantityList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")) + " Montant des taxes : " + totalTax + " Total : " + totalPrice;
    }
}
