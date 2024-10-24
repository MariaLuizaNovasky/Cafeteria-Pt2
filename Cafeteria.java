import java.util.Scanner;

public class Cafeteria {
    // Arrays para armazenar comidas, bebidas e seus preços
    static String[] comidas = {"Bolo de Morango", "Pastel de Frango", "Torta de Limão"};
    static double[] comidasPrecos = {10.0, 8.0, 12.0};
    static String[] bebidas = {"Cafe Expresso", "Suco Natural de Laranja", "Milkshake de Chocolate"};
    static double[] bebidasPrecos = {3.0, 4.0, 5.0};
    
    static String[] pedido = new String[100];
    static int[] quantidade = new int[100];
    
    static double total = 0; // Total do pedido
    static int totalItens = 0; // Total de itens pedidos
    static int i = 0; // Índice para o pedido
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cliente;

        // Recebe o nome do cliente
        System.out.print("Seja bem-vindo a Cafeteria! Por favor, informe seu nome: ");
        cliente = scanner.nextLine();
        
        int respm;
        do {
            System.out.println("Olá, " + cliente + "!");
            System.out.println("----------------------------------------");
            System.out.println("Escolha o que fazer");
            System.out.println("1- Ver Cardápio de Comidas");
            System.out.println("2- Ver Cardápio de Bebidas");
            System.out.println("3- Ver Pedido");
            System.out.println("4- Finalizar Pedido");
            System.out.println("5- Cancelar Pedido");
            System.out.println("0- Sair do programa");
            System.out.print("Escolha uma opção: ");
            respm = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            if (respm < 0 || respm > 5) {
                System.out.println("Escolha inválida. Por favor, escolha um número de 0 a 5.");
                continue; // Volta ao início do loop
            }

            
            // Opção 1: Cardápio de Comidas
            if (respm == 1) {
                System.out.println("Cardápio de comidas");
                for (int j = 0; j < comidas.length; j++) {
                    System.out.printf("%d- %s - R$%.2f%n", (j + 1), comidas[j], comidasPrecos[j]);
                }
                System.out.println("0- Voltar para o menu");
                System.out.print("Escolha uma opção: ");
                int respc = scanner.nextInt();

                if (respc == 0) {
                    continue; // Volta ao início do loop
                } else if (respc < 0 || respc > 3) {
                    System.out.println("Escolha inválida. Por favor, escolha uma opção de 0 a 3.");
                    continue; // Volta ao início do loop
                }

                System.out.print("Quantos deseja adicionar ao pedido? ");
                int qtd = scanner.nextInt();
                
                pedido[i] = comidas[respc - 1]; // Adiciona o item ao pedido
                quantidade[i] = qtd; // Quantidade de cada item
                totalItens += qtd; // Total de itens
                total += comidasPrecos[respc - 1] * qtd; // Atualiza o total
                System.out.printf("Pedido adicionado! Preço atual do pedido: R$%.2f%n", total);
                System.out.println("----------------------------------------");
                i++;
            }

            // Opção 2: Cardápio de Bebidas
            if (respm == 2) {
                System.out.println("Cardápio de bebidas");
                for (int j = 0; j < bebidas.length; j++) {
                    System.out.printf("%d- %s - R$%.2f%n", (j + 1), bebidas[j], bebidasPrecos[j]);
                }
                System.out.println("0- Voltar para o menu");
                System.out.print("Escolha uma opção: ");
                int respb = scanner.nextInt();

                if (respb == 0) {
                    continue; // Volta ao início do loop
                } else if (respb < 0 || respb > 3) {
                    System.out.println("Escolha inválida. Por favor, escolha uma opção de 0 a 3.");
                    continue; // Volta ao início do loop
                }

                System.out.print("Quantos deseja adicionar ao pedido? ");
                int qtd = scanner.nextInt();

                pedido[i] = bebidas[respb - 1]; // Adiciona o item ao pedido
                quantidade[i] = qtd; // Quantidade de cada item
                totalItens += qtd; // Total de itens
                total += bebidasPrecos[respb - 1] * qtd; // Atualiza o total
                System.out.printf("Pedido adicionado! Preço atual do pedido: R$%.2f%n", total);
                System.out.println("----------------------------------------");
                i++;
            }

            // Opção 3: Ver Pedido
            if (respm == 3) {
                System.out.println("Pedidos para " + cliente + ":");
                System.out.println("----------------------------------------");
                for (int n = 0; n < i; n++) {
                    System.out.printf("(%dx) %s%n", quantidade[n], pedido[n]);
                }
                System.out.println("Total de itens no pedido: " + totalItens);
                System.out.printf("Preço total do pedido: R$%.2f%n", total);
                System.out.println("----------------------------------------");
            }

            // Opção 4: Finalizar Pedido
            if (respm == 4) {
                System.out.println("Pedido Finalizado! Obrigado por comprar conosco, " + cliente + "!");
                System.out.println("----------------------------------------");
                for (int n = 0; n < i; n++) {
                    System.out.printf("(%dx) %s%n", quantidade[n], pedido[n]);
                }
                System.out.println("Total de itens no pedido: " + totalItens);
                System.out.printf("Preço total do pedido: R$%.2f%n", total);
                System.out.println("----------------------------------------");
            }

            // Opção 5: Cancelar Pedido
            if (respm == 5) {
                totalItens = 0;
                total = 0;
                i = 0; // Reseta o índice do pedido
                System.out.println("----------------------------------------");
                System.out.println("Pedido Cancelado! Todos os itens foram removidos.");
                System.out.println("----------------------------------------");
            }

        } while (respm != 0);
        
        System.out.println("Encerrando seus pedidos!...");
        scanner.close();
    }
}
