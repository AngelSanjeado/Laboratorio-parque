public class Premios {
    private String nombre;
    private int precio;

    public Premios(String nombre, int precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre(){
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void aplicarDescuento(boolean festivo) {
        if (festivo){
            this.precio /= 2;
        }

        else this.precio *=2;
    }

    @Override
    public String toString(){
        return String.format("%s \t (%d tickets)", getNombre(), getPrecio());
    }
}
