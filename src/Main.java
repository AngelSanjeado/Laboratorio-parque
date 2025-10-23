import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static String mostrarMenu(){
        return String.format("1. %s \n2. %s \n3. %s \n4. %s \n5. %s", "Agregar tickets", "Establecer tickets", "Comprar premios", "Establecer festivo", "Salir");
    }

    public static String compraRealizada(boolean compra, int i){
        ArrayList<String> mensaje = new ArrayList<>();

        mensaje.add(String.format("%s camiseta", compra ? "tu" : "una"));
        mensaje.add(String.format("%s sombrero", compra ? "tu" : "un"));
        mensaje.add(String.format("%s tenis", compra ? "tus" : "unos"));

        return mensaje.get(i);
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

        int opcion;
        do {

            System.out.println(mostrarMenu());
            System.out.println("Tu billetera tiene " + bp.getTickets() + " boletos");
            System.out.print("Ingrese la opción: ");
            opcion = sc.nextInt();
            
            System.out.println();

            switch (opcion){

                case 1:
                    System.out.print("¿Cuántos boletos se agregan? ");
                    int boletos = sc.nextInt();
                    bp.agregarTickets(boletos);
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Establecer saldo de tickets en: ");
                    int tickets = sc.nextInt();
                    bp.setTickets(tickets);
                    System.out.println();
                    break;

                case 3:
                    int i = 1;
                    for (Premios p: premios){
                        System.out.println(i++ + ". " + p.toString());
                    }

                    System.out.print("¿Qué premio desea comprar?: ");
                    int prm = sc.nextInt();

                    boolean compra = bp.removerTickets(premios.get(prm-1).getPrecio());

                    if (compra){
                        System.out.println("Disfruta de " + compraRealizada(compra, prm-1));
                    }

                    else{
                        System.out.println("No hay suficientes boletos para comprar " + compraRealizada(compra, prm-1));
                    } 
                    System.out.println();
                    break;  
                
                case 4:
                    BilleteraParque.setFestivo();

                    if (BilleteraParque.getFestivo()) {
                        System.out.println("Ahora es un día festivo.");

                        for(Premios p: premios){
                            p.aplicarDescuento(BilleteraParque.getFestivo());
                        }
                    }

                    else {   
                        System.out.println("Ya no es un día festivo");

                        for(Premios p: premios){
                            p.aplicarDescuento(BilleteraParque.getFestivo());
                        }
                    }
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Saliendo del programa");
            }

        }while (opcion != 5);

        sc.close();
    }
}
