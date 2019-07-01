package controle;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Utilidades.Xml;
import view.Resultado;
import view.TelaCreditos;
import view.TelaMenu;

public class ControleTelaMenu extends JFrame{
	private static final long serialVersionUID = 1L;

	private JPanel pnlOpcoes, pnlTipos, pnlEntrada;
	
	public ControleTelaMenu(TelaMenu telaMenu, Resultado resultado, String nomeJogo) {
		super(nomeJogo);
		telaMenu.getNomeJLabel().setFont(telaMenu.getFonteFont());
		telaMenu.getNomeField().setFont(telaMenu.getFonteFont());
		setLayout(null);
		
		pnlOpcoes = new JPanel();
		pnlOpcoes.setBounds(310, 10, 300, 300);
		pnlOpcoes.setBackground(new Color(255,255,255,0));
		
		pnlTipos = new JPanel();
		pnlTipos.setBounds(310, 10, 300, 400);
		pnlTipos.setBackground(new Color(255,255,255,0));
		
		pnlEntrada = new JPanel();
		pnlEntrada.setBounds(260, 330, 400, 100);
		pnlEntrada.setBackground(new Color(255,255,255,0));
		
		pnlTipos.add(telaMenu.getSomaLabel());
		pnlTipos.add(telaMenu.getMultiplicacaoLabel());
		pnlTipos.add(telaMenu.getSubtracaoLabel());
		pnlTipos.add(telaMenu.getDivisaoLabel());
		pnlTipos.add(telaMenu.getTodasLabel());
		pnlTipos.add(telaMenu.getVoltarLabel());
		esconderTelaSecundaria(telaMenu);
		
//		add(telaMenu.getMultiplayer()).setBounds(288,405,224,52);
		pnlOpcoes.add(telaMenu.getJogar());//370
		pnlOpcoes.add(telaMenu.getOpcoesJogoLabel());//410
		pnlOpcoes.add(telaMenu.getScoreLabel());//455
		pnlOpcoes.add(telaMenu.getCreditosLabel());//490
		pnlOpcoes.add(telaMenu.getSairLabel());//490
		
		pnlEntrada.add(telaMenu.getNomeJLabel());//600
		pnlEntrada.add(telaMenu.getNomeField());//605
		add(telaMenu.getInformacaoNomeJLabel());//600
	
		add(pnlOpcoes);
		add(pnlEntrada);
		add(pnlTipos);
		resultado.setBackground(new Color(255,255,255,0));
		add(resultado);
		add(telaMenu.getMenuImagem()).setBounds(0,0,900,500);
		
		setUndecorated(true);
		setSize(900, 500);//ak//800x680
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(false);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		resultado.getBtnVoltar().addActionListener(e ->{
			resultado.setVisible(false);
			pnlTipos.setVisible(false);
			pnlOpcoes.setVisible(true);
			pnlEntrada.setVisible(true);
		});
		
		telaMenu.getScoreLabel().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				String result = new Xml().resultados();
				resultado.atualizar(result);
				resultado.setVisible(true);
				pnlEntrada.setVisible(false);
				pnlTipos.setVisible(false);
				pnlOpcoes.setVisible(false);
			}
		});
		
		telaMenu.getCreditosLabel().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				new TelaCreditos();
			}
		});
		
		telaMenu.getSairLabel().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				System.exit(0);
			}
		});
		
		telaMenu.getOpcoesJogoLabel().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				if(telaMenu.getNomeField().getText().trim().equals("")){
//					telaMenu.getInformacaoNomeJLabel().setForeground(Color.RED);
//					telaMenu.getInformacaoNomeJLabel().setFont(new Font("serif", Font.ITALIC|Font.BOLD, 20));
//					telaMenu.getInformacaoNomeJLabel().setText("* DIGITE SEU NOME.");
					JOptionPane.showMessageDialog(null, "DIGITE SEU NOME.");
				}else{
					esconderTelaPrimaria(telaMenu);
					mostrarTelaSecundaria(telaMenu);
				}
			}
		});
		
		telaMenu.getVoltarLabel().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				esconderTelaSecundaria(telaMenu);
				mostrarTelaPrimaria(telaMenu);
			}
		});
		
		telaMenu.getDivisaoLabel().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				new ControleTelaDaFase(telaMenu.getNomeField().getText(), 1, "OperaMat");
				esconderTelaSecundaria(telaMenu);
				mostrarTelaPrimaria(telaMenu);
			}
				
		});
		
		telaMenu.getMultiplicacaoLabel().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				new ControleTelaDaFase(telaMenu.getNomeField().getText(), 2, "OperaMat");
				esconderTelaSecundaria(telaMenu);
				mostrarTelaPrimaria(telaMenu);
			}
				
		});
		
		telaMenu.getSomaLabel().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				new ControleTelaDaFase(telaMenu.getNomeField().getText(), 3, "OperaMat");
				esconderTelaSecundaria(telaMenu);
				mostrarTelaPrimaria(telaMenu);
			}
				
		});
		
		telaMenu.getSubtracaoLabel().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				new ControleTelaDaFase(telaMenu.getNomeField().getText(), 4, "OperaMat");
				esconderTelaSecundaria(telaMenu);
				mostrarTelaPrimaria(telaMenu);
			}
				
		});
		
		telaMenu.getTodasLabel().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				new ControleTelaDaFase(telaMenu.getNomeField().getText(), 5, "OperaMat");
				esconderTelaSecundaria(telaMenu);
				mostrarTelaPrimaria(telaMenu);

			}
				
		});
		
//		telaMenu.getMultiplayer().addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e){
//				new ControleTelaDaFase(telaMenu.getNomeField().getText(), 6, "Opera Mat 2D");
//			}
//		});
		telaMenu.getJogar().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				if(!telaMenu.getNomeField().getText().trim().equals("")){
					new ControleTelaDaFase(telaMenu.getNomeField().getText(), 3, "OperaMat");
					esconderTelaSecundaria(telaMenu);
					mostrarTelaPrimaria(telaMenu);
				}else{
//					telaMenu.getInformacaoNomeJLabel().setForeground(Color.RED);
//					telaMenu.getInformacaoNomeJLabel().setFont(new Font("serif", Font.ITALIC|Font.BOLD, 20));
//					telaMenu.getInformacaoNomeJLabel().setText("* DIGITE SEU NOME.");
					
					JOptionPane.showMessageDialog(null, "DIGITE SEU NOME.");
					
				}
			}
		});
		
	
	}
	
	public void esconderTelaSecundaria(TelaMenu menu){
		pnlTipos.setVisible(false);
		pnlOpcoes.setVisible(true);
		pnlEntrada.setVisible(true);
	}
	
	public void esconderTelaPrimaria(TelaMenu menu){
		pnlOpcoes.setVisible(false);
		pnlEntrada.setVisible(false);
		pnlTipos.setVisible(true);
	}
	
	public void mostrarTelaSecundaria(TelaMenu menu){
		pnlOpcoes.setVisible(false);
		pnlEntrada.setVisible(false);
		pnlTipos.setVisible(true);
	}
	
	public void mostrarTelaPrimaria(TelaMenu menu){
		pnlTipos.setVisible(false);
		pnlOpcoes.setVisible(true);
		pnlEntrada.setVisible(true);
	}
}
