package application.fisica;

public class Movil {

	private float posicion, velocidad;
	
	private MRU mru = new MRU();
	
	
	public Movil() {
		this.posicion = 0;
		this.velocidad = 0;
	}
	
	
	public Movil(float velocidad) {
		this.posicion = 0;
		this.velocidad = velocidad;
	}
	
	public Movil (float velocidad, float posicion) {
		this.posicion = posicion;
		this.velocidad = velocidad;
	}
	
	
	public float getVelocidad() {
		return velocidad;
	}
	
	public float getPosicion() {
		return posicion;
	}
	
	public void calcularPosicion(float v, float t) {
		posicion = mru.calcularPosicion(v, t);
	}
	
	
	public void calcularPosicion(float posI, float v, float t) {
		posicion = mru.calcularPosicion(posI, v, t);
	}
	
	public void calcularVelocidad(float d, float t) {
		velocidad = mru.calcularVelocidad(d, t);
	}
	
	
}
