package com.cn.cnEvent.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "speaker")
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long experience;

//    @ManyToMany
//    @JoinTable(
//            name = "speaker_event",
//            joinColumns = @JoinColumn(name = "speaker_id"),
//            inverseJoinColumns = @JoinColumn(name = "event_id")
//    )
    @ManyToMany(mappedBy = "speakers")
    @JsonIgnore // to prevent infinite recursion
    private List<Event> events = new ArrayList<>();

    public Speaker(Long id, String name, Long experience, List<Event> events) {
        this.id = id;
        this.name = name;
        this.experience = experience;
        this.events = events;
    }

    public Speaker() {

    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getExperience() {
        return experience;
    }

    public void setExperience(Long experience) {
        this.experience = experience;
    }
}
