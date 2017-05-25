/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osluskivac;

import domen.Clan;
import java.io.Serializable;

/**
 *
 * @author Milan
 */
public interface OsluskivacClanovi extends Serializable{
    public void oDodajClana(Clan clan);

    public void oObrisiClana(Clan clan);
}
