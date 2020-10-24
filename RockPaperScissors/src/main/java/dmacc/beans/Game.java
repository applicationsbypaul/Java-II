package dmacc.beans;

import java.util.Random;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Game {
	private String player1;
	private String computerPlayer;
	private String winner;

	public Game(String player1) {
		super();
		this.player1 = player1;
		this.setComputerPlayerToRandom();
		this.determineWinner();
	}

	private void determineWinner() {
		if (getPlayer1().contentEquals("rock")){
			if (getComputerPlayer().contentEquals("rock")) {
				setWinner("TIE");
			} else if(getComputerPlayer().contentEquals("paper")) {
				setWinner("Computer Player");
			} else if(getComputerPlayer().contentEquals("scissors")){
				setWinner("Player 1");
			} else if(getComputerPlayer().contentEquals("lizard")) {
				setWinner("Player 1");
			}else {
				setWinner("Computer Player");
			}
		} else if (getPlayer1().contentEquals("paper")) {
			if (getComputerPlayer().contentEquals("rock")) {
				setWinner("Player 1");
			} else if(getComputerPlayer().contentEquals("paper")) {
				setWinner("TIE");
			} else if(getComputerPlayer().contentEquals("scissors")){
				setWinner("Computer Player");
			} else if(getComputerPlayer().contentEquals("lizard")) {
				setWinner("Computer Player");
			}else {
				setWinner("Player 1");
			}
		} else if (getPlayer1().contentEquals("scissors")) {
			if (getComputerPlayer().contentEquals("rock")) {
				setWinner("Computer Player");
			} else if(getComputerPlayer().contentEquals("paper")) {
				setWinner("Player 1");
			} else if(getComputerPlayer().contentEquals("scissors")){
				setWinner("TIE");
			} else if(getComputerPlayer().contentEquals("lizard")) {
				setWinner("Player 1");
			}else {
				setWinner("Computer Player");
			}
		} else if (getPlayer1().contentEquals("lizard")) {
			if (getComputerPlayer().contentEquals("rock")) {
				setWinner("Computer Player");
			} else if(getComputerPlayer().contentEquals("paper")) {
				setWinner("Player 1");
			} else if(getComputerPlayer().contentEquals("scissors")){
				setWinner("Computer Player");
			} else if(getComputerPlayer().contentEquals("lizard")) {
				setWinner("TIE");
			}else {
				setWinner("Player 1");
			}
		} else {
			if (getComputerPlayer().contentEquals("rock")) {
				setWinner("Player 1");
			} else if(getComputerPlayer().contentEquals("paper")) {
				setWinner("Computer Player");
			} else if(getComputerPlayer().contentEquals("scissors")){
				setWinner("Player 1");
			} else if(getComputerPlayer().contentEquals("lizard")) {
				setWinner("Computer Player");
			}else {
				setWinner("TIE");
			}
		}
	}
	
	/**
	 * This method will set the computer player to either
	 * rock, paper, or scissors.
	 */
	private void setComputerPlayerToRandom() {
		Random rand = new Random();
		int randomSelection = rand.nextInt(5);
		
		if (randomSelection == 0) {
			this.computerPlayer = "rock";
		}else if (randomSelection == 1) {
			this.computerPlayer = "paper";
		}else if (randomSelection == 2){
			this.computerPlayer = "scissors";
		}else if (randomSelection == 3) {
			this.computerPlayer = "lizard";
		}else {
			this.computerPlayer = "spock";
		}
	}
}
