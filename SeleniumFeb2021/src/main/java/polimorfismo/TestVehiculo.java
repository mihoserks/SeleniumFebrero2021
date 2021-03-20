package polimorfismo;

public class TestVehiculo {

	public static void main(String[] args) {
		Vehiculo misVehiculos[] = new Vehiculo[4];
		misVehiculos[0] = new Vehiculo("GFER324","Ford","2009");
		misVehiculos[1] = new VehiculoTurismo(8,"GFT56-78","Audi","2012");
		misVehiculos[2] = new VehiculoDeportivo("GFH-45-6","Mazda","2020",8);
		misVehiculos[3] = new VehiculoFurgoneta("HJJ-30-6","Toyota","2021",8);
		
	
		
		
		
		
		
		for(Vehiculo vehiculos: misVehiculos) {
			System.out.println(vehiculos.mostrarDatos());
			System.out.println("");
		}
		
		Vehiculo vehiculodeportivo = new VehiculoDeportivo("JKH-45-6","Audi","2022",12);
		System.out.println(vehiculodeportivo.mostrarDatos());

	}

}
