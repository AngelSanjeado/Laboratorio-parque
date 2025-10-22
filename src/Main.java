import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static String mostrarMenu(){
        return String.format("1. %s \n2. %s \n3. %s \n4. %s \n5. %s", "Agregar tickets", "Establecer tickets", "Comprar premios", "Establecer festivo", "Salir");
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        BilleteraParque bp = new BilleteraParque(100);

        Premios camiseta = new Premios("Camiseta", 150);
        Premios sombrero = new Premios("Sombrero", 350);
        Premios tenis = new Premios("Tenis", 600);

        ArrayList<Premios> premios = new ArrayList<>();

        premios.add(camiseta);
        premios.add(sombrero);
        premios.add(tenis);

        System.out.println("==Administrador de billeteras para parques temáticos==");

        do {

            System.out.println(mostrarMenu());
            System.out.println("Tu billetera tiene " + bp.getTickets() + " boletos");
            System.out.println("Ingrese la opción: ");
            int opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.print("¿Cuántos boletos se agregan? ");
                    int boletos = sc.nextInt();
                    bp.agregarTickets(boletos);
                    break;

                case 2:
                    System.out.print("Establecer saldo de tickets en: ");
                    int tickets = sc.nextInt();
                    bp.setTickets(tickets);
                    break;

                case 3:
                    int i = 1;
                    for (Premios p: premios){
                        System.out.println(i++ + p.toString());
                    }
                    System.out.print("¿Qué premio desea comprar?: ");
                    int premio = sc.nextInt();

                    if (bp.removerTickets()){
                        System.out.println("Disfruta de ");
                    }

            }

        }while (opcion != 5);

    }
}
