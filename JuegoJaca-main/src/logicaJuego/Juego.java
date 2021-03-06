package logicaJuego;

import java.util.ArrayList;
import java.util.HashMap;

import elementos.*;

public class Juego {

	private HashMap<Coordenada, Element> tablero;
	private ArrayList<Coordenada> coordenadaJugadores;
	private int jugadorJuega;
	private int dado; // Dado para ver los movimientos del jugador que juega

	public Juego(PlayerType[] jugadores) {
		tablero = new HashMap<>();
		coordenadaJugadores = new ArrayList<>();
		for (int i = 0; i < Constantes.NUM_JUGADORES; i++) {
			crearJugador(jugadores[i]);
		}
		crearTablero();
	}

	/**
	 * Escribe el tablero en formato no grÃ¡fico. Devuelve el string con la
	 * informaciÃ³n
	 */

	private void crearDinero() {
		int contador = 0;
		while (contador < Constantes.DINERO) {
			Coordenada c = new Coordenada();
			Element e = new Element(ElementType.DINERO);
			if (!tablero.containsKey(c)) {
				this.tablero.put(c, e);
				contador += 1;
			}
		}
	}

	private void crearPociones() {
		int contador = 0;
		while (contador < Constantes.NUM_POCIONES) {
			Coordenada c = new Coordenada();
			Element e = new Element(ElementType.POCION);
			if (!tablero.containsKey(c)) {
				this.tablero.put(c, e);
				contador += 1;
			}
		}
	}

	private void crearGemas() {
		int contador = 0;
		while (contador < Constantes.NUM_GEMAS) {
			Coordenada c = new Coordenada();
			Element e = new Element(ElementType.GEMA);

			if (!tablero.containsKey(c)) {
				this.tablero.put(c, e);
				contador += 1;
			}
		}
	}

	private void crearRocas() {
		int contador = 0;
		while (contador < Constantes.NUM_ROCAS) {
			Coordenada c = new Coordenada();
			Element e = new Element(ElementType.ROCA);
			if (!tablero.containsKey(c)) {
				this.tablero.put(c, e);
				contador++;
			}
		}
	}

	private boolean crearJugador(PlayerType tipo) {
		Jugador j = new Jugador(tipo);
		Coordenada c = new Coordenada();
		while (coordenadaJugadores.contains(c)) {
			c = new Coordenada();
		}

		coordenadaJugadores.add(c);
		tablero.put(c, j);
		return true;
	}

	private void crearTablero() {
		crearDinero();
		crearGemas();
		crearPociones();
		crearRocas();
	}

	public boolean isTerminado() {
		boolean resultado = false;
		if (coordenadaJugadores.size() == 1) {
			resultado = true;
		}
		for (Element e : this.tablero.values()) {
			if (e instanceof Jugador j && j.getDinero() == Constantes.DINERO) {
				resultado = true;
			}
		}
		return resultado;
	}

	public String imprimeNombreJugadores() {
		StringBuilder resultado = new StringBuilder("");
		int contador = 1;
		for (Element e : this.tablero.values()) {
			if (e instanceof Jugador j) {
				resultado.append("El jugador " + contador + " es un " + j.getNombre() + "\n");
				contador++;
			}
		}
		return resultado.toString();
	}

	public String imprimeValoreJugadores() {
		StringBuilder resultado = new StringBuilder("");
		for (Element e : this.tablero.values()) {
			if (e instanceof Jugador j) {
				resultado.append("El " + j.getNombre() + " tiene " + j.getDinero() + " de dinero, " + j.getPociones()
						+ " pociones y " + j.getGemas() + " gemas.\n");
			}
		}
		return resultado.toString();
	}

	private void eliminarJugador​(Coordenada coord) {
		this.tablero.remove(coord);
		this.coordenadaJugadores.remove(coord);
	}

	private Coordenada getNextPosition​(char direction) throws JuegoException {

		Coordenada c = this.coordenadaJugadores.get(jugadorJuega).clonar();
		if (direction == 'N') {
			c.goUp();
		} else if (direction == 'S') {
			c.goDown();
		} else if (direction == 'E') {
			c.goRight();
		} else if (direction == 'O') {
			c.goLeft();
		} else {
			throw new JuegoException("Coordenadas incorrectas");
		}
		return c;

	}

	private void cambiaJugadorPosicion​(Coordenada coord) {
		Coordenada c = this.coordenadaJugadores.get(jugadorJuega);
		Jugador j = (Jugador) this.tablero.get(c);
		tablero.remove(c);
		tablero.put(coord, j);
		this.coordenadaJugadores.remove(jugadorJuega);
		this.coordenadaJugadores.add(jugadorJuega, coord);
	}

	public void proximoJugador() {
		if (this.jugadorJuega == this.coordenadaJugadores.size() - 1) {
			this.jugadorJuega = 0;
		} else {
			this.jugadorJuega += 1;
		}
	}

	public String getGanador() {
		String resultado = "No hay ganador";
		if (this.coordenadaJugadores.size() == 1) {
			Jugador j = (Jugador) tablero.get(coordenadaJugadores.get(jugadorJuega));
			resultado = j.toString();
		}
		for (Element e : tablero.values()) {
			if (e instanceof Jugador j && j.getDinero() == Constantes.DINERO) {
				resultado = j.toString();
			}
		}

		return resultado;

	}

	public String getNombreJuegadorQueJuega() {
		Jugador j = (Jugador) tablero.get(coordenadaJugadores.get(jugadorJuega));
		return j.getNombre();
	}

	public int getMovimientoJugador() {
		Jugador j = (Jugador) tablero.get(coordenadaJugadores.get(jugadorJuega));
		return j.getVelocidadParaLuchar();
	}

	public int getValorDado() {
		return dado;
	}

	public void decrementaDado() {
		dado -= 1;
	}

	public void setDado() {
		dado = this.getMovimientoJugador();
	}

	public Element obtenerElementoTablero​(Coordenada coord) {
		return this.tablero.get(coord);
	}

	public Coordenada obtenerCoordenadaJugadorJuega() {
		return this.coordenadaJugadores.get(jugadorJuega);
	}

	@Override
	public String toString() {
		StringBuilder resul = new StringBuilder();
		resul.append(barra());
		resul.append("     |");

		for (int fila = 0; fila < Constantes.TAMANNO; fila++) {
			for (int columna = 0; columna < Constantes.TAMANNO; columna++) {
				Coordenada coor = new Coordenada(columna, fila);

				if (this.tablero.get(coor) != null) {
					resul.append(" " + this.tablero.get(coor).getType().getSymbol() + " ");
				} else {
					resul.append("   ");
				}

				resul.append("|");
			}
			resul.append("\n");
			resul.append(barra());
			resul.append("     |");
		}
		resul.delete(resul.length() - 5, resul.length());
		return resul.toString();
	}

	/**
	 * Simplemente escribe una barra en pantalla
	 * 
	 * @return
	 */
	private String barra() {
		StringBuilder resul = new StringBuilder();
		resul.append("     ");
		for (int i = 0; i < Constantes.TAMANNO * 4; i++) {
			resul.append("-");
		}
		resul.append("\n");
		return resul.toString();
	}

	/**
	 * Mover el jugador
	 * 
	 * @param direction
	 * @return
	 * @throws JuegoException
	 * @throws JugadorException
	 */
	public String movePlayer(char direction) throws JuegoException, JugadorException {
		// Si no es una direcciÃ³n vÃ¡lida, mando un exception
		String resul = "";
		Jugador jugador = (Jugador) this.tablero.get(this.coordenadaJugadores.get(jugadorJuega));

		Coordenada coordDestino = getNextPosition​(direction);

		// Tengo que ver que hay en la nueva casilla
		Element elemento = this.tablero.get(coordDestino);

		if (elemento != null) { // Hay algo en la casilla
			if (elemento instanceof Jugador) {

				Jugador enemigo = (Jugador) elemento;
				int resultadoLucha = jugador.lucha(enemigo);
				switch (resultadoLucha) {
				case Constantes.EMPATE:
					resul = "Empate entre los jugadore";
					break;
				case Constantes.GANA_USA_POCIMA:
					resul = "El jugador " + jugador.getNombre() + " gana. Le quita una pÃ³cima al enemigo";
					break;
				case Constantes.GANA_DINERO:
					resul = "El jugador " + jugador.getNombre() + " gana. Le quita el dinero al enemigo";
					break;
				case Constantes.GANA_MUERE:
					resul = "El jugador " + jugador.getNombre() + " gana. El enemigo muere";
					this.eliminarJugador​(coordDestino);
					// Si se elimina el jugador que juega el dado se pone a 0 para que no siga
					// tirando
					break;
				case Constantes.PIERDE_USA_POCIMA:
					resul = "El enemigo " + enemigo.getNombre() + " gana. Le quita una pÃ³cima al jugador";
					break;
				case Constantes.PIERDE_DINERO:
					resul = "El enemigo " + enemigo.getNombre() + " gana. Le quita el dinero al jugador";
					break;
				case Constantes.PIERDE_MUERE:
					resul = "El enemigo " + enemigo.getNombre() + " gana. El jugador muere";
					this.eliminarJugador​(this.coordenadaJugadores.get(jugadorJuega));
					dado = 0;
					// Decrementamos en uno el jugador, para que no se salte al siguiente
					// ya que al borrarlo el siguiente apunta al siguiente, y al incrementarlo
					// se le salta
					this.jugadorJuega--;
					break;
				}
				// DespuÃ©s de la lucha los jugadores no se mueven
			} else if (elemento.getType() == ElementType.ROCA) {
				int resultadoRoca = jugador.encuentraRoca();
				switch (resultadoRoca) {
				case Constantes.ROMPE_ROCA_CON_GEMA:
					resul = "El jugador " + jugador.getNombre() + " rompe la roca con una gema";
					this.cambiaJugadorPosicion​(coordDestino);
					break;

				case Constantes.GANA_A_LA_ROCA:
					resul = "El jugador " + jugador.getNombre() + " gana a la roca";
					this.cambiaJugadorPosicion​(coordDestino);
					break;

				case Constantes.PIERDE_A_LA_ROCA:
					resul = "El jugador " + jugador.getNombre() + " pierde. No se mueve";
					break;
				}
			} else if (elemento.getType() == ElementType.GEMA) {
				jugador.encuentraGema();
				this.cambiaJugadorPosicion​(coordDestino);

			} else if (elemento.getType() == ElementType.DINERO) {
				jugador.encuentraDinero();
				this.cambiaJugadorPosicion​(coordDestino);

			} else if (elemento.getType() == ElementType.POCION) {
				jugador.encuentraPocion();
				this.cambiaJugadorPosicion​(coordDestino);

			}

		} else {
			this.cambiaJugadorPosicion​(coordDestino);
		}

		return resul;
	}

}
