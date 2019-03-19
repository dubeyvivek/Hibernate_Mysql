package com.mkyong.user;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "play")
@Table(name = "PLAYER")
public class Player {
	
	@Column(name = "PLAYER_ID")
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(initialValue=1000,allocationSize=1, name = "seq_1")
	int playerid;
	@Column(name = "PLAYER_NAME")
	String pname;

	public int getPlayerid() {
		return playerid;
	}

	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "TEAM_ID")
	@GeneratedValue
	Team team;
}
