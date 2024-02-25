package com.mkandirou.aftas.competition;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Competition")
@RequiredArgsConstructor
public class CompetitionController {

    private final CompetitionService competitionService;

    @GetMapping(path = {"byStatus/{status}"})
    @PreAuthorize("hasAnyAuthority('ROLE_ADHERENT','ROLE_JURY','ROLE_MANAGER')")
    public ResponseEntity<Page<CompetitionDTOres>> getAll(@PathVariable String status,Pageable pageable){
        return new ResponseEntity<>(competitionService.findAll(status,pageable), HttpStatus.OK);
    }

    @GetMapping(path = {"{code}"})
    @PreAuthorize("hasAnyAuthority('ROLE_ADHERENT','ROLE_MANAGER')")
    public ResponseEntity<CompetitionDTOres> findById(@PathVariable String code){
        return new ResponseEntity<>(competitionService.findById(code), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_JURY','ROLE_MANAGER')")
    public ResponseEntity<CompetitionDTOres> save(@Valid @RequestBody CompetitionDTOreq CompetitionDTOreq){
        return new ResponseEntity<>(competitionService.save(CompetitionDTOreq), HttpStatus.OK);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ROLE_JURY','ROLE_MANAGER')")
    public ResponseEntity<CompetitionDTOres> update(@Valid @RequestBody CompetitionDTOreq CompetitionDTOreq){
        return new ResponseEntity<>(competitionService.update(CompetitionDTOreq), HttpStatus.OK);
    }

    @DeleteMapping(path = {"{code}"})
    @PreAuthorize("hasAnyAuthority('ROLE_JURY','ROLE_MANAGER')")
    public ResponseEntity<CompetitionDTOres> delete(@PathVariable String code){
        return new ResponseEntity<>(competitionService.deleteById(code), HttpStatus.OK);
    }
}
