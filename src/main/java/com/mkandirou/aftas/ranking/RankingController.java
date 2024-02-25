package com.mkandirou.aftas.ranking;


import com.mkandirou.aftas.competition.Competition;
import com.mkandirou.aftas.app_user.App_user;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Ranking")
@RequiredArgsConstructor
public class RankingController {

    private final RankingService rankingService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER')")
    public ResponseEntity<List<RankingDTOres>> getAll(){
        return new ResponseEntity<>(rankingService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = {"/byCompetition/{code}"})
    @PreAuthorize("hasAnyAuthority('ROLE_ADHERENT','ROLE_MANAGER')")
    public ResponseEntity<List<RankingDTOres>> findRankingByCompetitionCode(@PathVariable String code){
        return new ResponseEntity<>(rankingService.findRankingByCompetitionCode(code), HttpStatus.OK);
    }

    @GetMapping("/{memberId}/{competitionCode}")
    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER')")
    public ResponseEntity<RankingDTOres> findById(@PathVariable Integer memberId, @PathVariable String competitionCode){
        RankingId rankingId = new RankingId();
        App_user member = new App_user();
        member.setNum(memberId);
        rankingId.setMember(member);
        Competition competition = new Competition();
        competition.setCode(competitionCode);
        rankingId.setCompetition(competition);
        return new ResponseEntity<>(rankingService.findById(rankingId), HttpStatus.OK);
    }

    @DeleteMapping("/{memberId}/{competitionCode}")
    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER')")
    public ResponseEntity<RankingDTOres> delete(@PathVariable Integer memberId, @PathVariable String competitionCode){
        RankingId rankingId = new RankingId();
        App_user member = new App_user();
        member.setNum(memberId);
        rankingId.setMember(member);
        Competition competition = new Competition();
        competition.setCode(competitionCode);
        rankingId.setCompetition(competition);
        return new ResponseEntity<>(rankingService.deleteById(rankingId), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER')")
    public ResponseEntity<RankingDTOres> save(@Valid @RequestBody RankingDTOreq RankingDTOreq){
        return new ResponseEntity<>(rankingService.save(RankingDTOreq), HttpStatus.OK);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER')")
    public ResponseEntity<RankingDTOres> update(@Valid @RequestBody RankingDTOreq RankingDTOreq){
        return new ResponseEntity<>(rankingService.update(RankingDTOreq), HttpStatus.OK);
    }



    @GetMapping("/calcule/{code}")
    @PreAuthorize("hasAnyAuthority('ROLE_JURY','ROLE_MANAGER')")
    public ResponseEntity<Boolean> calcule(@PathVariable String code){
        return new ResponseEntity<>(rankingService.calculePointbyCompetition(code), HttpStatus.OK);
    }



}
