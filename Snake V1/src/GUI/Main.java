package GUI;

import javax.swing.JFrame;

public class Main {
	protected static int size;
	protected static int speed;

	public static int getSize() {
		return size;
	}

	public static void setSize(int size) {
		Main.size = size;
	}

	public static int getSpeed() {
		return speed;
	}

	public static void setSpeed(int speed) {
		Main.speed = speed;
	}

	public static boolean redo;
	private static Window win;

	public static boolean isRedo() {
		return redo;
	}

	public static void setRedo(boolean redo) {
		Main.redo = redo;
	}
	public static String color;
	public static String food;

	public static String getColor() {
		return color;
	}

	public static void setColor(String color) {
		Main.color = color;
	}

	public static String getFood() {
		return food;
	}

	public static void setFood(String food) {
		Main.food = food;
	}

	// the only bug is GREBANIY blue square
	// also there is a strange NullPointerException
	public static void main(String[] args) throws InterruptedException, NullPointerException {
		size = 12;
		speed = 400;
		redo = false;
		color= "white";
		food="dove";
		win = new Window("MefAldemisov");
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		while (true) {
			if (redo) {
				redo = false;
				win.dispose();
				win = new Window("MefAldemisovSnake");
				win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
	}
}
