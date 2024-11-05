package isea.poo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculator
{
    public static BigDecimal getTax(BigDecimal price_excl_tax, boolean isImported, boolean isExempted) {
        BigDecimal tax = new BigDecimal(1);

        if(isImported) {
            tax = tax.add(BigDecimal.valueOf(0.05));
        }

        if(!isExempted) {
            tax = tax.add(BigDecimal.valueOf(0.1));
        }

        return price_excl_tax.multiply(tax).subtract(price_excl_tax);
    }

    public static BigDecimal roundUp(BigDecimal tax)
    {
        BigDecimal round = new BigDecimal("0.05");
        return tax.divide(round, 0, RoundingMode.CEILING).multiply(round);
    }

    public static BigDecimal calculateTax(BigDecimal price_excl_tax, boolean isImported, boolean isExempted) {
        BigDecimal tax = getTax(price_excl_tax, isImported, isExempted);
        return roundUp(tax);
    }
}
