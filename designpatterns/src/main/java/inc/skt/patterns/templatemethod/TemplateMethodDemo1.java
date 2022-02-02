package inc.skt.patterns.templatemethod;

import java.util.Random;

public class TemplateMethodDemo1 {

	public static void main(String[] args) {
		
		Game game = new Ludo(4, 200);
		game.run();
	}
}

abstract class Game {

	int numOfPlayers;
	int currentPlayer;

	public Game(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}

	public void run() {
		start();
		while (!haveWinner()) {
			keepPlaying();
		}
		System.out.println("<===== Player " + getWinner() + " won =====>");
	}

	protected abstract void start();

	protected abstract boolean haveWinner();

	protected abstract void keepPlaying();

	protected abstract int getWinner();

}

class Ludo extends Game {

	private int maxSteps;
	private int steps;

	public Ludo(int numOfPlayers, int maxSteps) {
		super(numOfPlayers);
		this.maxSteps = maxSteps;
	}

	@Override
	protected void start() {
		System.out.println("Starting Rummy ....");
	}

	@Override
	protected boolean haveWinner() {
		return steps == maxSteps;
	}

	@Override
	protected void keepPlaying() {
		currentPlayer = new Random().nextInt(4)+ 1;
		System.out.println("Player " + currentPlayer + " moved " + ++steps + " steps");
	}

	@Override
	protected int getWinner() {
		return currentPlayer;
	}

}