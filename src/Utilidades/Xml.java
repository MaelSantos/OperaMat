package Utilidades;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

public class Xml {
	
	private Element loginElement;
	private Document documentoDocument;	
		
	public Xml(){
				
		loginElement = new Element("Nome");
		documentoDocument = new Document(loginElement);	
		ler_arquivo();
	}
	public void ler_arquivo(){
				
		SAXBuilder builderSaxBuilder = new SAXBuilder();
		
	      try {
	            documentoDocument = builderSaxBuilder.build("usuarios.xml");
	            loginElement = documentoDocument.getRootElement();	           
	      } catch (Exception e) {
	    	  try{	
	  			XMLOutputter xmlOut = new XMLOutputter();
	  					FileWriter arquivo = new FileWriter(
	                      new File("usuarios.xml"));
	  					xmlOut.output(documentoDocument, arquivo);
	  		}catch(Exception e1){
	  			e1.printStackTrace();				
	  		};     
	      }
	}
	
	public void pesquisar(String nomeUsuario){
		List<Element> lista = loginElement.getChildren();
		String output = "";
		int contador = 0;
		
		for (Element elemento:lista){
			if (elemento.getChildText("nome").equals(nomeUsuario)){
				output +=  "resultado " + (contador + 1) + " : " +
							elemento.getChildText("resultado") +"\n";
				contador ++;
			}
		}	
		JTextArea outputArea = new JTextArea(20, 20);
		outputArea.setText(output);
		JScrollPane scroller = new JScrollPane(outputArea);
		
		if(contador > 0){
			JOptionPane.showMessageDialog(null ,scroller, "JOGADOR  " + nomeUsuario,
											JOptionPane.INFORMATION_MESSAGE);
		}else{
			JOptionPane.showMessageDialog(null, nomeUsuario + "  N�o encontrado!");
		}
	}
	@Deprecated
	public void exibir(){
		List<Element> lista = loginElement.getChildren();
		String output = "";
		
		for (Element elemento:lista){
				output +=  elemento.getChildText("nome")+ ":\n" +
							elemento.getChildText("resultado") +"\n";
			}
			
		JTextArea outputArea = new JTextArea(20, 20);
		outputArea.setText(output);
		JScrollPane scroller = new JScrollPane(outputArea);
		
	
		JOptionPane.showMessageDialog(null ,scroller, "RESULTADOS",
									JOptionPane.INFORMATION_MESSAGE);	
	}
	
	public String resultados(){
		List<Element> lista = loginElement.getChildren();
		String output = "";
		
		for (Element elemento:lista){
				output +=  elemento.getChildText("nome")+ ":\n" +
							elemento.getChildText("resultado") +"\n";
		}
		
		return output;
	}
	
	public void add_usuario(String _nome, String _resultado){
		Element _usuariosElement = new Element("Usuarios");			
		Element nome = new Element("nome");
		nome.setText(_nome);
		Element resultado = new Element("resultado");
		resultado.setText(_resultado);
		_usuariosElement.addContent(nome);
		_usuariosElement.addContent(resultado);
		loginElement.addContent(_usuariosElement);
		
		try{	
			XMLOutputter xmlOut = new XMLOutputter();
					FileWriter arquivo = new FileWriter(
                    new File("usuarios.xml"));
					xmlOut.output(documentoDocument, arquivo);
					arquivo.flush();
					arquivo.close();
		}catch(Exception e){
			e.printStackTrace();				
		}	
	}
}
