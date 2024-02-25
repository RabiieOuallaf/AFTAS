package com.mkandirou.aftas.app_user;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Member")
@RequiredArgsConstructor
public class App_UserController {

    private final App_UserService memberService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER')")
    public ResponseEntity<List<App_UserDTOres>> getAll(){
        return new ResponseEntity<>(memberService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = {"{code}"})
    public ResponseEntity<App_UserDTOres> findById(@PathVariable Integer code){
        return new ResponseEntity<>(memberService.findById(code), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<App_UserDTOres> save(@Valid @RequestBody App_UserDTOreq memberDTOreq){
        return new ResponseEntity<>(memberService.save(memberDTOreq), HttpStatus.OK);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER')")
    public ResponseEntity<App_UserDTOres> update(@Valid @RequestBody App_UserDTOreq memberDTOreq){
        return new ResponseEntity<>(memberService.update(memberDTOreq), HttpStatus.OK);
    }

    @DeleteMapping(path = {"{num}"})
    public ResponseEntity<App_UserDTOres> delete(@PathVariable Integer num){
        return new ResponseEntity<>(memberService.deleteById(num), HttpStatus.OK);
    }

    @GetMapping(path = {"MemberNotExistInComp/{competitionCode}"})
    public ResponseEntity<List<App_UserDTOres>> MemberNotExistInComp(@PathVariable String competitionCode){
        return new ResponseEntity<>(memberService.findMembersNotexistInComp(competitionCode), HttpStatus.OK);
    }

    @GetMapping(path = {"find/{competitionCode}/{index}"})
    public ResponseEntity<List<App_UserDTOres>> findByNumOrNameOrFamilyName(@PathVariable String index, @PathVariable String competitionCode){
        return new ResponseEntity<>(memberService.findByNumOrNameOrFamilyName(competitionCode,index), HttpStatus.OK);
    }
}
