package panels;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NotaFiscalFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomeCliente;
	private JTextField textTaxaServico;
	private JTextField textTotal;
	private JTextField textDinheiroRecebido;
	private JTextField textTroco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotaFiscalFrame frame = new NotaFiscalFrame("jose", "100", "300");
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
	public NotaFiscalFrame(String nomeCliente, String valorTaxa, String valorTotal) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nota Fiscal do Pedido");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeCliente = new JLabel("Cliente");
		lblNomeCliente.setBounds(102, 41, 230, 14);
		contentPane.add(lblNomeCliente);
		
		textNomeCliente = new JTextField();
		textNomeCliente.setBounds(102, 66, 230, 20);
		textNomeCliente.setText(nomeCliente);
		textNomeCliente.setEditable(false);
		contentPane.add(textNomeCliente);
		
		JLabel lblTaxaServico = new JLabel("Taxa de Serviço");
		lblTaxaServico.setBounds(102, 97, 109, 14);
		contentPane.add(lblTaxaServico);
		
		textTaxaServico = new JTextField();
		textTaxaServico.setBounds(102, 122, 109, 20);
		textTaxaServico.setText(valorTaxa);
		textTaxaServico.setEditable(false);
		contentPane.add(textTaxaServico);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTotal.setBounds(221, 97, 111, 14);
		contentPane.add(lblTotal);
		
		textTotal = new JTextField();
		textTotal.setHorizontalAlignment(SwingConstants.TRAILING);
		textTotal.setBounds(223, 122, 109, 20);
		textTotal.setText(valorTotal);
		textTotal.setEditable(false);
		contentPane.add(textTotal);
		
		JLabel lblDinheiroRecebido = new JLabel("Dinheiro Recebido");
		lblDinheiroRecebido.setBounds(102, 210, 109, 14);
		contentPane.add(lblDinheiroRecebido);
		
		textDinheiroRecebido = new JTextField();
		textDinheiroRecebido.setBounds(102, 235, 109, 20);
		contentPane.add(textDinheiroRecebido);
		
		JLabel lblTroco = new JLabel("Troco");
		lblTroco.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTroco.setBounds(221, 210, 111, 14);
		contentPane.add(lblTroco);
		
		textTroco = new JTextField();
		textTroco.setHorizontalAlignment(SwingConstants.TRAILING);
		textTroco.setBounds(223, 235, 109, 20);
		textTroco.setEditable(false);
		contentPane.add(textTroco);
		
		JButton btnTroco = new JButton("Calcular Troco");
		btnTroco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double total = Double.parseDouble(textTotal.getText().toString());
				double dinheiroRecebido = Double.parseDouble(textDinheiroRecebido.getText().toString());
				double troco = dinheiroRecebido - total;
				
				textTroco.setText(String.valueOf(troco));				
			}
		});
		btnTroco.setBounds(102, 266, 230, 23);
		contentPane.add(btnTroco);
	}
}
