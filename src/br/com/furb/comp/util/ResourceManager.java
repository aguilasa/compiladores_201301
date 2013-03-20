package br.com.furb.comp.util;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Singleton respons�vel por manipular as imagens da aplica��o.
 */
public class ResourceManager {

	private static ResourceManager instance;
	private static final String path = "resources/images/";

	private ResourceManager() {
	}

	/**
	 * Retorna a inst�ncia do ResourceManager
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
	 * Carrega um �cone.
	 * 
	 * @param fileName
	 *            caminho do �cone.
	 * @return ImageIcon o �cone.
	 */
	public Icon loadImageIcon(String fileName) {
		URL resource = getClass().getClassLoader().getResource(path + fileName + ".png");
		return new ImageIcon(resource);
	}
}
