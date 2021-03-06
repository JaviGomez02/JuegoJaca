package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import elementos.Coordenada;
import elementos.Jugador;
import elementos.JugadorException;
import elementos.PlayerType;
import logicaJuego.Constantes;
import logicaJuego.Juego;
import logicaJuego.JuegoException;

class TestJuego {

	@Test
	public void isTerminado() throws JugadorException {
		PlayerType[] jugadores = new PlayerType[Constantes.NUM_JUGADORES];
		jugadores[0] = PlayerType.MAGO;
		jugadores[1] = PlayerType.ELFO;
		jugadores[2] = PlayerType.OGRO;
		jugadores[3] = PlayerType.GUERRERO;
		Juego j = new Juego(jugadores);
		Coordenada c = j.obtenerCoordenadaJugadorJuega();
		Jugador participante = (Jugador) j.obtenerElementoTablero​(c);
		participante.setDinero(Constantes.DINERO);

		assertTrue(j.isTerminado());
	}

	@Test
	public void isTerminadoIncorrecto() {
		PlayerType[] jugadores = new PlayerType[Constantes.NUM_JUGADORES];
		jugadores[0] = PlayerType.MAGO;
		jugadores[1] = PlayerType.ELFO;
		jugadores[2] = PlayerType.OGRO;
		jugadores[3] = PlayerType.GUERRERO;
		Juego j = new Juego(jugadores);
		assertFalse(j.isTerminado());
	}

	@Test
	public void getNextPositionN() throws JugadorException, JuegoException {
		PlayerType[] jugadores = new PlayerType[Constantes.NUM_JUGADORES];
		jugadores[0] = PlayerType.MAGO;
		jugadores[1] = PlayerType.ELFO;
		jugadores[2] = PlayerType.OGRO;
		jugadores[3] = PlayerType.GUERRERO;
		for (int i = 0; i < 10; i++) {
			Juego j = new Juego(jugadores);

			Coordenada c = j.obtenerCoordenadaJugadorJuega();
			if (c.getY() != 0) {
				j.movePlayer('N');
				c.goUp();
				assertEquals(c, j.obtenerCoordenadaJugadorJuega());
			}
		}
	}

	@Test
	public void getNextPositionS() throws JugadorException, JuegoException {
		PlayerType[] jugadores = new PlayerType[Constantes.NUM_JUGADORES];
		jugadores[0] = PlayerType.MAGO;
		jugadores[1] = PlayerType.ELFO;
		jugadores[2] = PlayerType.OGRO;
		jugadores[3] = PlayerType.GUERRERO;
		for (int i = 0; i < 10; i++) {
			Juego j = new Juego(jugadores);

			Coordenada c = j.obtenerCoordenadaJugadorJuega();
			if (c.getY() != 9) {
				j.movePlayer('S');
				c.goDown();
				assertEquals(c, j.obtenerCoordenadaJugadorJuega());
			}
		}
	}

	@Test
	public void getNextPositionE() throws JugadorException, JuegoException {// No se como comprobarlo
		PlayerType[] jugadores = new PlayerType[Constantes.NUM_JUGADORES];
		jugadores[0] = PlayerType.MAGO;
		jugadores[1] = PlayerType.ELFO;
		jugadores[2] = PlayerType.OGRO;
		jugadores[3] = PlayerType.GUERRERO;
		for (int i = 0; i < 10; i++) {
			Juego j = new Juego(jugadores);

			Coordenada c = j.obtenerCoordenadaJugadorJuega();
			if (c.getX() != 9) {
				j.movePlayer('E');
				c.goRight();
				assertEquals(c, j.obtenerCoordenadaJugadorJuega());
			}
		}
	}

	@Test
	public void getNextPositionO() throws JugadorException, JuegoException {// No se como comprobarlo
		PlayerType[] jugadores = new PlayerType[Constantes.NUM_JUGADORES];
		jugadores[0] = PlayerType.MAGO;
		jugadores[1] = PlayerType.ELFO;
		jugadores[2] = PlayerType.OGRO;
		jugadores[3] = PlayerType.GUERRERO;
		for (int i = 0; i < 10; i++) {
			Juego j = new Juego(jugadores);

			Coordenada c = j.obtenerCoordenadaJugadorJuega();
			if (c.getX() != 0) {
				j.movePlayer('O');
				c.goLeft();
				assertEquals(c, j.obtenerCoordenadaJugadorJuega());
			}
		}
	}

	@Test
	public void getNextPositionException() throws JugadorException {// No se como comprobarlo
		PlayerType[] jugadores = new PlayerType[Constantes.NUM_JUGADORES];
		jugadores[0] = PlayerType.MAGO;
		jugadores[1] = PlayerType.ELFO;
		jugadores[2] = PlayerType.OGRO;
		jugadores[3] = PlayerType.GUERRERO;

		Juego j = new Juego(jugadores);

		try {
			j.movePlayer('k');
			fail("Debe saltar la exception");
		} catch (JuegoException e) {
			System.out.println(e.getMessage());
		}
	}
}
