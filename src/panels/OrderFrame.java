package panels;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Prato;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JComboBox;

public class OrderFrame extends JFrame {
	
	public enum Mode{
		CREATE,
		EDIT,
		DELETE
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textClientName;
	private JLabel lblClientName;
	private JLabel lblList;
	private JTextField textServiceTax;
	private JLabel lblServiceTax;
	private JTextField textTotal;
	private JLabel lblTotal;
	private JButton btnBackToMenu;
	
	
	// Lista de Pratos do pedido
	public ArrayList<Prato> pratos;
	private JComboBox Field1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderFrame frame = new OrderFrame(Mode.CREATE);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
		
	public OrderFrame( Mode mode ) {
		SetContentPane();
		
		ClientNameField();
		ProductList();
		ItemTypeComboBox();
		ServiceTaxField();
		TotalField();
		
		switch (mode) {
		
		case EDIT :
			ConfirmEditBtn();
			break;
			
		case DELETE :
			ConfirmDeleteBtn();
			break;
		
		default : 
			CloseOrderBtn();
			break;
		}
		BackToMenuBtn();
		
	}
	
	public OrderFrame() {
		SetContentPane();
		
		ClientNameField();
		ProductList();
		ItemTypeComboBox();
		ServiceTaxField();
		TotalField();
		
		CloseOrderBtn();
		BackToMenuBtn();
	}
	
	private void SetContentPane() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
	}
	
	// Insert Client Name Field
	private void ClientNameField() {
		// Client Name
		lblClientName = new JLabel("Nome Cliente");
		lblClientName.setBounds(242, 22, 400, 14);
		textClientName = new JTextField();
		textClientName.setBounds(242, 46, 400, 20);
		textClientName.setColumns(30);
		contentPane.add(lblClientName);
		contentPane.add(textClientName);
	}
	
	// Insert Product List with
	// Add Item Button and Delete Item Button
	private void ProductList() {
		// Product List
		lblList = new JLabel("Itens Comprados");
		lblList.setBounds(242, 76, 400, 14);
		JList list = new JList();
		list.setBounds(242, 100, 400, 87);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		contentPane.add(lblList);
		contentPane.add(list);
		
		// Add Item
		JButton btnAddItem = new JButton("Adicionar Items");
		btnAddItem.setBounds(242, 470, 150, 23);
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnAddItem);
		
		// Delete Item
		JButton btnDeleteItem = new JButton("Remover Item");
		btnDeleteItem.setBounds(492, 470, 150, 23);
		btnDeleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnDeleteItem);
	}
	
	// Insert Service Tax Field
	private void ServiceTaxField() {
		// Service Tax
		lblServiceTax = new JLabel("Taxa de Serviço");
		lblServiceTax.setBounds(242, 512, 150, 14);
		textServiceTax = new JTextField();
		textServiceTax.setBounds(242, 532, 150, 20);
		textServiceTax.setColumns(30);
		textServiceTax.setEditable(false);
		contentPane.add(lblServiceTax);
		contentPane.add(textServiceTax);
	}
	
	// Insert Total Pay Field
	private void TotalField() {
		// Total
		lblTotal = new JLabel("Total");
		lblTotal.setBounds(492, 512, 150, 14);
		lblTotal.setHorizontalAlignment(SwingConstants.TRAILING);
		textTotal = new JTextField();
		textTotal.setBounds(492, 532, 150, 20);
		textTotal.setColumns(30);
		textTotal.setEditable(false);
		contentPane.add(lblTotal);
		contentPane.add(textTotal);
	}
	
	// Insert Back To Menu Button
	private void BackToMenuBtn() {
		// Back To Menu
		btnBackToMenu = new JButton("Voltar ao menu");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBackToMenu.setBounds(272, 699, 339, 23);
		contentPane.add(btnBackToMenu);
		
		
		
		
	}
	
	// Insert Close Order Button
	private void CloseOrderBtn() {
		// Close Order
		JButton btnCloseOrder = new JButton("Gerar Nota Fiscal e finalizar pedido");
		btnCloseOrder.setBounds(242, 615, 400, 23);
		btnCloseOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnCloseOrder);
	}
	
	// Insert Confirm Edit Button
	private void ConfirmEditBtn() {
		// Confirm Order Edit
		JButton btnConfirmEdit = new JButton("Confirmar edição");
		btnConfirmEdit.setBounds(242, 491, 400, 23);
		btnConfirmEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnConfirmEdit);					
	}
	
	// Insert Confirm Deletion Button
	private void ConfirmDeleteBtn() {
		// Delete Order
		JButton btnDelete = new JButton("Deletar");
		btnDelete.setBounds(242, 491, 400, 23);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnDelete);					
	}
	
	// Insert Item Selection Combo Box for adding products to the list
	private void ItemTypeComboBox() {
		JComboBox<String> ItemTypeComboBox = new JComboBox<String>();
		ItemTypeComboBox.setBounds(242, 198, 400, 22);
		ItemTypeComboBox.addItem("Lanche");
		ItemTypeComboBox.addItem("Pizza");
		ItemTypeComboBox.addItem("Salgado");
		
		JLabel lblField1 = new JLabel("");
		lblField1.setBounds(242, 239, 400, 14);
		contentPane.add(lblField1);
		
		JComboBox<String> Field1 = new JComboBox<String>();
		Field1.setBounds(242, 264, 400, 22);
		contentPane.add(Field1);
		
		
		JLabel lblField2 = new JLabel("");
		lblField2.setBounds(242, 297, 400, 14);
		contentPane.add(lblField2);
		
		JComboBox<String> Field2 = new JComboBox<String>();
		Field2.setBounds(242, 322, 400, 22);
		contentPane.add(Field2);
		
		
		JLabel lblField3 = new JLabel("");
		lblField3.setBounds(242, 355, 400, 14);
		contentPane.add(lblField3);
		
		JComboBox<String> Field3 = new JComboBox<String>();
		Field3.setBounds(242, 380, 400, 22);
		contentPane.add(Field3);
		
		ItemTypeComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = ItemTypeComboBox.getSelectedItem().toString();				
				switch (item) {
				
				case "Lanche" : // Default mode equals "Lanche"
					Field1.removeAllItems();
					Field2.removeAllItems();
					Field3.removeAllItems();
				
					lblField1.setText("Tipo de Pão");
					Field1.addItem("Brioche");
					Field1.addItem("Integral");
					Field1.addItem("Artesanal");
					
					lblField2.setText("Recheio");
					Field2.addItem("Hamburguer");
					Field2.addItem("Frango");
					Field2.addItem("Bacon");
					
					lblField3.setText("Molho");
					Field3.addItem("Tomate");
					Field3.addItem("Barbecue");
					Field3.addItem("Especial");

					repaint();
					break;	
				
				case "Pizza" :
					Field1.removeAllItems();
					Field2.removeAllItems();
					Field3.removeAllItems();
					
					lblField1.setText("Recheio");
					Field1.addItem("Mussarela");
					Field1.addItem("Calabresa");
					Field1.addItem("Frango");
					Field1.addItem("Toscana");
					
					lblField2.setText("Molho");
					Field2.addItem("Tomate");
					Field2.addItem("Parisiense");
					Field2.addItem("Picante");
					
					lblField3.setText("Borda");
					Field3.addItem("Padrao");
					Field3.addItem("Catupiry");
					Field3.addItem("Cheddar");
					
					repaint();
					break;
					
				case "Salgado" :
					Field1.removeAllItems();
					Field2.removeAllItems();
					Field3.removeAllItems();
					
					lblField1.setText("Tipo");
					Field1.addItem("Assado");
					Field1.addItem("Frito");
					
					lblField2.setText("Massa");
					Field2.addItem("Trigo");
					Field2.addItem("Queijo");
					Field2.addItem("Kibe");
					
					lblField3.setText("Recheio");
					Field3.addItem("Frango");
					Field3.addItem("Salsicha");
					Field3.addItem("Queijo");
					Field3.addItem("Carne");					
					
					repaint();
					break;
					
				}
			}
		});
		contentPane.add(ItemTypeComboBox);
	}
}
