package de.calitobundo.uwe.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="USER_DETAILS")
@NamedQueries({
	@NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
	@NamedQuery(name="User.findById", query="SELECT u FROM User u WHERE u.id = :id"),
	@NamedQuery(name="User.findByNameAndPassword", query="SELECT u FROM User u WHERE u.name = :name AND u.password = :password"),
	@NamedQuery(name="User.findByName", query="SELECT u FROM User u WHERE u.name = :name")
})
public class User implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private long id;

	@Column(name="USER_NAME")
	private String name;

	@Column(name="USER_MAIL")
	private String mail;

	@Column(name="USER_PASSWORD")
	private String password;

	@Column(name="USER_DATE_CREATED")
	private Date dateCreated;

	public User() {	}

	public User(long id, String name, String mail, Date dateCreated) {
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("id", id)
				.append("name", name)
				.append("password", password)
				.append("dateCreated", dateCreated)

				.toString();
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
}
