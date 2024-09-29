package com.mapping.Service;

import com.mapping.Payload.BusDto;
import com.mapping.Repository.BusRepository;
import com.mapping.entity.Bus;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class BusServiceImpl implements BusService{
    private BusRepository busRepository;

    public BusServiceImpl(BusRepository busRepository){
        this.busRepository=busRepository;
    }

    @Override
    public BusDto addBus(BusDto bdto) {
        Bus b = mapToEntity(bdto);
        Bus saved = busRepository.save(b);
        BusDto dto = mapToDto(saved);
        return dto;
    }
    @Transactional
    @Override
    public void deleteBusById(long id) {
        busRepository.deleteById(id);
    }
    @Transactional
    @Override
    public BusDto updateBus(BusDto dto, long id) {
       Bus bus = busRepository.findById(id).get();
       bus.setName(dto.getName());
       Bus saved = busRepository.save(bus);
       BusDto bdto = mapToDto(bus);
       return bdto;
    }

    private BusDto mapToDto(Bus b) {
        BusDto dto = new BusDto();
        dto.setName(b.getName());
        return dto;
    }

    private Bus mapToEntity(BusDto bdto) {
        Bus bus = new Bus();
        bus.setName(bdto.getName());
        return bus;
    }
}
