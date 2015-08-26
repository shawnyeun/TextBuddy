import java.io.IOException;
import java.io.FileNotFoundException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.Scanner;

public class TextBuddy {

	private FileWriter fw;
	private FileReader fr;
	private BufferedWriter bw;
	private BufferedReader br;
	private static String fileName;
	private static File file;
	private static Scanner scanner;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String fileName = args[0];
		TextBuddy textBuddy = new TextBuddy();
		file = new File(args[0]);

		try {
			openFile(fileName, textBuddy);

			System.out.printf("Welcome to TextBuddy. %s is ready for use\n", fileName);
			String command = "";

			while (!command.equals("exit")) {
				System.out.print("command: ");
				command = sc.next();
				String commandPart2 = sc.nextLine();

				if (command.equals("add")) {
					add(fileName, commandPart2);
				} else if (command.equals("display")) {
					display(fileName);

				} else if (command.equals("delete")) {
					delete(fileName, commandPart2);

				} else if (command.equals("clear")) {
					clear(fileName);

				} else if (command.equals("exit")) {
					System.exit(0);
					
				}

				System.out.println();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void clear(String fileName) throws IOException {
		File file = new File(fileName);
		FileWriter fw = new FileWriter(file, false);
		BufferedWriter bw = new BufferedWriter(fw);

		bw.flush();
		System.out.println("all content deleted from " + fileName);
	}

	private static void delete(String fileName, String commandPart2) throws FileNotFoundException, IOException {
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		ArrayList<String> remain = new ArrayList<String>();
		int index = Integer.parseInt(commandPart2.trim());
		String currentLine;
		int currentIndex = 1;

		while ((currentLine = br.readLine()) != null) {
			if (currentIndex == index) {
				System.out.println("deleted from " + fileName + ": \"" + currentLine + "\"");
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
	}

	private static void display(String fileName) throws FileNotFoundException, IOException {
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		String displayLine;
		int index = 1;

		while ((displayLine = br.readLine()) != null) {
			displayLine = Integer.toString(index) + "." + displayLine;
			System.out.println(displayLine);
			index++;

		}

		if (index == 1) {
			System.out.println(fileName + " is empty");
		}
	}

	private static void add(String fileName, String commandPart2) throws IOException {
		File file = new File(fileName);
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write(commandPart2);
		bw.newLine();
		bw.flush();
		System.out.println("added to " + fileName + ": \"" + commandPart2 + "\"");
	}

	private static void openFile(String fileName, TextBuddy textBuddy) throws IOException, FileNotFoundException {
		file = new File(fileName);
		if (!file.exists()) {
			file.createNewFile();
		}
	}
}
