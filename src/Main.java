import br.com.conradostr.models.CreditCard;
import br.com.conradostr.models.Purchase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner reading = new Scanner(System.in);
        System.out.println("Digite o limite do cartão: ");
        double limit = reading.nextDouble();
        CreditCard card = new CreditCard(limit);

        int op = 1;

        while(op != 0){
            System.out.println("Digite a descrição da compra: ");
            String description = reading.next();

            System.out.println("Digite o valor da compra: ");
            double value = reading.nextDouble();

            Purchase purchase = new Purchase(description, value);
            boolean purchaseMade = card.addPurchase(purchase);

            if (purchaseMade){
                System.out.println("Compra realizada!!");
                System.out.println("Digite 0 para sair e 1 para continuar");
                op = reading.nextInt();
            }else {
                System.out.println("*** Saldo insuficiente ***");
                op = 0;
            }
        }
        System.out.println("***********************");
        System.out.println("COMPRAS REALIZADAS:\n");

        for (Purchase c : card.getShopping()) {
            System.out.println(c.getDescription() + " - " +c.getValue());
        }
        System.out.println("\n***********************");

        System.out.println("\nSaldo do cartão: " +card.getBalance());
    }
}