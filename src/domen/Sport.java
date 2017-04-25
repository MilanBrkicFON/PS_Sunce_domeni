/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author Milan
 */
public class Sport {
    private int sportID;
    private String naziv;
    private int maxBrClanova;

    public Sport() {
    }

    
    public Sport(int sportID, String naziv, int maxBrClanova) {
        this.sportID = sportID;
        this.naziv = naziv;
        this.maxBrClanova = maxBrClanova;
    }

    public int getSportID() {
        return sportID;
    }

    public void setSportID(int sportID) {
        this.sportID = sportID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getMaxBrClanova() {
        return maxBrClanova;
    }

    public void setMaxBrClanova(int maxBrClanova) {
        this.maxBrClanova = maxBrClanova;
    }

    @Override
    public String toString() {
        return naziv + ", maxBrClanova=" + maxBrClanova;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sport other = (Sport) obj;
        return this.sportID == other.sportID;
    }
    
    
}
