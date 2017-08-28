package GUI;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class TableBuilder implements TableModel {
	
	private static ArrayList<TableModelListener> lis= new ArrayList<TableModelListener>();
	int numberInARow;
	private ImageIcon[][] screen_array;
	public ImageIcon[][] getScreen_array() {
		return screen_array;
	}
	public void setScreen_array(ImageIcon[][] screen_array) {
		this.screen_array = screen_array;
	}

	public TableBuilder() {
		this.numberInARow=Window.getSIZE();
		screen_array= new ImageIcon[numberInARow][numberInARow];
		System.out.println("I'm here");
		String color=Main.getColor();
		for(ImageIcon[] i: screen_array){
		for(@SuppressWarnings("unused") ImageIcon v: i){
			v=new ImageIcon("pictures/"+color+"/white.png");
		}
		}
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		lis.add(l);

	}

	@Override
	public Class<?> getColumnClass(int l) {
		return ImageIcon.class;
	}

	@Override
	public int getColumnCount() {
		return numberInARow;
	}

	@Override
	public String getColumnName(int col) {
		return null;
	}

	@Override
	public int getRowCount() {
		return numberInARow;
	}

	@Override
	public Object getValueAt(int x, int y) {
		return screen_array[x][y];
	}

	@Override
	public boolean isCellEditable(int x, int y) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		lis.remove(l);
	}

	@Override
	public void setValueAt(Object set, int x, int y) {
		screen_array[x][y]=(ImageIcon) set;
	}

}
