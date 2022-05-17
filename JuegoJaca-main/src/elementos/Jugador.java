package elementos;

import java.util.Random;

import logicaJuego.Constantes;

public class Jugador extends Element {
	private int dinero;
	private int gemas;
	private PlayerType player;
	private int pociones;

	public Jugador(PlayerType player) {
		super(ElementType.valueOf(player.toString()));
		this.player = player;
		this.dinero = 0;
		this.gemas = 0;
		this.pociones = 0;
	}

	public String getNombre() {
		return this.player.name();
	}

	private int getFuerza() {
		return this.player.getFuerza();
	}

	public int getFuerzaParaLuchar() {
		Random r = new Random();
		return r.nextInt(this.getFuerza() + 1);
	}

	private int getMagia() {
		return this.player.getMagia();
	}

	public int getMagiaParaLuchar() {
		Random r = new Random();
		return r.nextInt(this.getMagia() + 1);
	}

	private int getVelocidad() {
		return this.player.getVelocidad();
	}

	public int getVelocidadParaLuchar() {
		Random r = new Random();
		int resultado = 0;
		while (resultado == 0) {
			resultado = r.nextInt(this.getVelocidad() + 1);
		}
		return resultado;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public int getGemas() {
		return gemas;
	}

	public void setGemas(int gemas) {
		this.gemas = gemas;
	}

	public int getPociones() {
		return pociones;
	}

	public void setPociones(int pociones) {
		this.pociones = pociones;
	}

	public String resumen() {
		return "Resumen";
	}

	public int lucha(Jugador enemigo) {
		int resultado;
		int fuerzaJugador = this.getFuerzaParaLuchar();
		int fuerzaEnemigo = this.getFuerzaParaLuchar();

		if (fuerzaJugador > fuerzaEnemigo) {
			if (enemigo.getPociones() >= 1) {
				enemigo.pociones -= 1;
				resultado = Constantes.GANA_USA_POCIMA;
			} else if (enemigo.getDinero() >= 1) {
				this.setDinero(this.getDinero() + enemigo.getDinero());
				enemigo.setDinero(0);
				resultado = Constantes.GANA_DINERO;
			} else {
				resultado = Constantes.GANA_MUERE;
			}
		} else if (fuerzaJugador < fuerzaEnemigo) {
			if (this.getPociones() >= 1) {
				this.pociones -= 1;
				resultado = Constantes.PIERDE_USA_POCIMA;
			} else if (this.getDinero() >= 1) {
				enemigo.setDinero(enemigo.getDinero() + this.getDinero());
				this.setDinero(0);
				resultado = Constantes.PIERDE_DINERO;
			} else {
				resultado = Constantes.PIERDE_MUERE;
			}

		} else {
			resultado = Constantes.EMPATE;
		}

		return resultado;
	}

	public int encuentraRoca() {
		int resultado;
		int magiaJugador = this.getMagiaParaLuchar();
		if (this.getGemas() >= 1) {
			this.gemas -= 1;
			resultado = Constantes.ROMPE_ROCA_CON_GEMA;
		} else {
			if (magiaJugador >= 4) {
				resultado = Constantes.GANA_A_LA_ROCA;
			} else {
				resultado = Constantes.PIERDE_A_LA_ROCA;
			}
		}
		return resultado;
	}

	public PlayerType getPlayer() {
		return player;
	}

	public void encuentraDinero() {
		this.dinero += 1;
	}

	public void encuentraPocion() {
		this.pociones += 1;
	}

	public void encuentraGema() {
		this.gemas += 1;
	}

}