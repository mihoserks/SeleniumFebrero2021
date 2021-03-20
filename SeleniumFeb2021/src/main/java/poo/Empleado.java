package poo;

public class Empleado {
    private String nombre;

    /**
   	 * @author Sergio Ramones
   	 * @date 04/03/2021
   	 * @param N/A
   	 * 
   	 */
    public Empleado() {
    }

    /**
   	 * @author Sergio Ramones
   	 * @date 04/03/2021
   	 * @param String
   	 * 
   	 */
    public Empleado(String nombre) {
        this.nombre = nombre.toString();
        System.out.println("Constructor de Empleado " + nombre);
        System.out.println("");
    }
   
    /**
   	 * @author Sergio Ramones
   	 * @date 04/03/2021
   	 * @param N/A
   	 * @return String
   	 */
    public String getNombre() {
        return nombre;
    }
    /**
   	 * @author Sergio Ramones
   	 * @date 04/03/2021
   	 * @param N/A
   	 * @return String
   	 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
   	 * @description devuelve un String formado por la palabra “Empleado” y el nombre de empleado
   	 * @author Sergio Ramones
   	 * @date 04/03/2021
   	 * @param N/A
   	 * @return String
   	 */                             
    @Override
    public String toString() {
        return "Empleado " + nombre;
    }
}
