package View.gui;

import java.awt.BorderLayout;
import java.awt.Color;
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

import View.listeners.FieldChecker;
import Controller.master.Config;
import Controller.master.Ctrl_Pokedeck;

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
		
		setBounds(100, 100, 600, 459);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTitre = new JLabel("Add Pokemon Card");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setBounds(0, 16, 480, 20);
		contentPanel.add(lblTitre);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblName.setBounds(-10, 84, 200, 25);
		contentPanel.add(lblName);
		
		JLabel lblEnergyType = new JLabel("EnergyType :");
		lblEnergyType.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEnergyType.setBounds(-10, 124, 200, 25);
		contentPanel.add(lblEnergyType);
		
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
		nameField.addFocusListener(new FieldChecker(nameField,"[a-zA-Z]{1,20}"));
		contentPanel.add(nameField);
		
		HPField = new JTextField();
		HPField.setBounds(205, 164, 75, 25);
		HPField.addFocusListener(new FieldChecker(HPField,"[1-9][0-9][0]"));
		contentPanel.add(HPField);
		
		CollectionCardNumberField = new JTextField();
		CollectionCardNumberField.setBounds(205, 244, 150, 25);
		CollectionCardNumberField.addFocusListener(new FieldChecker(CollectionCardNumberField,"[1-9][0-9]{0,2}/[0-9]{2,3}"));
		contentPanel.add(CollectionCardNumberField);
		
		CBEvolStage = new JComboBox<String>();
		CBEvolStage.setBounds(205, 204, 130, 25);
		CBEvolStage = Config.fillCBoxEvolStageList(CBEvolStage);
		contentPanel.add(CBEvolStage);
		
		CBExpansion = new JComboBox<String>();
		CBExpansion.setBounds(205, 284, 250, 25);
		CBExpansion = Config.fillCBoxExpansionList(CBExpansion);
		contentPanel.add(CBExpansion);
		
		JLabel lblCollecNumberExemple = new JLabel("(Ex : 20/102)");
		lblCollecNumberExemple.setBounds(370, 246, 106, 20);
		contentPanel.add(lblCollecNumberExemple);
		
		JLabel lblRuleHealthPoints = new JLabel("Only Numbers (10->990)");
		lblRuleHealthPoints.setBounds(282, 166, 184, 20);
		contentPanel.add(lblRuleHealthPoints);
		
		JLabel lblRuleName = new JLabel("Only Characters (20 Max)");
		lblRuleName.setBounds(359, 86, 204, 20);
		contentPanel.add(lblRuleName);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String CollecNumber = CollectionCardNumberField.getText();
				String HP = HPField.getText();
				String Name = nameField.getText();
				boolean check1 = CollecNumber.matches("[1-9][0-9]{0,2}/[0-9]{2,3}");
				boolean check2 = HP.matches("[1-9][0-9][0]");
				boolean check3 = Name.matches("[a-zA-Z]{1,20}");
				if(!check1) CollectionCardNumberField.setBackground(Color.red);
				if(!check2) HPField.setBackground(Color.red);
				if(!check3) nameField.setBackground(Color.red);
				if(check1 && check2 && check3){
					String[] cardData = {"Pokemon",Name,
							CBEnergyType.getSelectedItem().toString(),
							CollecNumber, 
							CBExpansion.getSelectedItem().toString(),
							HP,
							CBEvolStage.getSelectedItem().toString()};
					Ctrl_Pokedeck.DECK.addCard(cardData);
					dispose();
				}
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
