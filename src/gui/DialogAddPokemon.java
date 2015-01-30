package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import sync.Config;

@SuppressWarnings("serial")
public class DialogAddPokemon extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nameField;
	private JTextField HPField;
	private JTextField CollectionCardNumberField;
	private JComboBox<String> CBEvolStage;
	private JComboBox<String> CBExpansion;
	private JComboBox<String> CBEnergyType;
	
	public DialogAddPokemon(){
		
		setBounds(100, 100, 500, 459);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Pokemon Card");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 16, 480, 20);
		contentPanel.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblName.setBounds(-10, 84, 200, 25);
		contentPanel.add(lblName);
		
		JLabel lblNewLabel_1 = new JLabel("EnergyType :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(-10, 124, 200, 25);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblHealthPoints = new JLabel("Health Points :");
		lblHealthPoints.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHealthPoints.setBounds(-10, 164, 200, 25);
		contentPanel.add(lblHealthPoints);
		
		JLabel lblEvolutionStage = new JLabel("Evolution Stage :");
		lblEvolutionStage.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEvolutionStage.setBounds(-10, 204, 200, 25);
		contentPanel.add(lblEvolutionStage);
		
		JLabel lblCollectorCardNumber = new JLabel("Collection Card Number :");
		lblCollectorCardNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCollectorCardNumber.setBounds(-10, 244, 200, 25);
		contentPanel.add(lblCollectorCardNumber);
		
		JLabel lblExpansionSymbol = new JLabel("Expansion :");
		lblExpansionSymbol.setHorizontalAlignment(SwingConstants.TRAILING);
		lblExpansionSymbol.setBounds(-10, 284, 200, 25);
		contentPanel.add(lblExpansionSymbol);
		
		CBEnergyType = new JComboBox<String>();
		CBEnergyType.setBounds(205, 124, 80, 25);
		CBEnergyType = Config.fillCBoxEnergyList(CBEnergyType);
		contentPanel.add(CBEnergyType);
		
		nameField = new JTextField();
		nameField.setBounds(205, 84, 150, 25);
		contentPanel.add(nameField);
		nameField.setColumns(10);
		
		HPField = new JTextField();
		HPField.setColumns(10);
		HPField.setBounds(205, 164, 75, 25);
		contentPanel.add(HPField);
		
		CollectionCardNumberField = new JTextField();
		CollectionCardNumberField.setColumns(10);
		CollectionCardNumberField.setBounds(205, 244, 150, 25);
		contentPanel.add(CollectionCardNumberField);
		
		CBEvolStage = new JComboBox<String>();
		CBEvolStage.setBounds(205, 204, 130, 25);
		CBEvolStage = Config.fillCBoxEvolStageList(CBEvolStage);
		contentPanel.add(CBEvolStage);
		
		CBExpansion = new JComboBox<String>();
		CBExpansion.setBounds(205, 284, 250, 25);
		CBExpansion = Config.fillCBoxExpansionList(CBExpansion);
		contentPanel.add(CBExpansion);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] cardData = {"Pokemon",nameField.getText(),
						CBEnergyType.getSelectedItem().toString(),
						CollectionCardNumberField.getText(), 
						CBExpansion.getSelectedItem().toString(),
						HPField.getText(),
						CBEvolStage.getSelectedItem().toString()};
				Config.poke.addCard(cardData);
				dispose();
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

	}
}
