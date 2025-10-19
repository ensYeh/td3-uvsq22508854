package fr.uvsq.cprog.collex;

import java.util.Objects;

public class NomMachine {
   private final String nom;

    /**
     * Constructeur avec validation du format du nom.
     * 
     * @param nom le nom qualifié de la machine
     * @throws IllegalArgumentException si le format est invalide
     */
    public NomMachine(String nom) {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("Le nom de machine ne peut pas être vide.");
        }

        // Vérifie qu'il y a au moins un point et que les segments sont valides
        if (!nom.matches("^[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)+$")) {
            throw new IllegalArgumentException("Nom de machine invalide : " + nom);
        }

        this.nom = nom.toLowerCase(); // pour normaliser (ex: WWW.UVSQ.FR → www.uvsq.fr)
    }

    /**
     * Retourne le nom complet de la machine.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne le domaine (tout sauf la première partie).
     * ex: pour www.uvsq.fr → uvsq.fr
     */
    public String getDomaine() {
        int index = nom.indexOf('.');
        return (index != -1) ? nom.substring(index + 1) : nom;
    }

    @Override
    public String toString() {
        return nom;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof NomMachine)) return false;
        NomMachine other = (NomMachine) obj;
        return nom.equals(other.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }
    
}
