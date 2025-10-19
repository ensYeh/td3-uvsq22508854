package fr.uvsq.cprog.collex;

import java.util.Objects;

public class AdressIp {
    
    private String adresse;

    /**
     * Constructeur qui vérifie la validité de l'adresse IP.
     */
    public AdresseIP(String adresse) {
        setAdresse(adresse); // ✅ on réutilise la validation du setter
    }

    /**
     * Setter sécurisé avec validation du format d'adresse IP.
     */
    public void setAdresse(String adresse) {
        if (adresse == null || adresse.isBlank()) {
            throw new IllegalArgumentException("L'adresse IP ne peut pas être vide");
        }

        if (!adresse.matches("^(25[0-5]|2[0-4]\\d|1?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|1?\\d?\\d)){3}$")) {
            throw new IllegalArgumentException("Adresse IP invalide : " + adresse);
        }

        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }

    @Override
    public String toString() {
        return adresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdresseIP)) return false;
        AdresseIP other = (AdresseIP) o;
        return Objects.equals(adresse, other.adresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adresse);
    }
}
