package poo;

public class Cuenta {
	
	private String nombre;
	private String numeroCuenta;
	private double tipoInteres;
	private double saldo;
	
	/**
	 * @author Sergio Ramones
	 * @date 06/03/2021
	 * @param N/A
	 * **/
	public Cuenta() {
		
	}//end Cuenta sin pareametros
	
	/**
	 * @author Sergio Ramones
	 * @date 06/03/2021
	 * @param String String double double
	 * **/				
	public Cuenta(String nombre, String numeroCuenta, double tipoInteres, double saldo) {
		this.nombre=nombre;
		this.numeroCuenta = numeroCuenta;
		this.tipoInteres = tipoInteres;
		this.saldo = saldo;
	}//end cuenta muchos parametros
	
	/**
	 * @author Sergio Ramones
	 * @date 06/03/2021
	 * @param Object
	 * **/	
	public Cuenta(Cuenta c) {
		nombre = c.nombre; 
		numeroCuenta = c.numeroCuenta;
		tipoInteres = c.tipoInteres;
		saldo = c.saldo;
	}//end cuenta objecto
	
	/**
	 * @author Sergio Ramones
	 * @date 06/03/2021
	 * @param String
	 * **/
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @author Sergio Ramones
	 * @date 06/03/2021
	 * @param String
	 * **/
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	/**
	 * @author Sergio Ramones
	 * @date 06/03/2021
	 * @param double
	 * **/
	public void setTipoInteres(double tipoInteres) {
		this.tipoInteres = tipoInteres;
	}
	/**
	 * @author Sergio Ramones
	 * @date 06/03/2021
	 * @param double
	 * **/
	public void setSaldo(double saldo) {
		this.saldo=saldo;
	}
	
	/**
	 * @author Sergio Ramones
	 * @date 06/03/2021
	 * @param N/A
	 * @return String
	 * **/
	public String getNombre() {
		return this.nombre;
	}
	
	/**
	 * @author Sergio Ramones
	 * @date 06/03/2021
	 * @param N/A
	 * @return String
	 * **/
	public String getNumeroCuenta() {
		return this.numeroCuenta;
	}
	/**
	 * @author Sergio Ramones
	 * @date 06/03/2021
	 * @param N/A
	 * @return double
	 * **/
	public double getTipoInteres() {
		return this.tipoInteres;
	}
	/**
	 * @author Sergio Ramones
	 * @date 06/03/2021
	 * @param N/A
	 * @return double
	 * **/
	public double getSaldo() {
		return this.saldo;
	}
	
	/**
	 * @author Sergio Ramones
	 * @date 06/03/2021
	 * @param N/A
	 * @return double
	 **/
	public boolean ingreso(double n) {
		boolean ingresoCorrecto = true;

		if (n < 0) {
			ingresoCorrecto = false;
		} else {
			saldo = saldo + n;
		}

		return ingresoCorrecto;
	}
	
	/**
	 * @author Sergio Ramones
	 * @date 06/03/2021
	 * @param N/A
	 * @return double
	 **/
	public boolean reintegro(double n) {
		boolean reintregroCorrecto = true;
		if (n < 0) {
			reintregroCorrecto = false;
		} else if (saldo >= n) {
			// saldo=saldo-n;
			saldo -= n;
		} else {
			reintregroCorrecto = false;
		}

		return reintregroCorrecto;
	}
	
	/**
	 * @author Sergio Ramones
	 * @date 06/03/2021
	 * @param N/A
	 * @return Object double
	 **/
	public boolean trasferencia(Cuenta c, double n) {
		boolean correcto = true;
		if (n < 0) {
			correcto = false;
		} else if (saldo >= n) {
			reintegro(n);
			c.ingreso(n);
		} else {
			correcto = false;
		}

		return correcto;
	}
	
}//end class
