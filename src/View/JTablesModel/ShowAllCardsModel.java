package View.JTablesModel;

import javax.swing.table.AbstractTableModel;

import Controller.master.Ctrl_Pokedeck;

@SuppressWarnings("serial")
/*
 * This class defines the model and fetches the data to display
 * for the showAllCardsJDialog
 */
public class ShowAllCardsModel extends AbstractTableModel{
	
	    private String[] columnNames = {"id","CardType","cardName","EnergyType","CardNumber","Expansion"};
	    private Object[][] data = Ctrl_Pokedeck.DECK.fetchAllData();

	    public int getColumnCount() {
	        return columnNames.length;
	    }

		public int getRowCount() {
	        return data.length;
	    }

	    public String getColumnName(int col) {
	        return columnNames[col];
	    }

	    public Object getValueAt(int row, int col) {
	        return data[row][col];
	    }
	    @SuppressWarnings({ "unchecked", "rawtypes" })
		public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
}
