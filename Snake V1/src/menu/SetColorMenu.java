package menu;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import GUI.Main;

@SuppressWarnings("serial")
public class SetColorMenu extends JFrame {

	public SetColorMenu() {
		setSize(200, 300);
		setTitle("set Color");

		JLabel lblNewLabel = new JLabel("Choose the color:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);

		Choice choice = new Choice();
		choice.setFont(new Font("Arial", Font.PLAIN, 18));
		choice.setBounds(50, 50, 100, 30);
		choice.add("white");
		choice.add("darkGreen");
		choice.add("lightGreen");
		choice.add("lightBrown");
		choice.add("blood");
		choice.add("blue");
		choice.add("night");
		getContentPane().add(choice);

		JButton btnSaveAndExit = new JButton("Save and exit");
		btnSaveAndExit.setFont(new Font("Arial", Font.PLAIN, 18));
		getContentPane().add(btnSaveAndExit, BorderLayout.SOUTH);
		btnSaveAndExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String color = choice.getSelectedItem();
				Main.setColor(color);
				dispose();
			}
		});
		setVisible(true);

	}

}
