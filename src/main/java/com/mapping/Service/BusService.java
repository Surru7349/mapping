package com.mapping.Service;

import com.mapping.Payload.BusDto;

public interface BusService {
    public BusDto addBus(BusDto bdto);

    void deleteBusById(long id);

    BusDto updateBus(BusDto dto, long id);
}
