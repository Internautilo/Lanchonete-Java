package panels;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JList;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderFrame frame = new OrderFrame(Mode.EDIT);
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
		
	public OrderFrame( Mode mode) {
		SetContentPane();
		
		ClientNameField();
		ProductList();
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
		lblClientName.setBounds(242, 170, 400, 14);
		textClientName = new JTextField();
		textClientName.setBounds(242, 194, 400, 20);
		textClientName.setColumns(30);
		contentPane.add(lblClientName);
		contentPane.add(textClientName);
	}
	
	// Insert Product List with
	// Add Item Button and Delete Item Button
	private void ProductList() {
		// Product List
		lblList = new JLabel("Itens Comprados");
		lblList.setBounds(242, 224, 400, 14);
		JList list = new JList();
		list.setBounds(242, 248, 400, 87);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		contentPane.add(lblList);
		contentPane.add(list);
		
		// Add Item
		JButton btnAddItem = new JButton("Adicionar Items");
		btnAddItem.setBounds(242, 346, 150, 23);
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnAddItem);
		
		// Delete Item
		JButton btnDeleteItem = new JButton("Remover Item");
		btnDeleteItem.setBounds(492, 346, 150, 23);
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
		lblServiceTax.setBounds(242, 388, 150, 14);
		textServiceTax = new JTextField();
		textServiceTax.setBounds(242, 408, 150, 20);
		textServiceTax.setColumns(30);
		contentPane.add(lblServiceTax);
		contentPane.add(textServiceTax);
	}
	
	// Insert Total Pay Field
	private void TotalField() {
		// Total
		lblTotal = new JLabel("Total");
		lblTotal.setBounds(492, 388, 150, 14);
		lblTotal.setHorizontalAlignment(SwingConstants.TRAILING);
		textTotal = new JTextField();
		textTotal.setBounds(492, 408, 150, 20);
		textTotal.setColumns(30);
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
		btnBackToMenu.setBounds(272, 575, 339, 23);
		contentPane.add(btnBackToMenu);
	}
	
	// Insert Close Order Button
	private void CloseOrderBtn() {
		// Close Order
		JButton btnCloseOrder = new JButton("Gerar Nota Fiscal e finalizar pedido");
		btnCloseOrder.setBounds(242, 491, 400, 23);
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
}
