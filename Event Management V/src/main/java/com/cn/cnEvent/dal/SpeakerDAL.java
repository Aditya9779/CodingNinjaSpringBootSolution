package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.Speaker;

import java.util.List;

public interface SpeakerDAL {
    Speaker getSpeakerById(Long id);

    List<Speaker> getAllSpeakers();

    List<Speaker> findSpeakersByEventCountAndExperience(Long eventCount, Long experience);

    void saveSpeaker(Speaker speaker);

    void addSpeakerToEvent(Long speakerId, Long eventId);
}
