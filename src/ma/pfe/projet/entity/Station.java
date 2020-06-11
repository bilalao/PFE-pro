package ma.pfe.projet.entity;

import java.io.Serializable;

public class Station implements Serializable {

private static final long serialVersionUID = 1L;
private int id;
private String adrs;
private String contact;
private String name;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getAdrs() {
	return adrs;
}

public void setAdrs(String adrs) {
	this.adrs = adrs;
}

public String getContact() {
	return contact;
}

public void setContact(String contact) {
	this.contact = contact;
}

public Station(int id, String adrs, String contact, String name) {
	super();
	this.id = id;
	this.adrs = adrs;
	this.contact = contact;
	this.name = name;
}

public Station() {
	super();
}

}
