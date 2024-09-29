package com.mapping.Controller;

import com.mapping.Payload.BusStopDto;
import com.mapping.Service.BusStopService;
import com.mapping.entity.BusStop;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/busStop")
public class BusStopController {
    private BusStopService busStopService;

    public BusStopController(BusStopService busStopService){
        this.busStopService = busStopService;
    }

    @PostMapping
    public ResponseEntity<BusStopDto> allocateRoute(
            @RequestParam long busId,
            @RequestParam long stopId,
            @RequestBody BusStopDto busStopdto){
        BusStopDto dto = busStopService.allocateBusRoute(busId,stopId,busStopdto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllocatedRoute(@RequestParam long busId,@RequestParam long stopId){
        busStopService.deleteBusStopById(busId,stopId);
        return new ResponseEntity<>("DELETED",HttpStatus.OK);
    }

}
