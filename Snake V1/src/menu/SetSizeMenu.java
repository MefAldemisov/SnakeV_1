package menu;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import GUI.Main;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class SetSizeMenu extends JFrame {

	public SetSizeMenu() {
		setSize(200, 300);
		setTitle("setSize");
		JLabel lblNewLabel = new JLabel("Choose the size:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);

		Choice choice = new Choice();
		choice.setFont(new Font("Arial", Font.PLAIN, 18));
		choice.setBounds(50, 50, 100, 30);
		choice.add("10");
		choice.add("12");
		choice.add("15");
		choice.add("18");
		choice.add("20");
		getContentPane().add(choice);

		JButton btnSaveAndExit = new JButton("Save and exit");
		btnSaveAndExit.setFont(new Font("Arial", Font.PLAIN, 18));
		getContentPane().add(btnSaveAndExit, BorderLayout.SOUTH);
		btnSaveAndExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.setSize(Integer.parseInt(choice.getSelectedItem()));
				dispose();
			}
		});
		setVisible(true);

	}

}
