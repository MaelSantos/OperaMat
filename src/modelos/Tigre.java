package modelos;

import java.io.IOException;

 	public class Tigre extends Sprite{
 	
	private int numero;
	private boolean vida;
	public boolean xCrescente = false, yCrescente = false,
					xDecrescente = false, yDecrescente = true;
	public int up = 0, down = 0, left = 0, right = 0;
	
	public Tigre(String filename,int aparencia, int _largura, int _altura,
			int _colunas,int _linhas, int _x, int _y, int _numero, boolean _vida) 
			throws IOException{
	
	super(filename, aparencia, _largura, _altura, _colunas, _linhas, _x, _y);		
	
	this.vida = _vida;
	this.numero = _numero;
	}
	 	
	public int getNumero(){return numero;}
	public void setNumero(int numero) {this.numero = numero;}
	public boolean isVida() {return vida;}
	public void setVida(boolean alive) {this.vida = alive;}
}