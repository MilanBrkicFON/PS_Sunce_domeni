/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Milan
 */
public class Trener implements Serializable {

    private int trenerID;
    private String ime;
    private String prezime;
    private LocalDate datumRodjenja;
    private int godineRada;
    private String kratakCV;

    private Sport sport;

    public Trener() {
    }

    public Trener(int trenerID) {
        this.trenerID = trenerID;
    }

    public Trener(int trenerID, String ime, String prezime, LocalDate datumRodjenja, int godineRada, String kratakCV, Sport sport) {
        this.trenerID = trenerID;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.godineRada = godineRada;
        this.kratakCV = kratakCV;
        this.sport = sport;
    }

    public Trener(String ime, String prezime, LocalDate datumRodjenja, int godineRada, String cv, Sport sport) {
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.godineRada = godineRada;
        this.kratakCV = cv;
        this.sport = sport;
    }

    public int getTrenerID() {
        return trenerID;
    }

    public void setTrenerID(int trenerID) {
        this.trenerID = trenerID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public int getGodineRada() {
        return godineRada;
    }

    public void setGodineRada(int godineRada) {
        this.godineRada = godineRada;
    }

    public String getKratakCV() {
        return kratakCV;
    }

    public void setKratakCV(String kratakCV) {
        this.kratakCV = kratakCV;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.trenerID;
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
        final Trener other = (Trener) obj;
        return this.ime.equals(other.ime) && this.prezime.equals(other.prezime)
                && this.datumRodjenja.equals(other.datumRodjenja) && this.sport.equals(other.sport);
    }

    @Override
    public String toString() {
        return trenerID + " " + ime + " " + prezime;
    }

    public boolean isPromenjen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPromenjen(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
