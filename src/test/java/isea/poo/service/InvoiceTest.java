package isea.poo.service;

import isea.poo.model.Invoice;
import isea.poo.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceTest {

    private Invoice invoice;

    @BeforeEach
    public void setUp() {
        Product book = Product.of("livre", 12.49, false, true);
        Product musicCD = Product.of("CD musical", 14.99, false, false);
        Product chocolateBar = Product.of("barre de chocolat", 0.85, false, true);
        Product candy = Product.of("sachet de bonbon", 2.00, false, true);

        invoice = new Invoice();
        invoice.add(book, 1);
        invoice.add(musicCD, 1);
        invoice.add(chocolateBar, 1);
        invoice.add(candy, 1);
    }

    @Test
    public void testInvoiceTotalPrice() {
        assertEquals(new BigDecimal("31.83"), invoice.getTotalPrice());
    }

    @Test
    public void testInvoiceTotalTax() {
        assertEquals(new BigDecimal("1.50"), invoice.getTotalTax());
    }

    @Test
    public void testInvoicePrint() {
        assertEquals("1 livre : 12.49 1 CD musical : 16.49 1 barre de chocolat : 0.85 1 sachet de bonbon : 2.00 Montant des taxes : 1.50 Total : 31.83", invoice.toString());
    }
}
