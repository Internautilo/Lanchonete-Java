package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 800);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewOrder = new JButton("Cadastrar novo pedido");
		btnNewOrder.setBounds(355, 192, 212, 67);
		btnNewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnListOrders = new JButton("Listar Pedidos");
		btnListOrders.setBounds(355, 348, 212, 67);
		btnListOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnEditOrder = new JButton("Editar Pedido");
		btnEditOrder.setBounds(355, 270, 212, 67);
		btnEditOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnDeleteOrder = new JButton("Remover Pedido");
		btnDeleteOrder.setBounds(355, 426, 212, 67);
		btnDeleteOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		contentPane.add(btnNewOrder);
		contentPane.add(btnListOrders);
		contentPane.add(btnEditOrder);
		contentPane.add(btnDeleteOrder);
	}
	
	public void Start() {
		try {
		setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Stop() {
		dispose();
	}
}
