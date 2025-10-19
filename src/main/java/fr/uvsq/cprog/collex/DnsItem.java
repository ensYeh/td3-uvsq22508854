package fr.uvsq.cprog.collex;

import java.util.Objects;

public class DnsItem {
    
     private NomMachine nom;
    private AdresseIP adresse;

    /**
     * Constructeur principal.
     */
    public DnsItem(NomMachine nom, AdresseIP adresse) {
        if (nom == null || adresse == null) {
            throw new IllegalArgumentException("Nom et adresse ne peuvent pas être null");
        }
        this.nom = nom;
        this.adresse = adresse;
    }

    // Getters et setters
    public NomMachine getNom() {
        return nom;
    }

    public void setNom(NomMachine nom) {
        if (nom == null) {
            throw new IllegalArgumentException("Nom ne peut pas être null");
        }
        this.nom = nom;
    }

    public AdresseIP getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseIP adresse) {
        if (adresse == null) {
            throw new IllegalArgumentException("Adresse ne peut pas être null");
        }
        this.adresse = adresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DnsItem)) return false;
        DnsItem item = (DnsItem) o;
        return Objects.equals(nom, item.nom) && Objects.equals(adresse, item.adresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, adresse);
    }

    @Override
    public String toString() {
        return adresse + " " + nom;
    }






}
