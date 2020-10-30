package Gestion;

import java.util.ArrayList;

public class ListGen<T> {
	private ArrayList<T> liste=new ArrayList<T>();
	private int nbElements;
	
	public ListGen() {
		liste = new ArrayList<T>();
	}
	
	public ListGen(int taille) {
		liste=new ArrayList<T>(taille);
	}
	
	public void Ajout(T element) {
		liste.add(element);
		 nbElements = nbElements + 1;
	}
	
	public void afficher() {
		for(T element:liste) {
			System.out.println(element.toString());
		}
	}
}
