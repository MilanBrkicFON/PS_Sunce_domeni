/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Milan
 */
@Entity
public class Korisnik implements Serializable {
    @Id
    @Basic(optional = false)
    private String username;
    private String password;
    @JoinColumn(name = "clanId", referencedColumnName = "clanID")
    @ManyToOne
    private Clan clan;
    @JoinColumn(name = "trenerId", referencedColumnName = "trenerID")
    @ManyToOne
    private Trener trener;

    public Korisnik() {
    }
    public Korisnik(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }
    
    
}
