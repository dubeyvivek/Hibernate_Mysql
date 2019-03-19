package com.mkyong;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mkyong.user.Player;
import com.mkyong.user.Team;

public class App {
	public static void main(String[] args) {
		Team t1 = new Team();
		t1.setCountry("INDIA");
		t1.setTname("INDIA LIONS");

		Player p1 = new Player();
		p1.setPname("sachin");

		Player p2 = new Player();
		p2.setPname("Sehwag");

		Set<Player> players = new HashSet<Player>();
		players.add(p1);
		players.add(p2);
		t1.setPlayer(players);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//Player p=(Player)session.get(Player.class, 1);
		/*
		 * if(p != null) { System.out.println("PLAYER ID : "+p.getPlayerid()+
		 * "  PLAYER NAME : "+p.getPname() + "  TEAM NAME : "+ p.getTeam()); } else {
		 * System.out.println("Fetched object is null"); }
		 */
		
		session.save(t1);
		tx.commit();
		session.close();
		sf.close();
	}
}
