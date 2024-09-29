package com.mapping.Service;

import com.mapping.Payload.BusStopDto;

public interface BusStopService {
    public BusStopDto allocateBusRoute(long busId,long stopId,BusStopDto bsdto);

    void deleteBusStopById(long busId,long stopId);
}
