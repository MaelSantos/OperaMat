package controle;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.Mensagem;
import view.TelaDaFase;

public class ControleTelaDaFase extends JFrame {
	private static final long serialVersionUID = 1L;
	ControleDaFase game;
	TelaDaFase tela = new TelaDaFase();
	
	public ControleTelaDaFase(String _usuario, int estagio, String nomeJogo){
		super(nomeJogo);
		
		Container fase = getContentPane();
		fase.setLayout(new BorderLayout());
		
		Container botoes = new JPanel();
		botoes.setLayout(new FlowLayout());
		
		tela.getVoltarMenuLabel().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				if (Mensagem.exibirMensagemVoltaMenu()){
						game = null;
						tela = null;
						dispose();
					}
			}
		});
		
		tela.getReiniciarLabel().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				game.resetar();
			}
		});
		
		botoes.add(tela.getVoltarMenuLabel());
		botoes.add(tela.getReiniciarLabel());
		
		if(estagio == 1){
			add(game =  new ControleDaFase(_usuario, 1, false, false),BorderLayout.CENTER);
		}
		if(estagio == 2){
			add(game =  new ControleDaFase(_usuario, 2, false, false),BorderLayout.CENTER);
		}
		if(estagio == 3){
			add(game =  new ControleDaFase(_usuario, 3, false, false),BorderLayout.CENTER);
		}
		if(estagio == 4){
			add(game =  new ControleDaFase(_usuario, 4, false, false),BorderLayout.CENTER);
		}
		if(estagio == 5){
			add(game =  new ControleDaFase(_usuario, 5, true, false),BorderLayout.CENTER);
		}
		if(estagio == 6){
			add(game =  new ControleDaFase(_usuario, 3, false, true),BorderLayout.CENTER);
		}

		add(botoes,BorderLayout.SOUTH);
		
		setSize(900,560);//1000,660
		setUndecorated(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setFocusable(false);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}
}
