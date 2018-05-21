import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GameEnvironment {
	private String teamName;
	private int numberCities;
	private ArrayList<Villain> villains = new ArrayList<Villain>();
	private ArrayList<CityGUI> cities = new ArrayList<CityGUI>();
	private int currentCityIndex = -1;
	private final int MAXNUMBERCITIES = 6;
	private Team team;
	private CityGUI currentCity;

	public ArrayList<Villain> getVillains() {
		return villains;
	}
	
	public void setTeamName(String inputName) {
		teamName = inputName;
	}
	public void setNumberCities(int inputNumberCities) {
		numberCities = inputNumberCities;
	}
	public String getTeamName() {
		return teamName;
	}
	public int getCurrentCityIndex() {
		if (currentCityIndex == numberCities - 1)
			return - 1; //We now at the last city with the supervillain
		else
			return currentCityIndex;
	}
	public CityGUI getCurrentCity() {
		return currentCity;
	}
	public ArrayList<CityGUI> getCityList() {
		return cities;
	}
	public int getNumberCities() {
		return cities.size();
	}
	
	public String[] getVillainNames() {
		String[] heroNames = new String[villains.size()];
		for (int i = 0; i < villains.size(); i++) {
			heroNames[i] = villains.get(i).getName();
		}
		return heroNames;
	}
	
	public void endGame() {
		//BattleWindow.closeWindow();
		
	}
	
	private void makeVillains() {
		ArrayList<String> games1 = new ArrayList<String>();
		ArrayList<String> games2 = new ArrayList<String>();
		ArrayList<String> games3 = new ArrayList<String>();
		ArrayList<String> games4 = new ArrayList<String>();
		ArrayList<String> games5 = new ArrayList<String>();
		ArrayList<String> games6 = new ArrayList<String>();
		games1.add("paper scissors rock");
		games1.add("guess a number");
		games1.add("Dice game");
		games2.add("guess a number");
		games2.add("paper scissors rock");
		games2.add("guess a number");
		Villain villain1 = new Villain("come here boa", games1, "villain one", 100);
		Villain villain2 = new Villain("oy m8 you wont", games1, "villain two", 50);
		Villain villain3 = new Villain("you a bitch", games1, "villain three", 70);
		Villain villain4 = new Villain("ohh whats that", games1, "villain four", 70);
		Villain villain5 = new Villain("im da bomd you not", games1, "villain five", 70);
		Villain superVillain = new Villain("you a big fat nob", games1, "Super", 70);
		villains.add(villain1);
		villains.add(villain2);
		villains.add(villain3);
		villains.add(villain4);
		villains.add(villain5);
		Collections.shuffle(villains);
		villains.add(superVillain);
	}
	
	public Villain getVillain(int index) {
		return villains.get(index);
	}
	
	public static void main(String[] args) {
		GameEnvironment gameEnvironment = new GameEnvironment();
		gameEnvironment.makeVillains();
		gameEnvironment.team = new Team(gameEnvironment);
		//for (int i = 0; i < gameEnvironment.MAXNUMBERCITIES; i++) {
			//gameEnvironment.cities.add(gameEnvironment.makeCity(gameEnvironment, gameEnvironment.team));
		//}
		
		GameSetupGUI.NewScreen(gameEnvironment, gameEnvironment.team); //start the game already
	}

	
	public void moveToNewCity(Team teamInput) {
		currentCityIndex++; // surely this should be iterated before instantiating city
		CityGUI cityGui = new CityGUI(teamInput, this);
		currentCity = cityGui;
		cityGui.NewScreen(teamInput, this);
	}
	
	public Team getTeam() {
		return team;
	}
	public void openShopScreen(Team team, CityGUI cityGui) {
		ShopGUI shopGui = new ShopGUI(team, this, cityGui);
		shopGui.NewScreen(team, this, cityGui);
	} 
	public void openPowerUpDenScreen(Team team, CityGUI cityGui) {
		PowerUpDenGUI powerUpDenGui = new PowerUpDenGUI(team, this, cityGui);
		powerUpDenGui.NewScreen(team, this, cityGui);
	}
	public void openHospitalScreen(Team team, CityGUI cityGui) {
		HospitalGUI hospitalGui = new HospitalGUI(team, this, cityGui);
		hospitalGui.NewScreen(team, this, cityGui);
	}
	public void openLairScreen(Team team, CityGUI cityGui) {
		LairGUI lair = new LairGUI(team, this, cityGui);
		lair.NewScreen(team, this, cityGui);
	}
	public void openBattleWindow(Team team, CityGUI cityGui) {
		BattleWindow battleWindow = new BattleWindow(team, this, cityGui);
		battleWindow.NewScreen(team, this, cityGui);
	}
	public void openGuessNumberGUI(Hero heroPlaying, BattleWindow battleWindow, GameEnvironment gameEnvironmentInput) {
		GuessNumberGUI guessNumberGui = new GuessNumberGUI(heroPlaying, battleWindow, gameEnvironmentInput);
		guessNumberGui.NewScreen(heroPlaying, battleWindow, gameEnvironmentInput);
	}
	
	public void openPaperScissorsRockGUI(Hero heroPlaying, BattleWindow battleWindow, GameEnvironment gameEnvironmentInput) {
		PaperScissorsRockGUI paperScissorsRockGui = new PaperScissorsRockGUI(heroPlaying, battleWindow, gameEnvironmentInput);
		paperScissorsRockGui.NewScreen(heroPlaying, battleWindow, gameEnvironmentInput);
	}
	
	public void openDiceGameGUI(Hero heroPlaying, BattleWindow battleWindow, GameEnvironment gameEnvironmentInput) {
		DiceGameGUI diceGameGui = new DiceGameGUI(heroPlaying, battleWindow, gameEnvironmentInput);
		diceGameGui.NewScreen(heroPlaying, battleWindow, gameEnvironmentInput);
	}
	
	public List<HealingItem> getHealingItemsList() {
		List<HealingItem> healingItems = new ArrayList<HealingItem>();
		HealingItem smallPotion = new HealingItem(10, 10, 5, "Small Potion");
		HealingItem quickPotion = new HealingItem(25, 10, 2, "Quick Potion");
		HealingItem bigPotion = new HealingItem(40, 20, 10, "Big Potion");
		healingItems.add(smallPotion);
		healingItems.add(quickPotion);
		healingItems.add(bigPotion);
		return healingItems;
	}
	public List<PowerUp> getPowerUpsList() {
		List<PowerUp> powerUps = new ArrayList<PowerUp>();
		PowerUp extraRoll = new PowerUp(30, "Extra Roll");
		PowerUp extraGuess = new PowerUp(50, "Extra Guess");
		PowerUp paperScissorsRockClue = new PowerUp(50, "Clue for Paper Scissors Rock");
		powerUps.add(paperScissorsRockClue);
		powerUps.add(extraGuess);
		powerUps.add(extraRoll);
		return powerUps;
	}

	
}