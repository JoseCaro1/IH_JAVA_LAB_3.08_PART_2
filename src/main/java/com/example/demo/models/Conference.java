package com.example.demo.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Conference extends Event {

    @ManyToMany
    @JoinTable(name = "conference_speakers", joinColumns = {@JoinColumn(name = "event_id")},
            inverseJoinColumns = {@JoinColumn(name = "speaker_id")})
    private List<Speakers> speakers;

    public List<Speakers> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speakers> speakers) {
        this.speakers = speakers;
    }

    public Conference() {

    }

    public Conference(int id, Date date, int duration, String location, String title, List<Guest> guests, List<Speakers> speakers) {
        super(id, date, duration, location, title, guests);
        this.speakers = speakers;
    }

    /*Select conference.*,speakers.* from conference_speakers JOIN speakers ON speakers.id=conference_speakers.speaker_id
    JOIN conference ON conference.id=conference_speakers.event_id  */

}
