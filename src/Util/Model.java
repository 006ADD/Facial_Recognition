package Util;


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class Model extends AbstractTableModel {

    private String path;

    private ArrayList lines = null;
    private String[] columns = null;

    public Model(ArrayList lin, String[] col) {
        setLines(lin);
        setColumns(col);
    }

    public Model() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public ArrayList getLines() {
        return lines;
    }

    public void setLines(ArrayList data) {
        lines = data;
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] nomes) {
        columns = nomes;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public int getRowCount() {
        return lines.size();
    }

    @Override
    public String getColumnName(int numCol) {
        return columns[numCol];
    }

    @Override
    public Object getValueAt(int numLin, int numCol) {
        Object[] linha = (Object[]) getLines().get(numLin);
        return linha[numCol];
    }

}