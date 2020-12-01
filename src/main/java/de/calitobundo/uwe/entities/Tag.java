package de.calitobundo.uwe.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="TAG_DETAILS")
@NamedQueries({
	@NamedQuery(name="Tag.findAll", query="SELECT t FROM Tag t"),
	@NamedQuery(name="Tag.findById", query="SELECT t FROM Tag t WHERE t.id = :id"),
	@NamedQuery(name="Tag.findByName", query="SELECT t FROM Tag t WHERE t.name = :name"),
	@NamedQuery(name="Tag.findByNameList", query="SELECT t FROM Tag t WHERE t.name IN :list"),
})
public class Tag implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TAG_ID")
	private long id;

	@Column(name="TAG_NAME")
	private String name;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
	private Set<Painting> paintings = new HashSet<>(0);

	public Tag() {	}

	public Tag(String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("id", id)
				.append("name", name)
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

	public Set<Painting> getPaintings() {
		return paintings;
	}

	public void setPaintings(Set<Painting> paintings) {
		this.paintings = paintings;
	}
}
