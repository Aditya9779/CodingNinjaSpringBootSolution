package com.cn.cnEvent.entity;

import javax.persistence.*;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private EventScheduleDetail eventScheduleDetail;

    public EventScheduleDetail getEventScheduleDetail() {
        return eventScheduleDetail;
    }

    public void setEventScheduleDetail(EventScheduleDetail eventScheduleDetail) {
        this.eventScheduleDetail = eventScheduleDetail;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
