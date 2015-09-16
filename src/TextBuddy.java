
/**
 *AUTHOR'S NOTES 
 *This program will scan user input to add a string, display a string,
 *delete a string, clear the file or exit the file.
 *File is saved after each user input
 *This program also assumes that the user will not enter an empty line
 *Done by: Shawn
 */

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import java.lang.NumberFormatException;

public class TextBuddy {

	private FileWriter fw;
	private FileReader fr;
	private BufferedWriter bw;
	private BufferedReader br;
	private static String fileName;
	private static File file;
	private static Scanner scanner = new Scanner(System.in);

	private static final String MESSAGE_WELCOME = "Welcome to TextBuddy. %s is ready for use\n";
	private static final String MESSAGE_COMMAND = "command: ";
	private static final String MESSAGE_CLEAR = "all content deleted from ";
	private static final String MESSAGE_DELETE = "deleted from %1$s: \"%2$s\"%n";
	private static final String MESSAGE_ADD = "added to %1$s: \"%2$s\"%n";
	private static final String MESSAGE_DISPLAY = "%1$s is empty\n";
	private static final String INVALID_COMMAND = "invalid command";

	public static void main(String[] args) {

		String fileName = args[0];
		file = new File(args[0]);
		TextBuddy textBuddy = new TextBuddy();

		prepareFile(scanner, fileName, textBuddy);

	}
	
	private static void prepareFile(Scanner sc, String fileName, TextBuddy textBuddy) {
		try {
			openFile(fileName, textBuddy);

			System.out.printf(MESSAGE_WELCOME, fileName);

			String command = "";

			while (!command.equals("exit")) {
				System.out.print(MESSAGE_COMMAND);
				command = sc.next();
				String commandPart2 = sc.nextLine();

				if (command.equals("add")) {
					addCommand(fileName, commandPart2);

				} else if (command.equals("display")) {
					displayFile(fileName);

				} else if (command.equals("delete")) {
					deleteCommand(fileName, commandPart2);

				} else if (command.equals("clear")) {
					clearFile(fileName);
					clearFileMessage(fileName);

				} else if (command.equals("exit")) {
					exitProgram();

				} else if (command.equals("search")) {
					searchFile(fileName, commandPart2);

				} else if (command.equals("sort")) {
					sortFile(fileName);

				} else {
					System.out.println(INVALID_COMMAND);
				}

				System.out.println();

			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	private static void clearFileMessage(String fileName) {
		System.out.println(MESSAGE_CLEAR + fileName);
	}

	private static void exitProgram() {
		System.exit(0);
	}

	private static void clearFile(String fileName) throws IOException {
		File file = new File(fileName);
		FileWriter fw = new FileWriter(file, false);
		BufferedWriter bw = new BufferedWriter(fw);

		bw.flush();
	}

	private static void deleteCommand(String fileName, String commandPart2) throws FileNotFoundException, IOException {
		try {
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			ArrayList<String> remain = new ArrayList<String>();
			int index = Integer.parseInt(commandPart2.trim());
			String currentLine;
			int currentIndex = 1; // counter so as to skip the indexed line

			while ((currentLine = br.readLine()) != null) {
				if (currentIndex == index) {
					System.out.printf(MESSAGE_DELETE, fileName, currentLine.trim());
					currentIndex++;
					continue;
				}
				remain.add(currentLine);
				currentIndex++;
			}

			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			for (String textLine : remain) {
				bw.write(textLine + System.getProperty("line.separator"));
			}
			bw.flush();
		} catch (NumberFormatException e) {
			System.out.println(INVALID_COMMAND);
		}
	}

	private static void displayFile(String fileName) throws FileNotFoundException, IOException {
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		String displayLine;
		int index = 1;

		while ((displayLine = br.readLine()) != null) {
			displayLine = Integer.toString(index) + ". " + displayLine;
			System.out.println(displayLine);
			index++;

		}

		if (index == 1) {
			System.out.printf(MESSAGE_DISPLAY, fileName);
		}
	}

	public static String addCommand(String fileName, String commandPart2) throws IOException {
		File file = new File(fileName);
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write(commandPart2.trim());
		bw.newLine();
		bw.flush();
		System.out.printf(MESSAGE_ADD, fileName, commandPart2.trim());
		
		return commandPart2;
	}

	private static void openFile(String fileName, TextBuddy textBuddy) throws IOException, FileNotFoundException {
		file = new File(fileName);
		if (!file.exists()) {
			file.createNewFile();
		}
	}

	public static int searchFile(String fileName, String commandPart2) throws IOException {
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		commandPart2 = commandPart2.trim();
		String displayLine;
		int index = 1;
		int count = 0;

		while ((displayLine = br.readLine()) != null) {
			ArrayList<String> displayArray = new ArrayList<String>(Arrays.asList(displayLine.split(" ")));

			for (int i = 0; i < displayArray.size(); i++) {
				String searchWord = displayArray.get(i);
				if (searchWord.equals(commandPart2)) {
					System.out.printf("%s found in line %s\n", commandPart2, index);
					count++;
				}
				index++;
			}
		}
		
		return count;
	}
	
	public static boolean sortFile(String fileName) throws IOException {
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		String displayLine;
		ArrayList<String> displayArray = new ArrayList<String>();
		
		
		while ((displayLine = br.readLine()) != null) {
			displayArray.add(displayLine);
		}
		
		Collections.sort(displayArray);
		clearFile(fileName);
		
		for(int i=0; i<displayArray.size(); i++) {
			String content = displayArray.get(i);
			bw.write(content);
			bw.newLine();
			bw.flush();
		}
		
		System.out.println("Sorted");
		return true;
	}
	

}
