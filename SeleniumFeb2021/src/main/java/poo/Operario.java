package poo;

public class Operario extends Empleado{

    //constructor con un par�metro
    public Operario(String nombre) {
        super(nombre);
        System.out.println("Constructor de Operario");
    }

    //constructor por defecto
    public Operario() {
    }

    //modificaci�n del m�todo toString() para mostrar el mensaje adecuado                                         
    @Override
    public String toString() {
        return super.toString() + " -> Operario";
    }
   
}

