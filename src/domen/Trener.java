/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Milan
 */
public class Trener implements Serializable, OpstiDomenskiObjekat {

    private int trenerID;
    private String ime;
    private String prezime;
    private LocalDate datumRodjenja;
    private int godineRada;
    private String kratakCV;
    private boolean promenjen = false;
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
        return promenjen;
    }

    public void setPromenjen(boolean b) {
        this.promenjen = b;
    }

    public String getAttributes() {
        return trenerID + " " + ime + " " + prezime + " " + datumRodjenja + " " + godineRada + " " + getSport().getNaziv();
    }

    @Override
    public String vratiNazivTabele() {
        return "trener";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return " (imeTrenera, prezimeTrenera, datumRodjenjaTrenera, godineRada, kratakCV, sportId) VALUES("+String.format("'%s','%s','%s',%s,'%s',%s", ime, prezime, datumRodjenja, godineRada, kratakCV, sport.getSportID());
    }

    @Override
    public List napuni(ResultSet rs) throws Exception {
        try {
            List<Trener> treneri = new ArrayList<>();

            while (rs.next()) {
                Trener t = new Trener();
                t.setTrenerID(rs.getInt("trenerId"));
                t.setIme(rs.getString("imeTrenera").trim());
                t.setPrezime(rs.getString("prezimeTrenera").trim());
                t.setDatumRodjenja(rs.getDate("datumRodjenjaTrenera").toLocalDate());
                t.setGodineRada(rs.getInt("godineRada"));
                t.setKratakCV(rs.getString("kratakCV"));
                t.setSport(new Sport(rs.getInt("sportID"), rs.getString("nazivSporta"), rs.getInt("maxBrClanova")));
                treneri.add(t);
            }
            rs.close();
            return treneri;
        } catch (SQLException ex) {
            throw new Exception("Neuspesno ucitavanje trenera!", ex);
        }
    }

    @Override
    public String vratiUslovSaIdentifikatorom() {
        return "WHERE trenerId = " + getTrenerID();
    }

    @Override
    public String vratiIdentifikator() {
        return "trenerId";
    }

    @Override
    public Object get(String nazivAtributa) {
        switch (nazivAtributa) {
            case "trenerId": {
                return trenerID;
            }
            case "ime": {
                return ime;
            }
            case "prezime": {
                return prezime;
            }
            case "datumRodjenja": {
                return datumRodjenja;
            }
            case "godineRada": {
                return godineRada;
            }
            case "kratakCV": {
                return kratakCV;
            }
            case "sportId": {
                return sport.getSportID();
            }
            default:
                return "greska";
        }
    }

    @Override
    public void set(String nazivAtributa, Object vrednostAtributa) {
        switch (nazivAtributa) {
            case "trenerId": {
                setTrenerID((int) vrednostAtributa);
                break;
            }
            case "ime": {
                setIme((String) vrednostAtributa);
                break;
            }
            case "prezime": {
                setPrezime((String) vrednostAtributa);
                break;
            }
            case "datumRodjenja": {
                setDatumRodjenja((LocalDate) vrednostAtributa);
                break;
            }
            case "godineRada": {
                setGodineRada((int) vrednostAtributa);
                break;
            }
            case "kratakCV": {
                setKratakCV((String) vrednostAtributa);
                break;
            }
            case "sportId": {
                setSport((Sport) vrednostAtributa);
                break;
            }

        }
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "imeTrenera = '"
                + this.ime + "', prezimeTrenera = '"
                + this.prezime + "', datumRodjenjaTrenera = '"
                + this.datumRodjenja + "', godineRada = "
                + this.getGodineRada() + ", kratakCV = '"
                + this.kratakCV + "', sportID = "
                + this.sport.getSportID();
    }

    @Override
    public String vratiTabeluSaUslovomSpajanja() {
        return " JOIN sport ON (trener.sportId = sport.sportId)";
    }
}
