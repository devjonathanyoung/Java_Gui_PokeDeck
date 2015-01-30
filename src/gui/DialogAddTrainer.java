package gui;

import java.awt.BorderLayout;
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

import sync.Config;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		contentPanel.add(nameField);
		nameField.setColumns(10);
		
		DescriptionField = new JTextArea();
		DescriptionField.setLineWrap(true);
		DescriptionField.setBounds(129, 139, 200, 50);
		JScrollPane spDescription = new JScrollPane(DescriptionField);
		spDescription.setBounds(215, 139, 200, 50);
		contentPanel.add(spDescription);
		
		TrainerRuleField = new JTextArea();
		TrainerRuleField.setLineWrap(true);
		JScrollPane spTrainerRule= new JScrollPane(TrainerRuleField);
		spTrainerRule.setBounds(215, 208, 200, 50);
		contentPanel.add(spTrainerRule);
		
		CBTrainerType = new JComboBox<String>();
		CBTrainerType.setBounds(215, 104, 150, 20);
		CBTrainerType = Config.fillCBoxTrainerTypeList(CBTrainerType);
		contentPanel.add(CBTrainerType);
		
		JLabel label = new JLabel("Expansion :");
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setBounds(0, 314, 200, 25);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("Collection Card Number :");
		label_1.setHorizontalAlignment(SwingConstants.TRAILING);
		label_1.setBounds(0, 273, 200, 25);
		contentPanel.add(label_1);
		
		CollectionCardNumberField = new JTextField();
		CollectionCardNumberField.setColumns(10);
		CollectionCardNumberField.setBounds(215, 272, 150, 25);
		contentPanel.add(CollectionCardNumberField);
		
		CBExpansion = new JComboBox<String>();
		CBExpansion.setBounds(215, 314, 250, 25);
		CBExpansion = Config.fillCBoxExpansionList(CBExpansion);
		contentPanel.add(CBExpansion);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
				
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] cardData = {"Trainer",nameField.getText(),
						CollectionCardNumberField.getText(),
						CBExpansion.getSelectedItem().toString(),
						CBTrainerType.getSelectedItem().toString(),
						DescriptionField.getText(),
						TrainerRuleField.getText()};
				Config.poke.addCard(cardData);
				dispose();	
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
