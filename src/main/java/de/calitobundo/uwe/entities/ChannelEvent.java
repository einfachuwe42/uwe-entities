package de.calitobundo.uwe.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CHANNEL_EVENT_DETAILS")
@NamedQueries({
        @NamedQuery(name="ChannelEvent.findAll", query="SELECT c FROM ChannelEvent c")
})
public class ChannelEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CHANNEL_EVENT_ID")
    private long id;

    @Column(name="CHANNEL_EVENT_NAME")
    private String name;

    @Column(name="CHANNEL_EVENT_DATE")
    private Date date;

    @Column(name="CHANNEL_EVENT_MESSAGE", length=600)
    private String message;

    public ChannelEvent() {

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
