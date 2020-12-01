package de.calitobundo.uwe.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="PAINTING_DETAILS")
@NamedQueries({
	@NamedQuery(name="Painting.findAll", query="SELECT p FROM Painting p"),
	@NamedQuery(name="Painting.findById", query="SELECT p FROM Painting p WHERE p.id = :id")
})
public class Painting implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PAINTING_ID")
	private long id;

	@Column(name="PAINTING_TITLE")
	private String title;

	@Column(name="PAINTING_DATE_CREATED")
	private Date dateCreated;

	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "PAINTING_TAGS_DETAILS",
			joinColumns = @JoinColumn(name = "PAINTING_ID"),
			inverseJoinColumns = @JoinColumn(name = "TAG_ID")
	)
	private Set<Tag> tags = new HashSet<>(0);

	public Painting() {	}

	public Painting(long id, String title, Date dateCreated) {
		this.id = id;
		this.title = title;
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("id", id)
				.append("title", title)
				.append("dateCreated", dateCreated)
				.append("tags", tags)
				.toString();
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
}
