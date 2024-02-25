package com.mkandirou.aftas.hunting;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Hunting")
@RequiredArgsConstructor
public class HuntingController {
    private final HuntingService huntingService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER')")
    public ResponseEntity<List<HuntingDTOres>> getAll(){
        return new ResponseEntity<>(huntingService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = {"{id}"})
    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER')")
    public ResponseEntity<HuntingDTOres> findById(@PathVariable Integer id){
        return new ResponseEntity<>(huntingService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER','ROLE_JURY')")
    public ResponseEntity<HuntingDTOres> save(@Valid @RequestBody HuntingDTOreq huntingDTOreq){
        return new ResponseEntity<>(huntingService.save(huntingDTOreq), HttpStatus.OK);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER','ROLE_JURY')")
    public ResponseEntity<HuntingDTOres> update(@Valid @RequestBody HuntingDTOreq huntingDTOreq){
        return new ResponseEntity<>(huntingService.update(huntingDTOreq), HttpStatus.OK);
    }

    @DeleteMapping(path = {"{id}"})
    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER')")
    public ResponseEntity<HuntingDTOres> delete(@PathVariable Integer id){
        return new ResponseEntity<>(huntingService.deleteById(id), HttpStatus.OK);
    }
}
