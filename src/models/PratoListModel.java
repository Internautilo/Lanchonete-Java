package models;

import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;

public class PratoListModel extends AbstractListModel<Prato> {

	private static final long serialVersionUID = 1L;
	private ArrayList<Prato> pratos;

    public PratoListModel(ArrayList<Prato> pratos) {
        this.pratos = pratos;
    }

    public int getSize() {
        return pratos.size();
    }

    public Prato getElementAt(int index) {
        return pratos.get(index);
    }
    
    public void addItem(Prato item) {
        // Add item to your model
        int index = pratos.size() - 1; // Index of the last item
        fireIntervalAdded(this, index, index);
    }
    
    public void removeItem(Prato item) {
        // Remove item from your model
        int index = pratos.indexOf(item);
        if (index >= 0) {
            pratos.remove(index);
            fireIntervalRemoved(this, index, index);
        }
    }
    
    public void updateItem(Prato item) {
        // Update item in your model
        int index = pratos.indexOf(item);
        if (index >= 0) {
            // Modify the item
            fireContentsChanged(this, index, index);
        }
    }

	

}
