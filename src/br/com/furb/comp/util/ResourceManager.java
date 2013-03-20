package br.com.furb.comp.util;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Singleton responsável por manipular as imagens da aplicação.
 */
public class ResourceManager {

	private static ResourceManager instance;
	private static final String path = "resources/images/";

	private ResourceManager() {
	}

	/**
	 * Retorna a instância do ResourceManager
	 * 
	 * @return {@link ResourceManager} o singleton.
	 */
	public static ResourceManager getInstance() {
		if (instance == null) {
			instance = new ResourceManager();
		}
		return instance;
	}

	/**
	 * Carrega um ícone.
	 * 
	 * @param fileName
	 *            caminho do ícone.
	 * @return ImageIcon o ícone.
	 */
	public Icon loadImageIcon(String fileName) {
		URL resource = getClass().getClassLoader().getResource(path + fileName + ".png");
		return new ImageIcon(resource);
	}
}
