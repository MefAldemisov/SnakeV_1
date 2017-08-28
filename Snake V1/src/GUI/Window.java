package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import menu.SetColorMenu;
import menu.SetFoodMenu;
import menu.SetSizeMenu;
import menu.SetSpeedMenu;

@SuppressWarnings("serial")
public class Window extends JFrame {
	private static int size;

	public static int getSIZE() {
		return size;
	}

	public static void setSIZE(int size) {
		Window.size = size;
	}

	private static int speed;

	public static void setSpeed(int speed) {
		Window.speed = speed;
	}
	
	public static String color;
	public static String food;

	private static short vector, pastHeadVector;

	public static void setVector(short Vector) {
		vector = Vector;
	}

	private ImageIcon[][] mainArray;
	boolean alive, eaten, stop;
	private ArrayList<OneSnakePart> snake;

	private JTable table;
	private JMenuBar menuBar;
	private JMenu mnFile, mnHelp, mnExit;
	private JMenuItem mntmChangeSize, mntmChangeSpeed, mntmLookAtThe, mntmExit;
	private JPanel panel;
	private ImageIcon white, app, head, turn;

	private OneSnakePart apple;
	protected JButton btnStop;
	private JLabel lblLengthIs;
	private KeyListener lisener;
	private ImageIcon body;
	private ImageIcon tail;
	private TableBuilder model;
	private JMenuItem mntmChangeColor;
	private JMenuItem mntmChangeFood;

	public Window(String s) {
		super(s);
		setFont(new Font("Arial", Font.BOLD, 16));
		size = Main.getSize();
		speed = Main.getSpeed();
		color=Main.getColor();
		food= Main.getFood();
		images();
		menuSets();
		basicParam();
		drawer();
		setVisible(true);
		moovingPart();
	}
	// Don't ask me, why I made it at the specific method.
	private void images() {
		white = new ImageIcon("pictures/"+color+"/white.png");
		app = new ImageIcon("pictures/"+color+"/"+food+".png");
	}

	// menu at the top
	private void menuSets() {
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnFile = new JMenu("Settings");
		mnFile.setFont(new Font("Arial", Font.PLAIN, 20));
		menuBar.add(mnFile);

		mntmChangeSize = new JMenuItem("Change size");
		mntmChangeSize.setFont(new Font("Arial", Font.PLAIN, 18));
		mntmChangeSize.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				stop = true;
				btnStop.setText(">");
				SetSizeMenu setSise = new SetSizeMenu();
				setSise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Main.setRedo(true);
				System.out.println("must be redrawen");
				alive = false;
			}
		});
		mnFile.add(mntmChangeSize);

		mntmChangeSpeed = new JMenuItem("Change speed");

		mntmChangeSpeed.setFont(new Font("Arial", Font.PLAIN, 18));
		mnFile.add(mntmChangeSpeed);
		mnFile.setFont(new Font("Arial", Font.PLAIN, 20));
		mntmChangeSpeed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				stop = true;
				btnStop.setText(">");
				SetSpeedMenu setMenu = new SetSpeedMenu();
				setMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Main.setRedo(true);
				System.out.println("asked");
				alive = false;
			}
		});
		
		mntmChangeColor = new JMenuItem("Change color");

		mntmChangeColor.setFont(new Font("Arial", Font.PLAIN, 18));
		mnFile.add(mntmChangeColor);
		mntmChangeColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				stop = true;
				btnStop.setText(">");
				SetColorMenu setMenu = new SetColorMenu();
				setMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Main.setRedo(true);
				System.out.println("asked");
				alive = false;
			}
		});
		
		mntmChangeFood = new JMenuItem("Change food");

		mntmChangeFood.setFont(new Font("Arial", Font.PLAIN, 18));
		mnFile.add(mntmChangeFood);
		mntmChangeFood.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				stop = true;
				btnStop.setText(">");
				SetFoodMenu setMenu = new SetFoodMenu();
				setMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Main.setRedo(true);
				System.out.println("asked");
				alive = false;
			}
		});

		mnHelp = new JMenu("Restart");
		mnHelp.setFont(new Font("Arial", Font.PLAIN, 20));
		menuBar.add(mnHelp);

		mntmLookAtThe = new JMenuItem("Restart");

		mntmLookAtThe.setFont(new Font("Arial", Font.PLAIN, 18));
		mntmLookAtThe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Main.setRedo(true);
				System.out.println("asked");
				alive = false;
			}
		});
		mnHelp.add(mntmLookAtThe);

		mnExit = new JMenu("Exit");
		mnExit.setFont(new Font("Arial", Font.PLAIN, 20));
		menuBar.add(mnExit);

		mntmExit = new JMenuItem("Exit");

		mntmExit.setFont(new Font("Arial", Font.PLAIN, 18));
		mnExit.add(mntmExit);
		getContentPane().setLayout(new BorderLayout(0, 0));
		mntmExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				stop = true;
				btnStop.setText(">");
				System.exit(2);
			}
		});
	}

	private void basicParam() {
		eaten = false;
		vector = 1;
		alive = true;
		snake = new ArrayList<OneSnakePart>();
		snake.add(new OneSnakePart(4, 4, (short) 1));
	}

	// here the window is drawn
	protected void drawer() {

		setBounds(100, 100, size * 35 + 140, size * 32 + 70);
		java.awt.Image im = this.getToolkit().getImage("pictures/titleIcon.png");
		setIconImage(im);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);

		tableDrwaer();

		btnStop = new JButton("||");
		btnStop.setFont(new Font("Arial", Font.PLAIN, 20));
		btnStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pause();
				table.setFocusable(true);
				table.requestFocus();
			}
		});
		panel.add(btnStop);

		lblLengthIs = new JLabel("length is" + snake.size());
		if (snake.size() == size * size-1) {
			lblLengthIs.setText("You win!!! :)");
		}
		lblLengthIs.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.add(lblLengthIs);
	}

	private void tableDrwaer() {
		model = new TableBuilder();
		mainArray = model.getScreen_array();
		table = new JTable(model);
		table.setBackground(SystemColor.text);
		table.setSurrendersFocusOnKeystroke(true);
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		table.setRowSelectionAllowed(false);
		table.setRowHeight(30);
		for (int i = 0; i < size; i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(30);
			for(int j=0; j<size; j++){
			mainArray[i][j]=white;
			}
		}
		lisAdder();
		panel.add(table);
		table.updateUI();
	}

	// key listener
	private void lisAdder() {
		lisener = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyChar() == 'a' || e.getKeyChar() == 'ô' || e.getKeyChar() == 'Ô' || e.getKeyChar() == 'A'
						|| e.getKeyCode() == KeyEvent.VK_LEFT) {
					short lokalVector=0;
					if(lokalVector==vector){
						speed-=50;
					}else{
						speed=Main.getSpeed();
					}
					vector = 0;
				}
				if (e.getKeyChar() == 'w' || e.getKeyChar() == 'ö' || e.getKeyChar() == 'Ö' || e.getKeyChar() == 'W'
						|| e.getKeyCode() == KeyEvent.VK_UP) {
					short lokalVector=1;
					if(lokalVector==vector){
						speed-=50;
					}else{
						speed=Main.getSpeed();
					}
					vector = 1;
				}
				if (e.getKeyChar() == 'd' || e.getKeyChar() == 'â' || e.getKeyChar() == 'Â' || e.getKeyChar() == 'D'
						|| e.getKeyCode() == KeyEvent.VK_RIGHT) {
					short lokalVector=3;
					if(lokalVector==vector){
						speed-=50;
					}else{
						speed=Main.getSpeed();
					}
					vector = 3;
				}
				if (e.getKeyChar() == 's' || e.getKeyChar() == 'û' || e.getKeyChar() == 'Û' || e.getKeyChar() == 'S'
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					short lokalVector=2;
					if(lokalVector==vector){
						speed-=50;
					}else{
						speed=Main.getSpeed();
					}
					vector = 2;
				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					pause();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		};
		table.addKeyListener(lisener);
	}

	private void pause() {
		if (btnStop.getText() == "||") {
			stop = true;
			btnStop.setText(">");
		} else {
			stop = false;
			btnStop.setText("||");
		}
	}

	// Hooray! Interesting part is here^
	private void moovingPart() {
		generateApple();
		appleEqSnake();
		long time1 = 0, time2 = 0;
		Date date = new Date();
		time2 = date.getTime();
		while (alive) {
			time1 = date.getTime();
			while ((time1 - time2) < speed || stop) {
				Date date2 = new Date();
				time1 = date2.getTime();
				if (stop) {
				}
			}
			pastHeadVector = snake.get(0).getV();
			// set vector of a head
			switch (vector) {
			case 0:
				snake.add(0, new OneSnakePart(snake.get(0).getX(), snake.get(0).getY() - 1, vector));
				head = new ImageIcon("pictures/"+color+"/left.png");
				break;
			case 1:
				snake.add(0, new OneSnakePart(snake.get(0).getX() - 1, snake.get(0).getY(), vector));
				head = new ImageIcon("pictures/"+color+"/up.png");
				break;
			case 2:
				snake.add(0, new OneSnakePart(snake.get(0).getX() + 1, snake.get(0).getY(), vector));
				head = new ImageIcon("pictures/"+color+"/down.png");
				break;
			case 3:
				snake.add(0, new OneSnakePart(snake.get(0).getX(), snake.get(0).getY() + 1, vector));
				head = new ImageIcon("pictures/"+color+"/right.png");
				break;
			}
			switch (pastHeadVector) {
			case 0:
				body = new ImageIcon("pictures/"+color+"/horisontal.png");
				break;
			case 1:
				body = new ImageIcon("pictures/"+color+"/vertical.png");
				break;
			case 2:
				body = new ImageIcon("pictures/"+color+"/vertical.png");
				break;
			case 3:
				body = new ImageIcon("pictures/"+color+"/horisontal.png");

			}
			mainArray[snake.get(1).getX()][snake.get(1).getY()] = body;
			// now first isn't head
			aliveChek();
			if (alive) {
				if (apple.getX() == snake.get(0).getX() && apple.getY() == snake.get(0).getY()) {
					// apple is eaten
					lblLengthIs.setText("length is " + snake.size());
					generateApple();
					appleEqSnake();
				} else {
					// remove last part of a tail
					mainArray[snake.get(snake.size() - 1).getX()][snake.get(snake.size() - 1).getY()] = white;
					snake.remove(snake.size() - 1);
				}
				// lets make specific image for a tail!
				// I know, that I should use another collection, but I AM
				// LAZYYYYYY!!!!
				mainArray[snake.get(0).getX()][snake.get(0).getY()] = head;
				if (snake.size() > 1) {
					switch (snake.get(snake.size() - 2).getV()) {
					case 0:
						tail = new ImageIcon("pictures/"+color+"/tailLeft.png");
						break;
					case 1:
						tail = new ImageIcon("pictures/"+color+"/tailUp.png");
						break;
					case 2:
						tail = new ImageIcon("pictures/"+color+"/tailDown.png");
						break;
					case 3:
						tail = new ImageIcon("pictures/"+color+"/tailRight.png");
					}
					mainArray[snake.get(snake.size() - 1).getX()][snake.get(snake.size() - 1).getY()] = tail;
					if (snake.size() > 2) {
						if (snake.get(0).getV() != snake.get(1).getV()) {
							turn(snake.get(0).getV(), snake.get(1).getV());
						}
					}
				}
				// and what if snake turned?

				redraw();
				Date date3 = new Date();
				time2 = date3.getTime();
			}
		}
		// came out of the alive circle <=> die
		int needRestart = JOptionPane.showConfirmDialog(null, "Game over. Would you like to restart?");
		if (needRestart == JOptionPane.YES_OPTION || needRestart == JOptionPane.CANCEL_OPTION) {
			Main.setRedo(true);
			dispose();
		} else {
			System.exit(2);
		}
	}

	private void turn(short v2, short v1) {
		// this is MASO. Trust me.
		if ((v1 == 0 && v2 == 2) || (v1 == 1) && (v2 == 3)) {
			turn = new ImageIcon("pictures/"+color+"/turn1.png");
		} else if ((v1 == 3 && v2 == 2) || (v1 == 1) && (v2 == 0)) {
			turn = new ImageIcon("pictures/"+color+"/turn2.png");
		} else if ((v1 == 2 && v2 == 0) || (v1 == 3) && (v2 == 1)) {
			turn = new ImageIcon("pictures/"+color+"/turn3.png");
		} else if ((v1 == 0 && v2 == 1) || (v1 == 2) && (v2 == 3)) {
			turn = new ImageIcon("pictures/"+color+"/turn4.png");
		}
		mainArray[snake.get(1).getX()][snake.get(1).getY()] = turn;
	}

	private boolean appleChekSnake() {
		// If apple generate into the snake, it's not right.
		boolean eq = false;
		for (OneSnakePart part : snake) {
			if (part.getX() == apple.getX() && part.getY() == apple.getY()) {
				eq = true;
				break;
			}
		}
		return eq;
	}

	private void generateApple() {
		Random rand = new Random();
		apple = new OneSnakePart(rand.nextInt(size - 1), rand.nextInt(size - 1), (short) 1);
	}

	private void appleEqSnake() {
		// Apple is eaten.
		while (appleChekSnake()) {
			generateApple();
		}
		mainArray[apple.getX()][apple.getY()] = app;
	}

	private void redraw() {
		// Don't us me, why I made it in a specific method.
		table.updateUI();
	}

	private void aliveChek() {
		if (snake.get(0).getX() < 0 || snake.get(0).getX() > (size - 1) || snake.get(0).getY() > (size - 1)
				|| snake.get(0).getY() < 0) {
			alive = false;
		} else {
			for (int i = 1; i < snake.size(); i++) {
				if (snake.get(0).getX() == snake.get(i).getX() && snake.get(0).getY() == snake.get(i).getY()) {
					alive = false;
				}
			}
		}
	}
}