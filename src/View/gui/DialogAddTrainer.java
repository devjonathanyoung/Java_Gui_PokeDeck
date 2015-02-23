package View.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

import Controller.master.Config;
import Controller.master.Ctrl_Pokedeck;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import View.listeners.FieldChecker;
import View.listeners.NegativeFieldChecker;

@SuppressWarnings("serial")
public class DialogAddTrainer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JComboBox<String> CBTrainerType;
	private JTextField nameField;
	private JTextArea TrainerRuleField;
	private JTextArea DescriptionField;
	private JTextField CollectionCardNumberField;
	private JComboBox<String> CBExpansion;
	
	public DialogAddTrainer() {
		setBounds(100, 100, 598, 504);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblAddItemCard = new JLabel("Add Trainer Card");
		lblAddItemCard.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddItemCard.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddItemCard.setBounds(0, 11, 480, 20);
		contentPanel.add(lblAddItemCard);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(0, 68, 200, 20);
		contentPanel.add(lblName);
		
		JLabel lblTrainerType = new JLabel("Trainer Type :");
		lblTrainerType.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTrainerType.setBounds(0, 104, 200, 20);
		contentPanel.add(lblTrainerType);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescription.setBounds(0, 140, 200, 20);
		contentPanel.add(lblDescription);
		
		JLabel lblTrainerRule = new JLabel("Trainer Rule :");
		lblTrainerRule.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTrainerRule.setBounds(0, 201, 200, 20);
		contentPanel.add(lblTrainerRule);
		
		nameField = new JTextField();
		nameField.setBounds(215, 65, 150, 25);
		nameField.addFocusListener(new NegativeFieldChecker(nameField,".*\\d.*"));
		contentPanel.add(nameField);
		
		DescriptionField = new JTextArea();
		DescriptionField.setLineWrap(true);
		DescriptionField.setWrapStyleWord(true);
		DescriptionField.setBounds(129, 139, 200, 50);
		JScrollPane spDescription = new JScrollPane(DescriptionField);
		spDescription.setBounds(215, 139, 200, 50);
		contentPanel.add(spDescription);
		
		TrainerRuleField = new JTextArea();
		TrainerRuleField.setLineWrap(true);
		TrainerRuleField.setWrapStyleWord(true);
		JScrollPane spTrainerRule= new JScrollPane(TrainerRuleField);
		spTrainerRule.setBounds(215, 208, 200, 50);
		contentPanel.add(spTrainerRule);
		
		CBTrainerType = new JComboBox<String>();
		CBTrainerType.setBounds(215, 104, 150, 20);
		CBTrainerType = Config.fillCBoxTrainerTypeList(CBTrainerType);
		contentPanel.add(CBTrainerType);
		
		JLabel lblExpansion = new JLabel("Expansion :");
		lblExpansion.setHorizontalAlignment(SwingConstants.TRAILING);
		lblExpansion.setBounds(0, 314, 200, 25);
		contentPanel.add(lblExpansion);
		
		JLabel lblCollectionCardNumber = new JLabel("Collection Card Number :");
		lblCollectionCardNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCollectionCardNumber.setBounds(0, 273, 200, 25);
		contentPanel.add(lblCollectionCardNumber);
		
		CollectionCardNumberField = new JTextField();
		CollectionCardNumberField.setColumns(10);
		CollectionCardNumberField.setBounds(215, 272, 150, 25);
		CollectionCardNumberField.addFocusListener(new FieldChecker(CollectionCardNumberField,"[1-9][0-9]{0,2}/[0-9]{2,3}"));
		contentPanel.add(CollectionCardNumberField);
		
		CBExpansion = new JComboBox<String>();
		CBExpansion.setBounds(215, 314, 250, 25);
		CBExpansion = Config.fillCBoxExpansionList(CBExpansion);
		contentPanel.add(CBExpansion);
		
		JLabel lblCollecNumberExemple = new JLabel("(Ex : 20/102)");
		lblCollecNumberExemple.setBounds(380, 275, 106, 20);
		contentPanel.add(lblCollecNumberExemple);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
				
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String CollecNumber = CollectionCardNumberField.getText();
				String Name = nameField.getText();
				boolean check1 = CollecNumber.matches("[1-9][0-9]{0,2}/[0-9]{2,3}");
				boolean check2 = !(Name.matches(".*\\d.*"));
				if(!check1) CollectionCardNumberField.setBackground(Color.red);
				if(!check2) nameField.setBackground(Color.red);
				if(check1 && check2){
					String[] cardData = {"Trainer",Name,
							CollecNumber,
							CBExpansion.getSelectedItem().toString(),
							CBTrainerType.getSelectedItem().toString(),
							DescriptionField.getText(),
							TrainerRuleField.getText()};
					Ctrl_Pokedeck.DECK.addCard(cardData);
					dispose();
				}	
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
				
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}
}
