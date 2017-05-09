/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import domen.Clan;
import domen.Mesto;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Milan
 */
public class Start {

    Session session;

    public static void main(String[] args) {
        Start s = new Start();
//        Trening t = new Trening(LocalTime.of(20, 0, 0),LocalTime.of(22, 0, 0),LocalDate.now());
//        List<Clan> clanovi = new ArrayList<>();
//        clanovi.add(new Clan(1003));
//        clanovi.add(new Clan(1029));
//        clanovi.add(new Clan(1039));
//        
//        List<Trener> treneri = new ArrayList<>();
//        treneri.add(new Trener(1));
//        treneri.add(new Trener(2));
//        
        
        Mesto me = new Mesto(22000, "NOvo mesto");
        s.kreirajIUbaciMesto(me);
        System.out.println("Ubaceno mesto");
//        
//        List<Clan> clans = s.listClanovi();
//        System.out.println(clans);
    }

    public void kreirajIUbaciMesto(Mesto m) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(m);
        session.getTransaction().commit();
    }

    public List listClanovi() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from clan");
        List lista = query.list();
        session.getTransaction().commit();
        return lista;
    }

}
