package JTablesModel;

import javax.swing.table.AbstractTableModel;

import sync.Config;

@SuppressWarnings("serial")
public class ShowAllEnergyCardsModel extends AbstractTableModel{
	
	private String[] columnNames = {"id","cardName","EnergyType","CardNumber","Expansion"};
    private Object[][] data = Config.fetchEnergyCardsData();

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
