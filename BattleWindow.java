import java.awt.Component;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BattleWindow {

	private JFrame battleWindowFrame;
	private static Villain villain;
	private static String currentGame;
	private JLabel gameLabel = new JLabel();
	
	
	/**
	 * Launch the application.
	 */
	public static void NewScreen(Villain villainInput) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleWindow window = new BattleWindow(villainInput);
					window.battleWindowFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public String getVillain () {
		return villain.getName();
	}
	
	public static String getGame() {
		ArrayList<String> villainsGames = new ArrayList<String>();
		villainsGames = villain.getGames();
		System.out.println(villainsGames);
		Collections.shuffle(villainsGames);
		System.out.println(villainsGames);
		return villainsGames.get(0);		
	}


	/**
	 * Create the application.
	 * @param villain 
	 */

	public BattleWindow(Villain villainInput) {
		villain = villainInput;
		initialize();
	}
	public void changeGame() {
		currentGame = getGame();
		gameLabel.setText(currentGame);
		
	}
	public void openCurrrentGame(Hero heroPlaying) {
		System.out.println(this.getVillain());
		if (currentGame == "paper scissors rock") {
			PaperScissorsRockGUI.NewScreen(villain, heroPlaying, this);
		} else if (currentGame == "guess a number") {
			GuessNumberGUI.NewScreen(villain, heroPlaying, this);
		} else if (currentGame == "Dice game") {
			DiceGameGUI.NewScreen(villain, heroPlaying, this);
		}
	}
	/**
	 * Initialize the contents of the frame.
	 * @param villain 
	 */
	private void initialize() {
		
		battleWindowFrame = new JFrame();
		battleWindowFrame.setBounds(100, 100, 724, 417);
		battleWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		battleWindowFrame.getContentPane().setLayout(null);
		
		//PaperScissorsRockGUI paperScissorsRockGameGui = new PaperScissorsRockGUI();
		changeGame();
		Hero heroPlaying;
		
		JLabel lblTaunt = new JLabel(villain.getTaunt());
		lblTaunt.setBounds(175, 60, 341, 22);
		battleWindowFrame.getContentPane().add(lblTaunt);
		
		JLabel lblName = new JLabel(villain.getName());
		lblName.setBounds(165, 28, 341, 22);
		battleWindowFrame.getContentPane().add(lblName);
		
		JComboBox heroSelection = new JComboBox(Team.getHeroNames());
		heroSelection.setBounds(267, 108, 161, 29);
		battleWindowFrame.getContentPane().add(heroSelection);
		
		heroPlaying = Team.getHeroes().get(heroSelection.getSelectedIndex());
		
		JLabel lblSelectAHero = new JLabel("Select a hero to battle!");
		lblSelectAHero.setBounds(31, 115, 195, 22);
		battleWindowFrame.getContentPane().add(lblSelectAHero);
		
		JLabel lblIChallengeYou = new JLabel("The villain challenges you to: ");
		lblIChallengeYou.setBounds(31, 175, 222, 22);
		battleWindowFrame.getContentPane().add(lblIChallengeYou);
		
		
		gameLabel.setBounds(267, 209, 175, 15);
		battleWindowFrame.getContentPane().add(gameLabel);
		
		JButton fightButton = new JButton("Fight");
		fightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openCurrrentGame(heroPlaying);
			}
		});
		fightButton.setBounds(277, 275, 117, 25);
		battleWindowFrame.getContentPane().add(fightButton);
	}

	public void villainDies() {
		// TODO Auto-generated method stub
		CityGUI.CityScreen.dispose();
		GameEnvironment.moveToNewCity();
		
	}
}
