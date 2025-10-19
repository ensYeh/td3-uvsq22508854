package fr.uvsq.cprog.collex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Dns {
    
      private List<DnsItem> base;

    public Dns() {
        base = new ArrayList<>();
    }

    /**
     * Retourne un DnsItem à partir d'une adresse IP.
     */
    public DnsItem getItem(AdressIp adresse) {
        for (DnsItem item : base) {
            if (item.getAdresse().equals(adresse)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Retourne un DnsItem à partir d'un nom de machine.
     */
    public DnsItem getItem(NomMachine nom) {
        for (DnsItem item : base) {
            if (item.getNom().equals(nom)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Retourne la liste des items d’un domaine donné.
     */
    public List<DnsItem> getItems(String domaine) {
        List<DnsItem> result = new ArrayList<>();
        for (DnsItem item : base) {
            if (item.getNom().getDomaine().equals(domaine)) {
                result.add(item);
            }
        }
        Collections.sort(result, Comparator.comparing(o -> o.getNom().getNomMachine()));
        return result;
    }

    /**
     * Ajoute une nouvelle entrée dans la base DNS.
     */
    public void addItem(String adresse, String nomMachine) {
        AdressIp adr = new AdressIp(adresse);
        NomMachine nom = new NomMachine(nomMachine);

        if (getItem(adr) != null)
            throw new IllegalArgumentException("ERREUR : L'adresse IP existe déjà !");
        if (getItem(nom) != null)
            throw new IllegalArgumentException("ERREUR : Le nom de machine existe déjà !");

        base.add(new DnsItem(adr, nom));
    }

    /**
     * Retourne la taille de la base.
     */
    public int size() {
        return base.size();
    }



}
