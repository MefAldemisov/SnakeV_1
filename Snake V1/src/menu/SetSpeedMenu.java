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
public class SetSpeedMenu extends JFrame {

	public SetSpeedMenu() {
		setSize(200, 300);
		setTitle("set Speed");

		JLabel lblNewLabel = new JLabel("Choose the speed:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);

		Choice choice = new Choice();
		choice.setFont(new Font("Arial", Font.PLAIN, 18));
		choice.setBounds(50, 50, 100, 30);
		choice.add("200");
		choice.add("300");
		choice.add("350");
		choice.add("400");
		choice.add("500");
		choice.add("600");
		choice.add("700");
		choice.add("800");
		getContentPane().add(choice);

		JButton btnSaveAndExit = new JButton("Save and exit");
		btnSaveAndExit.setFont(new Font("Arial", Font.PLAIN, 18));
		getContentPane().add(btnSaveAndExit, BorderLayout.SOUTH);
		btnSaveAndExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Main.setSpeed(Integer.parseInt(choice.getSelectedItem()));
				dispose();

			}
		});
		setVisible(true);
	}

}
