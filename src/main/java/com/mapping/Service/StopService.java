package com.mapping.Service;

import com.mapping.Payload.StopDto;

public interface StopService {
     public StopDto addStops(StopDto stopDto);

    void deleteStopById(long id);

    StopDto updateStop(StopDto stopDto, long id);
}
