package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.EventScheduleDetail;

import java.util.List;

public interface EventScheduleDetailsDAL {
    String addInDbESD(EventScheduleDetail event);

    EventScheduleDetail getFromDbESD(Long id);

    List<EventScheduleDetail> getFromAllDbESD();
}
