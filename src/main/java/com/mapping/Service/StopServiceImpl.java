package com.mapping.Service;

import com.mapping.Payload.StopDto;
import com.mapping.Repository.StopRepository;
import com.mapping.entity.Stop;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StopServiceImpl implements StopService{
    private StopRepository stopRepository;

    public StopServiceImpl(StopRepository stopRepository){
        this.stopRepository = stopRepository;
    }
    @Override
    public StopDto addStops(StopDto sdto) {
        Stop stop = mapToEntity(sdto);
        Stop saved = stopRepository.save(stop);
        StopDto dto = mapToDto(saved);
        return dto;
    }

    @Transactional
    @Override
    public void deleteStopById(long id) {
        stopRepository.deleteById(id);
    }

    @Transactional
    @Override
    public StopDto updateStop(StopDto stopDto, long id) {
        Stop s = stopRepository.findById(id).orElseThrow(
                ()->new RuntimeException("record not found")
        );
        s.setStopName(stopDto.getStopName());
        StopDto sdto =mapToDto(s);
        return sdto;
    }

    private StopDto mapToDto(Stop s) {
        StopDto sdto = new StopDto();
        sdto.setStopName(s.getStopName());
        return sdto;
    }

    private Stop mapToEntity(StopDto sdto) {
        Stop s = new Stop();
        s.setStopName(sdto.getStopName());
        return s;

    }
}
