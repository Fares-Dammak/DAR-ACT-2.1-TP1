package Objet;

import java.io.Serializable;

public class Operation implements Serializable {
	private int nb1;
	private int nb2;
	private String op;
	private int res;
	
	public Operation(int nb1,int nb2,String op) {
		this.nb1=nb1;
		this.nb2=nb2;
		this.op=op;
	}
	public int getNb1() {
		return this.nb1;
	}
	public int getNb2() {
		return this.nb2;
	}
	public String getOp() {
		return this.op;
	}
	public int getRes() {
		return this.res;
	}
	public void setNb1(int nb1) {
		this.nb1=nb1;
	}
	public void setNb2(int nb2) {
		this.nb2=nb2;
	}
	public void setOp(String op) {
		this.op=op;
	}
	public void setRes(int res) {
		this.res=res;
	}

}
