package application.utiles.mru;

public enum ValoresMRU {

	DISTANCIA("Distancia"),
	TIEMPO("Tiempo"),
	POSI("Posicion inicial"),
	VELOCIDAD("Velocidad");
	
	private String nombre;
	
	ValoresMRU(String nombre){
		this.nombre = nombre;
	}
	
	
	public String getNombre() {
		return nombre;
	}
}
