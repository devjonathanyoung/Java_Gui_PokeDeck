package View.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controller.master.Config;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DialogDeleteCard extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField idToDeleteField;
	private JLabel lblCardToDelete;

	public DialogDeleteCard() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblCardToDelete = new JLabel("Card ID:");
		lblCardToDelete.setBounds(28, 100, 69, 20);
		contentPanel.add(lblCardToDelete);

		idToDeleteField = new JTextField();
		lblCardToDelete.setLabelFor(idToDeleteField);
		idToDeleteField.setBounds(97, 97, 146, 26);
		contentPanel.add(idToDeleteField);
		idToDeleteField.setColumns(10);

		JLabel titleDeleteCardDialog = new JLabel("Delete Card");
		titleDeleteCardDialog.setFont(new Font("Tahoma", Font.BOLD, 20));
		titleDeleteCardDialog.setHorizontalAlignment(SwingConstants.CENTER);
		titleDeleteCardDialog.setBounds(0, 16, 430, 20);
		contentPanel.add(titleDeleteCardDialog);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Config.DECK.remove(Integer.parseInt(idToDeleteField.getText()));
				dispose();
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

	}
}
