package controle;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Utilidades.Xml;
import view.Mensagem;
import modelos.Tigre;
import modelos.Sprite;

public class ControleDaFase extends JPanel{
	private static final long serialVersionUID = 1L;
	
	static int LARGURA_JANELA = 1000;
	static int ALTURA_JANELA = 600;
	private Sprite mira;
	private Sprite miraMult;
	private ArrayList<Tigre> tigres = new ArrayList<>();
	private ArrayList<Integer> primeiroAlgarismo = new ArrayList<Integer>();
	private ImageIcon background;
	private ImageIcon lifeIcon = new ImageIcon(getClass().getResource("vida.png"));
	private Image lifImage = lifeIcon.getImage();
	private int life = 5;
	private int lifeMult = 5;
	private int pontos = 0;
	private int pontosMult = 0;
	private boolean fire = false;
	private boolean fireMult = false;
	private Random rand = new Random();
	private  Game game;
	private String resultado = "";
	private int velocidade = 30;//15
	private String jogador;
	private int auxSoma;
	private int auxSubtracao;
	private int auxMultiplicacao;
	private int estagio;
	private boolean fasesMisturadas;
	private boolean multiplayer;
	
	public ControleDaFase(String _usuario, int _estagio, boolean _todasFases, boolean _multiplayer){	
		
		if(_estagio == 5){
			this.estagio = _estagio-1;
		}else{
			this.estagio = _estagio;
		}
		
		this.jogador = _usuario;
		this.fasesMisturadas = _todasFases;
		this.multiplayer = _multiplayer;
		
		criarPrimeiroAlgarismo();
		criarTigre();
		criarMira();
		
		Collections.shuffle(primeiroAlgarismo);
		Collections.shuffle(tigres);
		
		game = new Game();
		game.start();
				
		background = new ImageIcon(getClass().getResource("backgroundFase.png"));//telaDeFundo.png
		
		if(!multiplayer){
		addMouseListener(new MouseAdapter());
		addMouseMotionListener(new MouseAdapter());
		}
		
		if(multiplayer)
			addKeyListener(new TAdapter());
	}
	
	public void criarMira(){
		try {
//			mira = new Sprite("mira.png", 0, 12, 11, 1, 1, LARGURA_JANELA/2, ALTURA_JANELA/2);
			mira = new Sprite("rede.png", 0, 12, 11, 1, 1, LARGURA_JANELA/2, ALTURA_JANELA/2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(multiplayer){
			try {
				miraMult = new Sprite("rede.png", 0, 12, 11, 1, 1, LARGURA_JANELA/2, ALTURA_JANELA/2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void criarTigre(){
		
		for(int i = 0; i<21; i++){
			try {
//				tigres.add( new Tigre("tigre.png", 0, 100, 100,4,4,
//						430, 550 +(i*106), primeiroAlgarismo.get(i) * (rand.nextInt(9)+1),true));
				tigres.add( new Tigre("borbolet.png", 0, 96, 80, 10, 1,
						430, 480 +(i*106), primeiroAlgarismo.get(i) * (rand.nextInt(9)+1),true));
				
//				System.out.println(tigres.get(0).getSprites().length);
//				System.exit(0);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void criarPrimeiroAlgarismo(){
		int[] base = {2,3,4,5,6,7,8,9,10};
		for( int i = 0; i<22 ; i++){
			if(i<8){
				primeiroAlgarismo.add(base[i]);
			}else{
				primeiroAlgarismo.add(base[rand.nextInt(9)]);
			}
		}
	}
	
	public void desenharMira(Graphics g){
		g.drawImage(mira.sprites[mira.getImagemAtual()], mira.getX() - 27, mira.getY() - 37, this);
//		g.drawOval(mira.getX()-15, mira.getY()-17, 30, 30);
//		g.drawOval(mira.getX()-30, mira.getY()-32, 60, 60);
		
		if(multiplayer){
			g.drawImage(miraMult.sprites[miraMult.getImagemAtual()], miraMult.getX() - 27, miraMult.getY() - 27, this);
//			g.drawOval(miraMult.getX()-15, miraMult.getY()-17, 30, 30);
//			g.drawOval(miraMult.getX()-30, miraMult.getY()-32, 60, 60);
		}
	}
	
	public void desenharFundo(Graphics g){
		g.drawImage(background.getImage(), 0, 0, this);
	}
	
	public void desenharTigres(Graphics g){
		for(Tigre tigre: tigres){
			if(tigre.isVida()){
				//bug
				try{
//				System.out.println(tigre.getImagemAtual());
				
				g.drawImage(tigre.sprites[tigre.getImagemAtual()],
						tigre.getX(), tigre.getY(), this);
				g.setColor(Color.BLACK);
				g.drawString("" + tigre.getNumero(), tigre.getX()+40, tigre.getY()+20);
				}catch (Exception e){
					System.exit(0);
				}
			}
		}
	}
	
	public void desenharLife(Graphics g){
		for (int i=0; i<life; i++){
			if(this.life > 0){
				g.drawImage(lifImage, 750+(i*30), 8, this);
			}
		}
		
		if(multiplayer){
			for (int i=0; i<lifeMult; i++){
				if(this.lifeMult > 0){
					g.drawImage(lifImage, 750+(i*30),8, this);
				}
			}
		}
	}
	
	public void desenharInformacoesSoma(Graphics g){
		String a="Capture a borboleta";
		
		if(estagio == 1){
			g.setFont(new Font("Arial", Font.CENTER_BASELINE, 17));
			g.drawString("Jogador: "+jogador , 10, 30);
			g.drawString("Pontuação: " + pontos + " Pontos", 300, 30);
			g.drawString("Vidas:" , 690, 30);
			g.setFont(new Font("Arial", Font.BOLD, 35));
			g.drawString("divisivel por "+ primeiroAlgarismo.get(0),310,290);
//			g.drawString(""+ primeiroAlgarismo.get(0),300,310);
//			g.drawString(""+ primeiroAlgarismo.get(0),415,350);
		}
		
		if(estagio == 2){
			g.setFont(new Font("Arial", Font.CENTER_BASELINE, 17));
			g.drawString("Jogador: "+jogador , 10, 30);
			g.drawString("Pontuação: " + pontos + " Pontos", 300, 30);
			g.drawString("Vidas:" , 690, 30);
			g.setFont(new Font("Arial", Font.BOLD, 35));
			g.drawString(primeiroAlgarismo.get(0) + " x " +	auxMultiplicacao,400,290);
			
		}
		if(estagio == 3 && !multiplayer){
			g.setFont(new Font("Arial", Font.CENTER_BASELINE, 17));
			g.drawString("Jogador: "+jogador , 10, 30);
			g.drawString("Pontuação: " + pontos + " Pontos", 300, 30);
			g.drawString("Vidas:" , 690, 30);
			g.setFont(new Font("Arial", Font.BOLD, 35));
			g.drawString(primeiroAlgarismo.get(0) + " + " + auxSoma, 400, 290);
		}
		if(estagio == 4){
			g.setFont(new Font("Arial", Font.CENTER_BASELINE, 17));
			g.drawString("Jogador: "+jogador , 10, 30);
			g.drawString("Pontuação: " + pontos + " Pontos", 300, 30);
			g.drawString("Vidas:" , 690, 30);
			g.setFont(new Font("Arial", Font.BOLD, 35));
			g.drawString(primeiroAlgarismo.get(0) + " - " + auxSubtracao,400,290);
		}
		if(estagio == 3 && multiplayer){
			g.drawString("Jogador 01" , 820, 80);
			g.drawString("" + pontos + " Pontos", 820, 110);
			g.drawString("Vidas" , 820, 140);
			
			g.drawString("Jogador 02" , 820, 230);
			g.drawString("" + pontosMult + " Pontos", 820, 260);
			g.drawString("Vidas" , 820, 290);
			
			
//			g.drawString("Acerte um",830,400);
//			g.drawString("número que é",830,430);
//			g.drawString("solução de ",830,460);
			g.drawString(primeiroAlgarismo.get(0) + " + " + auxSoma,830,490);
		}
		
	}
	
	public void checarColisaoDivisao(){
		for(Tigre tigre: tigres){
			if(tigre.isVida()&&tigre.getBounds().intersects(mira.getBounds())){
				if(this.fire == true){
					if(tigre.getNumero() % primeiroAlgarismo.get(0)!=0){
						tigre.setVida(false);
						life --;
						resultado += tigre.getNumero() + " : " + primeiroAlgarismo.get(0)+ " (ERROU!)\n";
						primeiroAlgarismo.remove(0);		
					}else{
						resultado += tigre.getNumero() + " : " + primeiroAlgarismo.get(0)+ " (ACERTOU!)\n";
						tigre.setVida(false);
						primeiroAlgarismo.remove(0);
						pontos ++;
					}
					alternarFases();
				}
			}
		}
	}
	
	public void checarColisaoMultiplicacao(){
		for(Tigre tigre: tigres){
			if(tigre.isVida()&&tigre.getBounds().intersects(mira.getBounds())){
				if(this.fire == true){
					if(tigre.getNumero() != (primeiroAlgarismo.get(0)*auxMultiplicacao)){
						tigre.setVida(false);
						life --;
						resultado += "(" + primeiroAlgarismo.get(0)+ " * " + auxMultiplicacao + ") : (ERROU!)\n";
						primeiroAlgarismo.remove(0);		
					}else{
						resultado += "("+  primeiroAlgarismo.get(0)+ " * "+ auxMultiplicacao + ") : (ACERTOU!)\n";
						tigre.setVida(false);
						primeiroAlgarismo.remove(0);
						pontos ++;
					}
					alternarFases();
				}
			}
		}
	}
	
	public void checarColisaoSoma(){
		for(Tigre tigre: tigres){
			if(tigre.isVida()&&tigre.getBounds().intersects(mira.getBounds())){
				if(this.fire == true){
					if(tigre.getNumero() != (primeiroAlgarismo.get(0)+ auxSoma)){
						tigre.setVida(false);
						life --;
						if(!multiplayer)
							resultado += "(" + primeiroAlgarismo.get(0)+ " + " + auxSoma + ") : (ERROU!)\n";
						primeiroAlgarismo.remove(0);		
					}else{
						if(!multiplayer)
							resultado += "("+  primeiroAlgarismo.get(0)+ " + "+ auxSoma + ") : (ACERTOU!)\n";
						tigre.setVida(false);
						primeiroAlgarismo.remove(0);
						pontos ++;
					}
					alternarFases();
				}
			}
			if(multiplayer){
				if(tigre.isVida()&&tigre.getBounds().intersects(miraMult.getBounds())){
					if(this.fireMult == true){
						if(tigre.getNumero() != (primeiroAlgarismo.get(0)+ auxSoma)){
							tigre.setVida(false);
							lifeMult --;
							primeiroAlgarismo.remove(0);		
						}else{
							tigre.setVida(false);
							primeiroAlgarismo.remove(0);
							pontosMult ++;
						}
					}
				}
			}
		}
	}
	
	public void checarColisaoSubtracao(){
		for(Tigre tigre: tigres){
			if(tigre.isVida()&&tigre.getBounds().intersects(mira.getBounds())){
				if(this.fire == true){
					if(tigre.getNumero() != (primeiroAlgarismo.get(0) - auxSubtracao)){
						tigre.setVida(false);
						life --;
						resultado += "(" + primeiroAlgarismo.get(0)+ " - " + auxSubtracao + ") : (ERROU!)\n";
						primeiroAlgarismo.remove(0);		
					}else{
						resultado += "("+  primeiroAlgarismo.get(0)+ " - "+ auxSubtracao + ") : (ACERTOU!)\n";
						tigre.setVida(false);
						primeiroAlgarismo.remove(0);
						pontos ++;
					}
					alternarFases();
				}
			}
		}
	}
	
	public void fimDeJogo(){
		if(!multiplayer){
			if(this.life <= 0 || this.pontos == 21 ){
				tigres.removeAll(tigres);
//				10 / 21 = 0.476190476
				new Xml().add_usuario(jogador, this.resultado+ "NOTA: " +((int)(pontos*0.476190476))+ "\n\n");
				Mensagem.exibirMensagemFimJogo(jogador, resultado, pontos);
				life =1;
				pontos = 1;
			}
		}
		if(multiplayer){
			if(this.lifeMult <= 0 || this.pontosMult == 21 || this.life <= 0 || this.pontos == 21 || this.pontosMult + this.pontos==21){
				tigres.removeAll(tigres);
				Mensagem.exibirMensagemFimJogoMult(pontos, pontosMult);
				lifeMult = 1;
				pontosMult = 1;
				life =1;
				pontos = 1;
				
			}
		}
	}
	
	public void moverTigre(){
		for(Tigre tigre: tigres){
		rodarTigreNaTela(tigre);	
		}
	}
	
	public void resetar(){
			this.primeiroAlgarismo.removeAll(primeiroAlgarismo);
			this.tigres.removeAll(tigres);
			
			this.pontos = 0;
			this.life = 5;
			this.resultado = "";
			
			if(multiplayer){
				this.pontosMult = 0;
				this.lifeMult = 5;
			}
			
			criarPrimeiroAlgarismo();
			criarTigre();
			criarMira();
			
			Collections.shuffle(primeiroAlgarismo);
			Collections.shuffle(tigres);
			
	}
	
	public void update(){
		moverTigre();
		fimDeJogo();
		
		if(estagio == 1){
			checarColisaoDivisao();
			atualizarValoresDivisao();
		}
		if(estagio == 2){
			checarColisaoMultiplicacao();
			atualizarValoresMultiplicacao();
		}
		if(estagio == 3){
			checarColisaoSoma();
			atualizarValoresSoma();
		}
		if(estagio == 4){
			checarColisaoSubtracao();
			atualizarValoresSubtracao();
		}
	}
	
	public void paint(Graphics g) {
		g.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		desenharFundo(g);
		g.setColor(Color.WHITE);
		desenharTigres(g);
		g.setColor(Color.BLACK);
		desenharMira(g);
		desenharLife(g);
		desenharInformacoesSoma(g);
		requestFocus();
	}
	
	public void atualizarValoresDivisao(){
		int auxiliar = 0;
		int divisores[] = {10,9,8,7,6,5,4,3,2};
		for(Tigre tigre: tigres){
			if(tigre.isVida() && tigre.getNumero() % primeiroAlgarismo.get(0)==0){
				auxiliar = 0;
				break;
			}else{
				auxiliar ++;
			}
		}
		if(auxiliar>0){
			for(Tigre tigre: tigres){
				for(int j = 0; j < tigres.size(); j++){
					if(tigre.isVida() && tigre.getNumero() % divisores[j]==0){
						primeiroAlgarismo.set(0, divisores[j]);
						break;
					}
				}	
			}
		}
	}
	
	public void atualizarValoresMultiplicacao(){
		int auxiliar = 0;
		int divisores[] = {10,9,8,7,6,5,4,3,2};
		for(Tigre tigre: tigres){
			if(tigre.isVida() && tigre.getNumero()== primeiroAlgarismo.get(0)*auxMultiplicacao){
				auxiliar = 0;
				break;
			}else{
				auxiliar ++;
			}
		}
		if(auxiliar>0){
			for(Tigre tigre: tigres){
				for(int j = 0; j < tigres.size(); j++){
					if(tigre.isVida() && tigre.getNumero() % divisores[j]==0){
						primeiroAlgarismo.set(0, divisores[j]);
						auxMultiplicacao = tigre.getNumero()/divisores[j];
						break;
					}
				}	
			}
		}
	}
	
	public void atualizarValoresSoma(){
		int auxiliar = 0;
		for(Tigre tigre: tigres){
			if(tigre.isVida() && tigre.getNumero() == primeiroAlgarismo.get(0) + auxSoma){
				auxiliar = 0;
				break;
			}else{
				auxiliar ++;
			}
		}
		
		if(auxiliar>0){
			for(Tigre tigre: tigres){
				for(int j = 0; j < tigres.size(); j++){
					if(tigre.isVida()){
						if(tigre.getNumero() > primeiroAlgarismo.get(0)){
							auxSoma = tigre.getNumero() - primeiroAlgarismo.get(0);
						}
						if(tigre.getNumero() < primeiroAlgarismo.get(0)){
							primeiroAlgarismo.set(0, tigre.getNumero() - 1);
							auxSoma = tigre.getNumero() - primeiroAlgarismo.get(0);
						}
						if(tigre.getNumero() == primeiroAlgarismo.get(0)){
							primeiroAlgarismo.set(0, primeiroAlgarismo.get(0)-1);
							auxSoma = tigre.getNumero() - primeiroAlgarismo.get(0);
						}
						if(tigre.getNumero()==0){
							auxSoma = 0;
							primeiroAlgarismo.set(0, 0);
						}
						break;
					}
				}	
			}
		}
	}
	
	public void atualizarValoresSubtracao(){
		int auxiliar = 0;
		for(Tigre tigre: tigres){
			if((tigre.isVida() && tigre.getNumero() == primeiroAlgarismo.get(0) - auxSubtracao)&&
					(tigre.isVida() && tigre.getNumero()> primeiroAlgarismo.get(0))){
				auxiliar = 0;
				break;
			}else{
				auxiliar ++;
			}
		}
		
		if(auxiliar>0){
			for(Tigre tigre: tigres){
				for(int j = 0; j < tigres.size(); j++){
					if(tigre.isVida()){
						if(tigre.getNumero() >= primeiroAlgarismo.get(0)){
							primeiroAlgarismo.set(0,tigre.getNumero() + primeiroAlgarismo.get(0));
							auxSubtracao = (primeiroAlgarismo.get(0) + tigre.getNumero()) - (tigre.getNumero()+tigre.getNumero());
						}else{
							auxSubtracao = (primeiroAlgarismo.get(0) + tigre.getNumero()) - (tigre.getNumero()+tigre.getNumero());
						}
						break;
					}
				}	
			}
		}
	}
	
	
	
	public void alternarFases(){
		if(fasesMisturadas == true){
			this.estagio = rand.nextInt(3)+1;
		}
	}
	
	void rodarTigreNaTela(Tigre tigre){
		if(tigre.getX()==430 && tigre.getY()==430){
			tigre.xCrescente = false; //direita
			tigre.yCrescente = false; //cima
			tigre.xDecrescente = true; //esquerda
			tigre.yDecrescente = false; //baixo
		}
		
		if(tigre.xDecrescente == true){ //move e anima para a direita
			tigre.setX(tigre.getX() - 2);
			switch (tigre.left) {
			case 0:
				tigre.setImagemAtual(2);
				break;
			case 1:
				tigre.setImagemAtual(3);
				break;
			case 2:
				tigre.setImagemAtual(4);
				break;
			case 3:
				tigre.setImagemAtual(5);
				break;
//			case 4:
//				tigre.setImagemAtual(6);
//				break;
//			case 5:
//				tigre.setImagemAtual(6);
//				break;
//			case 6:
//				tigre.setImagemAtual(7);
//				break;
//			case 7:
//				tigre.setImagemAtual(8);
//				break;
//			case 8:
//				tigre.setImagemAtual(9);
//				break;
			}
			if (tigre.left==3) tigre.left=0;
			else tigre.left++;		
		}
		if(tigre.getX() == 50){ //move para cima
			tigre.xDecrescente = false;
			tigre.yDecrescente = true;
		}
		if(tigre.yDecrescente == true){ //anima e move para cima 
			tigre.setY(tigre.getY() - 2);
			switch (tigre.up) {
			case 0:
				tigre.setImagemAtual(2);
				break;
			case 1:
				tigre.setImagemAtual(3);
				break;
			case 2:
				tigre.setImagemAtual(4);
				break;
			case 3:
				tigre.setImagemAtual(5);
				break;
			}
			
			if (tigre.up==3) tigre.up=0;
			else tigre.up++;
		}
		if(tigre.getY() == 50){ //move para baixo
			tigre.yDecrescente = false;
			tigre.xCrescente = true;
		}
		if(tigre.xCrescente==true){ //move e anima para direita
			tigre.setX(tigre.getX()+2);
			switch (tigre.right) {
			case 0:
				tigre.setImagemAtual(2);
				break;
			case 1:
				tigre.setImagemAtual(3);
				break;
			case 2:
				tigre.setImagemAtual(4);
				break;
			case 3:
				tigre.setImagemAtual(5);
				break;
//			case 4:
//				tigre.setImagemAtual(6);
//				break;
			}
			if (tigre.right==3) tigre.right=0;
			else tigre.right++;	
		}
//		if(tigre.getY() == 50 && tigre.getX()==690){ //move para baixo
		if(tigre.getY() == 50 && tigre.getX()==780){ //move para baixo
			tigre.xCrescente = false;
			tigre.yCrescente = true;
		}
		//ak
		if(tigre.yCrescente==true){
			tigre.setY(tigre.getY() + 2);
			switch (tigre.down) {
			case 0:
				tigre.setImagemAtual(2);
				break;
			case 1:
				tigre.setImagemAtual(3);
				break;
			case 2:
				tigre.setImagemAtual(4);
				break;
			case 3:
				tigre.setImagemAtual(5);
				break;
//			case 4:
//				tigre.setImagemAtual(6);
//				break;
				}
			if (tigre.down==3) tigre.down=0;
			else tigre.down++;
		}
		if(tigre.getY() == 430){ //mover para cima
			tigre.yCrescente = false;
			tigre.xDecrescente = true;
		}
	}
	
	private class MouseAdapter implements MouseMotionListener, MouseListener{

		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {
			fire = true;
			try{
				Thread.sleep(50);
			}catch(InterruptedException e1){
				e1.printStackTrace();
			}
			fire = false;
		}
		public void mouseReleased(MouseEvent e) {
			fire = false;	
		}
		public void mouseDragged(MouseEvent e) {
			mira.setX(e.getX());
			mira.setY(e.getY());			
		}
		public void mouseMoved(MouseEvent e) {
			mira.setX(e.getX());
			mira.setY(e.getY());
		}
	}
	
	public class TAdapter implements KeyListener{
		private boolean up,down,left,right,a,s,d,w;
		public void keyPressed(KeyEvent e) {
			if(up || e.getKeyCode() ==  KeyEvent.VK_UP){
				mira.setY(mira.getY()-5);
				up = true;
			}
			if(down || e.getKeyCode() ==  KeyEvent.VK_DOWN){
				mira.setY(mira.getY()+5);
				down = true;
			}
			if(left || e.getKeyCode() ==  KeyEvent.VK_LEFT){
				mira.setX(mira.getX()-5);
				left = true;
			}
			if(right || e.getKeyCode()== KeyEvent.VK_RIGHT){
				mira.setX(mira.getX()+5);
				right = true;
			}
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				fire = true;
				try{
					Thread.sleep(50);
				}catch(InterruptedException e1){
					e1.printStackTrace();
				}
				fire = false;
			}
			if(w || e.getKeyCode() ==  KeyEvent.VK_W){
				miraMult.setY(miraMult.getY()-5);
				w = true;
			}
			if(s || e.getKeyCode() ==  KeyEvent.VK_S){
				miraMult.setY(miraMult.getY()+5);
				s = true;
			}
			if(a || e.getKeyCode() ==  KeyEvent.VK_A){
				miraMult.setX(miraMult.getX()-5);
				a = true;
			}
			if(d || e.getKeyCode()== KeyEvent.VK_D){
				miraMult.setX(miraMult.getX()+5);
				d = true;
			}
			if(e.getKeyCode() == KeyEvent.VK_C){ // N�O ENCONTREI A TECLAS ESPA�O
				fireMult = true;
				try{
					Thread.sleep(50);
				}catch(InterruptedException e1){
					e1.printStackTrace();
				}
				fireMult = false;
			}
		}
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() ==  KeyEvent.VK_UP){up = false;}
			if(e.getKeyCode() ==  KeyEvent.VK_DOWN){down = false;}
			if(e.getKeyCode() ==  KeyEvent.VK_LEFT){left = false;}
			if(e.getKeyCode()== KeyEvent.VK_RIGHT){right = false;}
			if(e.getKeyCode() ==  KeyEvent.VK_W){w = false;}
			if(e.getKeyCode() ==  KeyEvent.VK_S){s = false;}
			if(e.getKeyCode() ==  KeyEvent.VK_A){a = false;}
			if(e.getKeyCode()== KeyEvent.VK_D){d = false;}
		}
		public void keyTyped(KeyEvent e) {}

	}
	
	private class Game extends Thread{
		public void run(){
			while(true){	
				repaint();
				update();
				try {
					Thread.sleep(velocidade);
				} catch (InterruptedException e) {e.printStackTrace();}
			}
		}
	}
}