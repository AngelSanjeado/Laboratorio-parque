public class BilleteraParque {
    private int tickets;
    private static boolean festivo = false;

    public BilleteraParque(){
        this.tickets = 0;
    }

    public BilleteraParque(int tickets){
        this.tickets = tickets;
    }

    public void agregarTickets(int tickets){
        if (tickets > 0){
            this.tickets += tickets;
        }

        else return;
    }

    public boolean removerTickets(int tickets){
        if (tickets > 0 && getTickets() >= tickets){
           this.tickets -= tickets;
           return true;
        }

        return false;
    }

    public int getTickets(){
        return this.tickets;
    }

    public void setTickets(int tickets) {
        if (tickets < 0){
            return;
        }

        else this.tickets = tickets;
    }

    public static boolean getFestivo(){
        return festivo;
    }

    public static void setFestivo(){
        festivo = !festivo;
    }

    public String mostrarMenu(){
        return String.format("1. %s \n 2. %s \n 3. %s \n 4. %s \n 5. %s", "Agregar tickets", "Establecer tickets", "Comprar premios", "Establecer festivo", "Salir");
    }

}
