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

@SuppressWarnings("serial")
public class DialogAddTrainer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	public DialogAddTrainer() {
		setBounds(100, 100, 500, 400);
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
		lblName.setBounds(7, 68, 108, 20);
		contentPanel.add(lblName);
		
		JLabel lblTrainerType = new JLabel("Trainer Type :");
		lblTrainerType.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTrainerType.setBounds(7, 104, 108, 20);
		contentPanel.add(lblTrainerType);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescription.setBounds(7, 140, 108, 20);
		contentPanel.add(lblDescription);
		
		JLabel lblTrainerRule = new JLabel("Trainer Rule :");
		lblTrainerRule.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTrainerRule.setBounds(7, 201, 108, 20);
		contentPanel.add(lblTrainerRule);
		
		textField = new JTextField();
		textField.setBounds(130, 65, 150, 25);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JTextArea description = new JTextArea();
		description.setLineWrap(true);
		description.setBounds(129, 139, 200, 50);
		JScrollPane spDescription = new JScrollPane(description);
		spDescription.setBounds(129, 139, 200, 50);
		contentPanel.add(spDescription);
		
		JTextArea trainerRule = new JTextArea();
		trainerRule.setLineWrap(true);
		JScrollPane spTrainerRule= new JScrollPane(trainerRule);
		spTrainerRule.setBounds(130, 208, 200, 50);
		contentPanel.add(spTrainerRule);
		
		JComboBox<String> CBTrainerType = new JComboBox<String>();
		CBTrainerType.setBounds(129, 104, 150, 20);
		CBTrainerType = Config.fillCBoxTrainerTypeList(CBTrainerType);
		contentPanel.add(CBTrainerType);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
				
		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
				
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}
}
