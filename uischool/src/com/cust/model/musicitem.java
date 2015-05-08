package com.cust.model;

public class musicitem {
	
	private int id;
	private String musicphoto;//“Ù¿÷Õº∆¨
	private String userphoto; //”√ªßÕº∆¨
	private String bt; //±ÍÃ‚
	private String bz; //±∏◊¢
	private String nr; //ƒ⁄»›
	private String musicurl; //“Ù¿÷url
	private String username;
	private String plcount;
	private String zancont;
	private String pos;
	
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMusicphoto() {
		return musicphoto;
	}
	public void setMusicphoto(String musicphoto) {
		this.musicphoto = musicphoto;
	}
	public String getUserphoto() {
		return userphoto;
	}
	public void setUserphoto(String userphoto) {
		this.userphoto = userphoto;
	}
	public String getBt() {
		return bt;
	}
	public void setBt(String bt) {
		this.bt = bt;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getNr() {
		return nr;
	}
	public void setNr(String nr) {
		this.nr = nr;
	}
	public String getMusicurl() {
		return musicurl;
	}
	public void setMusicurl(String musicurl) {
		this.musicurl = musicurl;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPlcount() {
		return plcount;
	}
	public void setPlcount(String plcount) {
		this.plcount = plcount;
	}
	public String getZancont() {
		return zancont;
	}
	public void setZancont(String zancont) {
		this.zancont = zancont;
	}
	public musicitem(int id, String musicphoto, String userphoto, String bt,
			String bz, String nr, String musicurl, String username,
			String plcount, String zancont) {
		super();
		this.id = id;
		this.musicphoto = musicphoto;
		this.userphoto = userphoto;
		this.bt = bt;
		this.bz = bz;
		this.nr = nr;
		this.musicurl = musicurl;
		this.username = username;
		this.plcount = plcount;
		this.zancont = zancont;
	}
	

}
