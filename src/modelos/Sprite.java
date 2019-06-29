package modelos;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Sprite{
	protected BufferedImage spriteQuadro;  
	private int largura, altura;
	protected int linhas, colunas;
	private int x, y;
	public BufferedImage[] sprites;
	private int imagemAtual;
	
	public Sprite(String filename, int aparencia, int _largura, int _altura, int _colunas, int _linhas, int _x, int _y)
			throws IOException {
		
		this.setImagemAtual(aparencia);
		this.spriteQuadro = ImageIO.read(getURL(filename));  
		
		this.largura = spriteQuadro.getWidth()/_colunas;
		this.altura = spriteQuadro.getHeight()/_linhas;
		
		this.linhas = _colunas;
		this.colunas = _linhas;
		this.x = _x;
		this.y = _y;

		setSprites(new BufferedImage[_colunas * _linhas]);
		
		for(int i = 0; i < _colunas; i++) {
			for(int j = 0; j < _linhas; j++) {
				getSprites()[(i * _linhas) + j] = spriteQuadro.getSubimage(i * largura, j * altura, largura, altura);
			}
		}
	}
	public Rectangle getBounds(){return new Rectangle(getX(),
			getY(), getLargura(), getAltura());}
	
	private URL getURL(String filename) {
        URL url = null;
        try {
            url = this.getClass().getResource(filename);
        } catch (Exception e) {}
        return url;
    }
	
	public int getX() {return x;}
	public int getY() {return y;}
	public int getLargura() {return largura;}
	public int getAltura() {return altura;}
	public int getImagemAtual() {return imagemAtual;}
	
	public void setX(int x) {this.x = x;}
	public void setY(int y) {this.y = y;}
	public void setImagemAtual(int imagemAtual) {this.imagemAtual = imagemAtual;}
	public BufferedImage[] getSprites() {
		return sprites;
	}
	public void setSprites(BufferedImage[] sprites) {
		this.sprites = sprites;
	}
}