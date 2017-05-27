/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author Milan
 */
public class Trening implements Serializable {

    private List<Clan> clanovi;

    private List<Trener> treneri;

    private LocalTime vremeOd;

    private LocalTime vremeDo;

    private LocalDate datum;

    public Trening() {
    }

    public Trening(LocalTime vremeOd, LocalTime vremeDo, LocalDate datum) {
        this.vremeOd = vremeOd;
        this.vremeDo = vremeDo;
        this.datum = datum;
    }

    @Override
    public String toString() {
        return "Trening{" + "vremeOd=" + vremeOd + ", vremeDo=" + vremeDo + ", datum=" + datum + '}';
    }

    public List<Clan> getClanovi() {
        return clanovi;
    }

    public void setClanovi(List<Clan> clanovi) {
        this.clanovi = clanovi;
    }

    public List<Trener> getTreneri() {
        return treneri;
    }

    public void setTreneri(List<Trener> treneri) {
        this.treneri = treneri;
    }

    public LocalTime getVremeOd() {
        return vremeOd;
    }

    public void setVremeOd(LocalTime vremeOd) {
        this.vremeOd = vremeOd;
    }

    public LocalTime getVremeDo() {
        return vremeDo;
    }

    public void setVremeDo(LocalTime vremeDo) {
        this.vremeDo = vremeDo;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Trening other = (Trening) obj;

//        postavi uslov za jednakost!!
//        if (this.vremeDo - other.vremeOd > 0 && this.vremeOd - other.vremeDo < 0) {
//            return false;
//        }
        return true;
    }

}
