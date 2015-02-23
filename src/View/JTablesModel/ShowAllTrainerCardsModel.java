package View.JTablesModel;

import javax.swing.table.AbstractTableModel;

import Controller.master.Config;
import Controller.master.Ctrl_Pokedeck;

@SuppressWarnings("serial")
public class ShowAllTrainerCardsModel extends AbstractTableModel{
	
	private String[] columnNames = {"id","cardName","TrainerType","Description","Trainer Rule","CardNumber","Expansion"};
    private Object[][] data = Ctrl_Pokedeck.DECK.fetchTrainerCardsData();

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
