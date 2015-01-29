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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;

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
		lblName.setBounds(-22, 84, 200, 25);
		contentPanel.add(lblName);
		
		JLabel lblNewLabel_1 = new JLabel("EnergyType :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(-22, 124, 200, 25);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblHealthPoints = new JLabel("Health Points :");
		lblHealthPoints.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHealthPoints.setBounds(-22, 164, 200, 25);
		contentPanel.add(lblHealthPoints);
		
		JLabel lblEvolutionStage = new JLabel("Evolution Stage :");
		lblEvolutionStage.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEvolutionStage.setBounds(-22, 204, 200, 25);
		contentPanel.add(lblEvolutionStage);
		
		JLabel lblCollectorCardNumber = new JLabel("Collector Card Number :");
		lblCollectorCardNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCollectorCardNumber.setBounds(-22, 244, 200, 25);
		contentPanel.add(lblCollectorCardNumber);
		
		JLabel lblExpansionSymbol = new JLabel("Expansion :");
		lblExpansionSymbol.setHorizontalAlignment(SwingConstants.TRAILING);
		lblExpansionSymbol.setBounds(-22, 284, 200, 25);
		contentPanel.add(lblExpansionSymbol);
		
		
		JComboBox<String> CBenergyType = new JComboBox<String>();
		CBenergyType.setBounds(193, 124, 80, 25);
		CBenergyType = Config.fillCBoxEnergyList(CBenergyType);
		contentPanel.add(CBenergyType);
		
		textField = new JTextField();
		textField.setBounds(193, 84, 150, 25);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(193, 164, 75, 25);
		contentPanel.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(193, 244, 150, 25);
		contentPanel.add(textField_3);
		
		JComboBox<String> CBEvolStage = new JComboBox<String>();
		CBEvolStage.setBounds(193, 204, 130, 25);
		CBEvolStage = Config.fillCBoxEvolStageList(CBEvolStage);
		contentPanel.add(CBEvolStage);
		
		JComboBox<String> CBExpansion = new JComboBox<String>();
		CBExpansion.setBounds(193, 284, 250, 25);
		CBExpansion = Config.fillCBoxExpansionList(CBExpansion);
		contentPanel.add(CBExpansion);

		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		JButton okButton = new JButton("OK");
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
