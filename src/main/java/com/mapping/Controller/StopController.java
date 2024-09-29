package com.mapping.Controller;

import com.mapping.Payload.StopDto;
import com.mapping.Repository.StopRepository;
import com.mapping.Service.StopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stop")
public class StopController {
    private StopService stopService;
    public StopController(StopService stopService){
        this.stopService=stopService;
    }

    @PostMapping
    public ResponseEntity<StopDto> addStop(@RequestBody StopDto stopDto){
        StopDto sdto= stopService.addStops(stopDto);
        return new ResponseEntity<>(sdto, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> StopDto(@RequestParam long id){
        stopService.deleteStopById(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<StopDto> updateStop(@RequestBody StopDto stopDto,@RequestParam long id){
        StopDto dto = stopService.updateStop(stopDto,id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

}
