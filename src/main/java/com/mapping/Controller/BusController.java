package com.mapping.Controller;

import com.mapping.Payload.BusDto;
import com.mapping.Service.BusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {
    private BusService busService;
    public  BusController(BusService busService){
        this.busService=busService;
    }

    @PostMapping
    public ResponseEntity<BusDto> addBus(@RequestBody BusDto bdto){
        BusDto dto = busService.addBus(bdto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBus(@RequestParam long id){
        busService.deleteBusById(id);
        return new ResponseEntity<>("deleted",HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<BusDto> updateBus(@RequestBody BusDto dto,@RequestParam long id){
        BusDto bdto =  busService.updateBus(dto,id);
        return new ResponseEntity<>(bdto,HttpStatus.OK);
    }


}
