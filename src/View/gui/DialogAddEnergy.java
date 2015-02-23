package View.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.Font;

import javax.swing.SwingConstants;

import Controller.master.Config;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import View.listeners.FieldChecker;

@SuppressWarnings("serial")
public class DialogAddEnergy extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel titleAddEnergy;
	private JComboBox<String> CBEnergyList;
	private JTextField CollectionCardNumberField;
	private JComboBox<String> CBExpansion;
	
	public DialogAddEnergy() {
		
		setBounds(100, 100, 600, 360);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblEnergyType = new JLabel("Energy Type :");
		lblEnergyType.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEnergyType.setBounds(0, 109, 200, 20);
		contentPanel.add(lblEnergyType);
	
		CBEnergyList = new JComboBox<String>();
		CBEnergyList.setBounds(217, 106, 150, 26);
		CBEnergyList = Config.fillCBoxEnergyList(CBEnergyList);
		contentPanel.add(CBEnergyList);
		
		titleAddEnergy = new JLabel("Ajouter une carte energie");
		titleAddEnergy.setHorizontalAlignment(SwingConstants.CENTER);
		titleAddEnergy.setFont(new Font("Tahoma", Font.BOLD, 20));
		titleAddEnergy.setBounds(15, 16, 400, 20);
		contentPanel.add(titleAddEnergy);
		
		JLabel lblCollectionCardNumber = new JLabel("Collection Card Number :");
		lblCollectionCardNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCollectionCardNumber.setBounds(0, 140, 200, 25);
		contentPanel.add(lblCollectionCardNumber);
		
		CollectionCardNumberField = new JTextField();
		CollectionCardNumberField.setColumns(10);
		CollectionCardNumberField.setBounds(215, 140, 150, 25);
		CollectionCardNumberField.addFocusListener(new FieldChecker(CollectionCardNumberField,"[1-9][0-9]{0,2}/[0-9]{2,3}"));
		contentPanel.add(CollectionCardNumberField);
		
		CBExpansion = new JComboBox<String>();
		CBExpansion.setBounds(215, 180, 250, 25);
		CBExpansion = Config.fillCBoxExpansionList(CBExpansion);
		contentPanel.add(CBExpansion);
		
		JLabel lblExpansion = new JLabel("Expansion :");
		lblExpansion.setHorizontalAlignment(SwingConstants.TRAILING);
		lblExpansion.setBounds(0, 180, 200, 25);
		contentPanel.add(lblExpansion);
		
		JLabel lblCollecNumberExemple = new JLabel("(Ex : 20/102)");
		lblCollecNumberExemple.setBounds(380, 142, 106, 20);
		contentPanel.add(lblCollecNumberExemple);
	
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String CollecNumber = CollectionCardNumberField.getText();
				if(CollecNumber.matches("[1-9][0-9]{0,2}/[0-9]{2,3}")){
					String[] cardData = {"Energy",CBEnergyList.getSelectedItem().toString(),
							CollecNumber, CBExpansion.getSelectedItem().toString()};
					Config.DECK.addCard(cardData);
					dispose();
				}
				else{
					CollectionCardNumberField.setBackground(Color.red);
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
