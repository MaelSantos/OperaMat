package controle;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import Utilidades.Xml;
import view.TelaCreditos;
import view.TelaMenu;

public class ControleTelaMenu extends JFrame{
	private static final long serialVersionUID = 1L;

	public ControleTelaMenu(TelaMenu telaMenu, String nomeJogo) {
		super(nomeJogo);
		telaMenu.getNomeJLabel().setFont(telaMenu.getFonteFont());
		telaMenu.getNomeField().setFont(telaMenu.getFonteFont());
		setLayout(null);
		
		
		add(telaMenu.getMultiplicacaoLabel()).setBounds(295,403,255,40);
		add(telaMenu.getSomaLabel()).setBounds(325,475,180,40);
		add(telaMenu.getSubtracaoLabel()).setBounds(310,440,210,40);
		add(telaMenu.getTodasLabel()).setBounds(340,510,150,40);
		add(telaMenu.getVoltarLabel()).setBounds(340, 550, 150, 40);
		add(telaMenu.getDivisaoLabel()).setBounds(348,370,150,40);
		esconderTelaSecundaria(telaMenu);
		
		//add(telaMenu.getMultiplayer()).setBounds(288,405,224,52);
		add(telaMenu.getJogar()).setBounds(285,370,243,53);
		add(telaMenu.getOpcoesJogoLabel()).setBounds(280,410,240,52);
		add(telaMenu.getScoreLabel()).setBounds(295,455,220,48);
		add(telaMenu.getCreditosLabel()).setBounds(315,490,174,48);
		add(telaMenu.getNomeJLabel()).setBounds(20,600,250,40);
		add(telaMenu.getNomeField()).setBounds(220,605,300,40);
		add(telaMenu.getInformacaoNomeJLabel()).setBounds(530, 600, 250, 40);
	
		add(telaMenu.getMenuImagem()).setBounds(-5,0,800,600);
			
		setSize(800, 650);
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(false);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		telaMenu.getScoreLabel().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				new Xml().exibir();
			}
		});
		
		telaMenu.getCreditosLabel().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				new TelaCreditos();
			}
		});
		
		telaMenu.getOpcoesJogoLabel().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				if(telaMenu.getNomeField().getText().equals("")){
					telaMenu.getInformacaoNomeJLabel().setForeground(Color.RED);
					telaMenu.getInformacaoNomeJLabel().setFont(new Font("serif", Font.ITALIC|Font.BOLD, 20));
					telaMenu.getInformacaoNomeJLabel().setText("* DIGITE SEU NOME.");
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
				new ControleTelaDaFase(telaMenu.getNomeField().getText(), 1, "Opera Mat 2D");
				esconderTelaSecundaria(telaMenu);
				mostrarTelaPrimaria(telaMenu);
			}
				
		});
		
		telaMenu.getMultiplicacaoLabel().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				new ControleTelaDaFase(telaMenu.getNomeField().getText(), 2, "Opera Mat 2D");
				esconderTelaSecundaria(telaMenu);
				mostrarTelaPrimaria(telaMenu);
			}
				
		});
		
		telaMenu.getSomaLabel().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				new ControleTelaDaFase(telaMenu.getNomeField().getText(), 3, "Opera Mat 2D");
				esconderTelaSecundaria(telaMenu);
				mostrarTelaPrimaria(telaMenu);
			}
				
		});
		
		telaMenu.getSubtracaoLabel().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				new ControleTelaDaFase(telaMenu.getNomeField().getText(), 4, "Opera Mat 2D");
				esconderTelaSecundaria(telaMenu);
				mostrarTelaPrimaria(telaMenu);
			}
				
		});
		
		telaMenu.getTodasLabel().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				new ControleTelaDaFase(telaMenu.getNomeField().getText(), 5, "Opera Mat 2D");
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
				if(!telaMenu.getNomeField().getText().equals("")){
					new ControleTelaDaFase(telaMenu.getNomeField().getText(), 3, "Opera Mat 2D");
					esconderTelaSecundaria(telaMenu);
					mostrarTelaPrimaria(telaMenu);
				}else{
					telaMenu.getInformacaoNomeJLabel().setForeground(Color.RED);
					telaMenu.getInformacaoNomeJLabel().setFont(new Font("serif", Font.ITALIC|Font.BOLD, 20));
					telaMenu.getInformacaoNomeJLabel().setText("* DIGITE SEU NOME.");
				}
			}
		});
		
	
	}
	
	
	
	public void esconderTelaSecundaria(TelaMenu menu){
		menu.getDivisaoLabel().setVisible(false);
		menu.getMultiplicacaoLabel().setVisible(false);
		menu.getSomaLabel().setVisible(false);
		menu.getSubtracaoLabel().setVisible(false);
		menu.getTodasLabel().setVisible(false);
		menu.getVoltarLabel().setVisible(false);
	}
	
	public void esconderTelaPrimaria(TelaMenu menu){
		menu.getJogar().setVisible(false);
		menu.getOpcoesJogoLabel().setVisible(false);
		menu.getCreditosLabel().setVisible(false);
		menu.getScoreLabel().setVisible(false);
		menu.getMultiplayer().setVisible(false);
	}
	
	public void mostrarTelaSecundaria(TelaMenu menu){
		menu.getSomaLabel().setVisible(true);
		menu.getSubtracaoLabel().setVisible(true);
		menu.getDivisaoLabel().setVisible(true);
		menu.getMultiplicacaoLabel().setVisible(true);
		menu.getTodasLabel().setVisible(true);
		menu.getVoltarLabel().setVisible(true);
	}
	
	public void mostrarTelaPrimaria(TelaMenu menu){
		menu.getJogar().setVisible(true);
		menu.getOpcoesJogoLabel().setVisible(true);
		menu.getCreditosLabel().setVisible(true);
		menu.getScoreLabel().setVisible(true);
		menu.getMultiplayer().setVisible(true);
	}
}
