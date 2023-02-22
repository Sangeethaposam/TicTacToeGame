package com.bridzelabz.Workshop;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {

	static  char[] arr = {49,50,51,52,53,54,55,56,57,58};
	static int turn=2;
	static  int num;
	static int count = 0 ;
	static char player = 'A';
	static  char comp = 'A';
	public static void main(String[] args) {
		System.out.println("Welcome in tic tac toe ");
		createEmptyBoard();
		allowPlayer();
	}
	public static void createEmptyBoard(){

		System.out.println(" ____");
		for (int i = 1; i <= 9; i++){
			System.out.print("|_");
			if (i % 3 == 0) {
				System.out.println("|");
			}
		}
	}
	public static void allowPlayer(){
		System.out.println("Enter your choice if wont 'X' then press 1 & if you wont 'O' then press 2");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		if ( choice == 1){
			System.out.println(" player => x");
			System.out.println("Computer => O");
			player='X';
			comp='O';
		} else if (choice == 2) {
			System.out.println(" player => O");
			System.out.println("Computer => X");
			player='O';
			comp='X';
		}
		whoPlayFirst();
		while(turn!=15) {
			makeMove(player, comp);
		}
	}
	public static void showBoard(){

		System.out.println(" ____");
		for (int i = 1; i <= 9; i++){
			System.out.print("|"+arr[i-1]+"");
			if (i % 3 == 0) {
				System.out.println("|");
			}
		}
	}
	public static void makeMove(char player,char comp){
		Scanner sc = new Scanner(System.in);
		// This is player logic
		if ( turn%2==0){
			System.out.println(" player enter your position number in between 1 to 9 ");
			int num = sc.nextInt();
			if(arr[num-1]=='X' || arr[num-1]=='O'){
				System.out.println("This position is not empty");
			}else {
				checkDuplicate(num-1,player);
			}
		}
		//this is computer logic
		else {
			Random random = new Random();
			num = random.nextInt(9) + 1;
			if(arr[num-1]=='X' || arr[num-1]=='O') {
				
			}else {
				// check and win computer
				if (arr[1] == 'O' && arr[2]=='O' && arr[0]!='X' || arr[3]=='O'&& arr[6]=='O' && arr[0]!='X'
						|| arr[4]=='O' && arr[8]=='O'&& arr[0]!='X') {
					checkDuplicate(0,comp);
				}
				else if (arr[0] == 'O'&& arr[2]=='O' && arr[1]!='X'|| arr[4]=='O' && arr[7]=='O'&& arr[1]!='X'){
					checkDuplicate(1,comp);
				}else if (arr[0] == 'O'&& arr[1]=='O'&& arr[2]!='X' || arr[4]=='O'&& arr[6]=='O' && arr[2]!='X'
						|| arr[5]=='O' && arr[8]=='O'&& arr[2]!='X') {
					checkDuplicate(2,comp);
				}
				else if (arr[0] == 'O'&& arr[6]=='O'&& arr[3]!='X'|| arr[4] == 'O'&& arr[5]=='O'&& arr[3]!='X' ) {
					checkDuplicate(3,comp);
				}else if (arr[3] == 'O'&& arr[5]=='O' && arr[4]!='X' || arr[1] == 'O'&& arr[7]=='O' && arr[4]!='X'
						|| arr[0] == 'O'&& arr[8]=='O' && arr[4]!='X' || arr[2] == 'O'&& arr[6]=='O'&& arr[4]!='X') {
					checkDuplicate(4,comp);
				}else if (arr[2] == 'O'&& arr[8]=='O' && arr[5]!='X' || arr[3] == 'O'&& arr[4]=='O' && arr[5]!='X') {
					checkDuplicate(5,comp);
				}else if (arr[0] == 'O'&& arr[3]=='O' && arr[6]!='X' || arr[7]=='O'&& arr[8]=='O' && arr[6]!='X'
						|| arr[4]=='O' && arr[2]=='O' && arr[6]!='X') {
					checkDuplicate(6,comp);
				}else if (arr[6] == 'O'&& arr[8]=='O' && arr[7]!='X' || arr[1] == 'O'&& arr[4]=='O' && arr[7]!='X') {
					checkDuplicate(7,comp);
				}else if (arr[6] == 'O'&& arr[7]=='O' && arr[8]!='X' || arr[2]=='O'&& arr[5]=='O' && arr[8]!='X'
						|| arr[0]=='O' && arr[4]=='O' && arr[8]!='X') {
					checkDuplicate(8,comp);
				}

				//block player

				else if (arr[1] == 'X' && arr[2]=='X' && arr[0] !='O' || arr[3]=='X'&& arr[6]=='X' && arr[0] !='O'
						|| arr[4]=='X' && arr[8]=='X' && arr[0] !='O') {
					checkDuplicate(0,comp);
				}
				else if (arr[0] == 'X'&& arr[2]=='X' && arr[1] !='O'|| arr[4]=='X' && arr[7]!='X'&& arr[1] !='O'){
					checkDuplicate(1,comp);
				}else if (arr[0] == 'X'&& arr[1]=='X' && arr[2]!='O' || arr[4]=='X'&& arr[6]=='X' && arr[2]!='O'
						|| arr[5]=='X' && arr[8]=='X' && arr[2]!='O') {
					checkDuplicate(2,comp);
				}
				else if (arr[0] == 'X'&& arr[6]=='X' && arr[3]!='O'|| arr[4] == 'X'&& arr[5]=='X' && arr[3]!='O' ) {
					checkDuplicate(3,comp);
				}else if (arr[3] == 'X'&& arr[5]=='X' && arr[4]!='O'|| arr[1] == 'X'&& arr[7]=='X' && arr[4]!='O'
						|| arr[0] == 'X'&& arr[8]=='X' && arr[4]!='O'|| arr[2] == 'X'&& arr[6]=='X'&& arr[4]!='O') {
					checkDuplicate(4,comp);
				}else if (arr[2] == 'X'&& arr[8]=='X' && arr[5]!='O'|| arr[3] == 'X'&& arr[4]=='X' && arr[5]!='O') {
					checkDuplicate(5,comp);
				}else if (arr[0] == 'X'&& arr[3]=='X' && arr[6]!='O' || arr[7]=='X'&& arr[8]=='X' && arr[6]!='O'
						|| arr[4]=='X' && arr[2]=='X' && arr[4]!='O') {
					checkDuplicate(6,comp);
				}else if (arr[6] == 'X'&& arr[8]=='X' && arr[7]!='O' || arr[1] == 'X'&& arr[4]=='X' && arr[7]!='O') {
					checkDuplicate(7,comp);
				}else if (arr[6] == 'X'&& arr[7]=='X' && arr[8]!='O' || arr[2]=='X'&& arr[5]=='X' && arr[8]!='O'
						|| arr[0]=='X' && arr[4]=='X' && arr[8]!='O') {
					checkDuplicate(8,comp);
				}
				else {
					checkDuplicate(num-1,comp);
				}

			}

		}
	}
	public static boolean checkDuplicate(int p,char choice){

		if(arr[p]=='X' || arr[p]=='O'){
			return false;
		}else{
			arr[p]=choice;
			showBoard();
			turn++;
			winnerOrTieOrChangeTurn();

		}
		return true;
	}
	public static void whoPlayFirst(){
		Random num = new Random();
		int random= num.nextInt(2) +1;
		Scanner sc = new Scanner(System.in);
		System.out.println("I am doing a toss choose head or tail\n press 1 for Head & press 2 for Tail");
		int choice = sc.nextInt();
		if (random == choice){
			System.out.println("Heads");

		}else if (random ==choice){
			System.out.println("tail");
		}else {
			System.out.println("Choose correct option 1 or 2");
		}
	}
	public static void  winnerOrTieOrChangeTurn() {
		if (arr[0] == 'X' && arr[1] == 'X' && arr[2] == 'X' || arr[0] == 'X' && arr[3] == 'X' && arr[6] == 'X'
				|| arr[1] == 'X' && arr[4] == 'X' && arr[7] == 'X'|| arr[2] == 'X' && arr[5] == 'X' && arr[8] == 'X'
				|| arr[3] == 'X' && arr[4] == 'X' && arr[5] == 'X' || arr[6] == 'X' && arr[7] == 'X' && arr[8] == 'X'
				|| arr[0] == 'X' && arr[4] == 'X' && arr[8] == 'X' || arr[6] == 'X' && arr[4] == 'X' && arr[2] == 'X')
		{
			System.out.println("Player is winner");
			turn = 15 ;
			playAgain();
		}else if (arr[0] == 'O' && arr[1] == 'O' && arr[2] == 'O' || arr[0] == 'O' && arr[3] == 'O' && arr[6] == 'O'
				|| arr[1] == 'O' && arr[4] == 'O' && arr[7] == 'O'|| arr[2] == 'O' && arr[5] == 'O' && arr[8] == 'O'
				|| arr[3] == 'O' && arr[4] == 'O' && arr[5] == 'O' || arr[6] == 'O' && arr[7] == 'O' && arr[8] == 'O'
				|| arr[0] == 'O' && arr[4] == 'O' && arr[8] == 'O' || arr[6] == 'O' && arr[4] == 'O' && arr[2] == 'O')
		{
			System.out.println("computer is winner ");
			turn = 15 ;
			playAgain();
			while(turn!=15) {
				makeMove(player, comp);
			}


		}else if ( turn == 11 ) {
			System.out.println("Tie the game ");
			turn = 15 ;
			playAgain();
			while(turn!=15) {
				makeMove(player, comp);
			}
		}


	}
	public static void playAgain(){
		System.out.println(" play the game once again then press 1 && do not play again then press 2");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		if ( option == 1 ){
			System.out.println("Start the game ");
			createEmptyBoard();
			allowPlayer();

		}else{
			System.out.println("Stop the game");
		}

	}

}
