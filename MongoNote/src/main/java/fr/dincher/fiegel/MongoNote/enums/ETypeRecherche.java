package fr.dincher.fiegel.MongoNote.enums;

import java.util.ArrayList;
import java.util.List;

public enum ETypeRecherche {

	TITRE("Titre"),
	CONTENU("Contenu"),
	HASHTAGS("Hashtags");
	
	private String intitule;
	
	private ETypeRecherche(String intitule){
		this.intitule=intitule;
	}
	
	public String getIntitule(){
		return intitule;
	}
	
	public static ETypeRecherche getFormationParNom(String nom){
		for (ETypeRecherche formation : ETypeRecherche.values()) {
			if (formation.getIntitule().equalsIgnoreCase(nom) || formation.name().equalsIgnoreCase(nom)) {
				return formation;
			}
		}
		return null;
	}
	
	public static List<String> getListETypeRecherche(){
		List<String> liste = new ArrayList<String>();
		for (ETypeRecherche formation : ETypeRecherche.values()) {
			liste.add(formation.intitule);
		}
		return liste;
	}
	
	public static Object[] getArrayFormation(){
		return getListETypeRecherche().toArray();
	}
}
