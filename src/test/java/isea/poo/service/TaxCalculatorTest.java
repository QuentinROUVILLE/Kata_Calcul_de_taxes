package isea.poo.service;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxCalculatorTest
{
    @Test
    public void testTaxCalculatorWithoutAdditionalTax()
    {
        BigDecimal priceExclTax = new BigDecimal("0.5");
        boolean isImported = false;
        boolean isExempted = true;

        assertEquals(BigDecimal.valueOf(0.00).doubleValue(), TaxCalculator.getTax(priceExclTax, isImported, isExempted).doubleValue());
    }

    @Test
    public void testTaxCalculatorWithImportedTax()
    {
        BigDecimal priceExclTax = new BigDecimal("5.0");
        boolean isImported = true;
        boolean isExempted = true;

        assertEquals(BigDecimal.valueOf(0.25).doubleValue(), TaxCalculator.getTax(priceExclTax, isImported, isExempted).doubleValue());
    }

    @Test
    public void testTaxCalculatorWithTax()
    {
        BigDecimal priceExclTax = new BigDecimal("10.0");
        boolean isImported = false;
        boolean isExempted = false;

        assertEquals(BigDecimal.valueOf(1.00).doubleValue(), TaxCalculator.getTax(priceExclTax, isImported, isExempted).doubleValue());
    }

    @Test
    public void testTaxCalculatorWithAllTaxes()
    {
        BigDecimal priceExclTax = new BigDecimal("10.00");
        boolean isImported = true;
        boolean isExempted = false;

        assertEquals(BigDecimal.valueOf(1.50).doubleValue(), TaxCalculator.getTax(priceExclTax, isImported, isExempted).doubleValue());
    }

    @Test
    public void testTaxRoundedUp()
    {
        assertEquals(BigDecimal.valueOf(1.00).doubleValue(), TaxCalculator.roundUp(BigDecimal.valueOf(0.99)).doubleValue());
    }

    @Test
    public void testTaxNotRoundedUp()
    {
        assertEquals(BigDecimal.valueOf(1.00).doubleValue(), TaxCalculator.roundUp(BigDecimal.valueOf(1.00)).doubleValue());
    }

    @Test
    public void testTaxRoundedUpOfFive()
    {
        assertEquals(BigDecimal.valueOf(1.05).doubleValue(), TaxCalculator.roundUp(BigDecimal.valueOf(1.01)).doubleValue());
        assertEquals(BigDecimal.valueOf(1.05).doubleValue(), TaxCalculator.roundUp(BigDecimal.valueOf(1.02)).doubleValue());
    }
}
