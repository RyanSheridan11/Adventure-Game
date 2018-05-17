import java.util.ArrayList;

public class Villain {
	private String taunt;
	private ArrayList<String> games;
	private String name;
	private int damage;
	private int lives = 3;
	//Might need boolean for supervillain
	
	public String getTaunt() {
		return taunt;
	}
	public String getName() {
		return name;
	}
	public ArrayList<String> getGames() {
		return games;
	}
	
	public void loseLife() {
		lives--;
	}
	public int getLives() {
		return lives;
	}
	public int getDamage() {
		return damage;
	}
	
	public Villain(String inputTaunt, ArrayList<String> inputGames, String inputName, int inputDamage) {
		taunt = inputTaunt;
		games = inputGames;
		name = inputName;
		damage = inputDamage;
	}
}
