package View.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.JTable;
import javax.swing.JLabel;

import View.JTablesModel.ShowAllEnergyCardsModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class DialogShowAllEnergyCards extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	public DialogShowAllEnergyCards() {
		setBounds(100, 100, 550, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		table = new JTable(new ShowAllEnergyCardsModel());
		table.setRowSelectionAllowed(false);
		TableColumnModel colMdl = table.getColumnModel();
		colMdl.getColumn(0).setPreferredWidth(30);
		colMdl.getColumn(1).setPreferredWidth(120);
		colMdl.getColumn(2).setPreferredWidth(110);
		colMdl.getColumn(3).setPreferredWidth(80);
		colMdl.getColumn(4).setPreferredWidth(50);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		for(int x=0;x<table.getColumnCount();x++){
	         table.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
	    }
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(530,200));
		contentPanel.add(scrollPane);
			
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
	}
}
