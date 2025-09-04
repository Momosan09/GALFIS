package application.fisica;

public class MRU {

	/**
	 * Calcula la posicion en MRU con la velocidad y el tiempo partiendo desde el origen
	 * @param v, la velocidad en m/s
	 * @param t, el tiempo en s
	 * @return una poscion
	 */
	public float calcularPosicion(float v, float t) {
		float posI = 0;
		return  posI + (v * t);
	}
	
	/**
	 * Calcula la posicion en MRU con la velocidad y el tiempo partiendo desde el origen
	 * @param d0, la posicion inicial
	 * @param v, la velocidad en m/s
	 * @param t, el tiempo en s
	 * @return una poscion
	 */
	public float calcularPosicion(float d0, float v, float t) {
		return  d0 + (v * t);
	}
	
	/**
	 * Calcula el momento del encuentro entre dos moviles
	 * @param m1, El movil 1
	 * @param m2, El Movil 2
	 * @return
	 */
	public float calcularMomentoDeEncuentro(Movil m1, Movil m2) {
		float resultado = (m1.getPosicion() - m2.getPosicion()) / (m1.getVelocidad() - m2.getVelocidad());
		if(resultado < 0) {
			resultado *=-1;
		}
		return resultado;
	}
	
	public float calcularPuntoDeEncuentro(Movil m1, Movil m2) {
		float tiempo = calcularMomentoDeEncuentro(m1, m2);//Primero calculamos cuanto tarda en "chocar" los dos moviles
		m1.calcularPosicion(m1.getPosicion(),m1.getVelocidad(), tiempo);
		return m1.getPosicion();
	}
	
	
	/**
	 * Calcula la velocidad de un movil
	 * @param d, distancia recorrida
	 * @param t, tiempo que tardo en recorrer esa distancia
	 * @return velocidad en m/s
	 */
	public float calcularVelocidad(float d, float t) {
		return d/t;
	}
	
	public float calcularTiempo(float d, float v) {
		float t = d/v;
		return t;
	}
	
}
