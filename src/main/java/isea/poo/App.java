package isea.poo;

import isea.poo.model.Invoice;
import isea.poo.model.Product;

public class App
{
    public static void main( String[] args )
    {
        Invoice invoice = new Invoice();
        invoice.add(Product.of("flacon de parfum importé", 27.99, true, false), 1);
        invoice.add(Product.of("flacon de parfum", 18.99, false, false), 1);
        invoice.add(Product.of("boîte de pilules contre la migraine", 9.75, false, true), 1);
        invoice.add(Product.of("barre de chocolat importé", 11.25, true, true), 1);

        System.out.println(invoice);
    }
}
