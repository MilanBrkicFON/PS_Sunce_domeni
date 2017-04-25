/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.time.LocalDate;

/**
 *
 * @author Milan
 */
public class Clan {

    private int clanID;
    private String ime;
    private String prezime;
    private String imeRoditelja;
    private char pol;
    private LocalDate datumRodjenja;
    private int godinaUpisa;
    private Mesto mesto;
    private boolean promenjen = false;
    
    public Clan() {
    }

    public boolean isPromenjen() {
        return promenjen;
    }

    public void setPromenjen(boolean promenjen) {
        this.promenjen = promenjen;
    }

    public Clan(String ime, String prezime, String imeRoditelja, char pol, LocalDate datumRodjenja, int godinaUpisa, Mesto mesto) {

        this.ime = ime;
        this.prezime = prezime;
        this.imeRoditelja = imeRoditelja;
        this.pol = pol;
        this.datumRodjenja = datumRodjenja;
        this.godinaUpisa = godinaUpisa;
        this.mesto = mesto;
    }

    public Clan(int clanID, String ime, String prezime, String imeRoditelja, char pol, LocalDate datumRodjenja, int godinaUpisa, Mesto mesto) {
        this(ime, prezime, imeRoditelja, pol, datumRodjenja, godinaUpisa, mesto);
        this.clanID = clanID;
    }

    @Override
    public String toString() {
        return clanID + " " + ime + " " + prezime + " " + pol;
    }

    public int getClanID() {
        return clanID;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.clanID;
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
        final Clan other = (Clan) obj;
        return this.ime.equals(other.ime) && this.prezime.equals(other.prezime) && this.imeRoditelja.equals(other.imeRoditelja)
                && this.datumRodjenja.equals(other.datumRodjenja) && this.mesto.equals(other.mesto);
    }

    public void setClanID(int clanID) {
        this.clanID = clanID;
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

    public String getImeRoditelja() {
        return imeRoditelja;
    }

    public void setImeRoditelja(String imeRoditelja) {
        this.imeRoditelja = imeRoditelja;
    }

    public char getPol() {
        return pol;
    }

    public void setPol(char pol) {
        this.pol = pol;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public int getGodinaUpisa() {
        return godinaUpisa;
    }

    public void setGodinaUpisa(int godinaUpisa) {
        this.godinaUpisa = godinaUpisa;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public String getAttributes(){
        return clanID + " "+ ime + " "+ prezime + " "+  datumRodjenja + " "+ godinaUpisa + " "+ getMesto().getNaziv();
    }
}
