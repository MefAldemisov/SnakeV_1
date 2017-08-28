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
public class SetFoodMenu extends JFrame {
	String food;

	public SetFoodMenu() {
		setSize(200, 300);
		setTitle("set Food");
		food = "";
		JLabel lblNewLabel = new JLabel("Choose the food:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);

		Choice choice = new Choice();
		choice.setFont(new Font("Arial", Font.PLAIN, 18));
		choice.setBounds(50, 50, 100, 30);
		choice.add("Sparrow");
		choice.add("Dove");
		choice.add("Apple (for naive)");
		getContentPane().add(choice);

		JButton btnSaveAndExit = new JButton("Save and exit");
		btnSaveAndExit.setFont(new Font("Arial", Font.PLAIN, 18));
		getContentPane().add(btnSaveAndExit, BorderLayout.SOUTH);
		btnSaveAndExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedFood();
				Main.setFood(food);
				dispose();
			}

			private void selectedFood() {
				switch (choice.getSelectedItem()) {
				case "Sparrow":
					food = "BirdOne";
					break;
				case "Dove":
					food = "dove";
					break;
				case "Apple (for naive)":
					food = "apple";
					break;
				}

			}
		});
		setVisible(true);

	}

}
