package com.mapping.Service;

import com.mapping.Payload.BusStopDto;
import com.mapping.Repository.BusRepository;
import com.mapping.Repository.BusStopRepository;
import com.mapping.Repository.StopRepository;
import com.mapping.entity.Bus;
import com.mapping.entity.BusStop;
import com.mapping.entity.Stop;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class BusStopServiceImpl implements BusStopService{
    private BusRepository busRepository;
    private StopRepository stopRepository;
    private BusStopRepository busStopRepository;

    public BusStopServiceImpl(BusRepository busRepository,StopRepository stopRepository,BusStopRepository busStopRepository){
        this.busRepository=busRepository;
        this.stopRepository=stopRepository;
        this.busStopRepository=busStopRepository;
    }
    @Override
    public BusStopDto allocateBusRoute(long busId, long stopId, BusStopDto bsdto) {
        Bus bus = busRepository.findById(busId).orElseThrow(
                ()->new RuntimeException("record not found")
        );
        Stop stop = stopRepository.findById(stopId).orElseThrow(
                ()->new RuntimeException("record not found")
        );
        BusStop busStop = mapToEntity(bsdto);
        busStop.setBus(bus);
        busStop.setStop(stop);
        BusStop saved = busStopRepository.save(busStop);
        BusStopDto dto = mapToDto(saved);
        return dto;

    }

    @Override
    public void deleteBusStopById(long busId, long stopId) {

    }


    private BusStopDto mapToDto(BusStop busStop) {
        BusStopDto bdto = new BusStopDto();
        bdto.setStop_order(busStop.getStop_order());
        return bdto;
    }

    private BusStop mapToEntity(BusStopDto bsdto) {
        BusStop busStop = new BusStop();
        busStop.setStop_order(bsdto.getStop_order());
        return busStop;
    }
}
