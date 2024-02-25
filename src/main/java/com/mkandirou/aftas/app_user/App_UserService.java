package com.mkandirou.aftas.app_user;


import com.mkandirou.aftas.Exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class App_UserService implements IApp_User {
    private final App_UserRepository memberRepository;

    private final ModelMapper modelMapper;

    public App_UserService(App_UserRepository memberRepository, ModelMapper modelMapper) {
        this.memberRepository=memberRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public App_UserDTOres findById(Integer primarykey) {
        App_user member = memberRepository.findById(primarykey)
                .orElseThrow(() -> new ResourceNotFoundException("id Member : " + primarykey));
        return modelMapper.map(member, App_UserDTOres.class);
    }

    @Override
    public App_UserDTOres save(App_UserDTOreq DTOreq) {
        App_user member= modelMapper.map(DTOreq, App_user.class);
        member.setAccessionDate(LocalDate.now());
        return modelMapper.map(memberRepository.save(member), App_UserDTOres.class);
    }

    @Override
    public App_UserDTOres deleteById(Integer primarykey) {
        App_user Member = memberRepository.findById(primarykey)
                .orElseThrow(() -> new ResourceNotFoundException("id Member : " + primarykey));
        memberRepository.deleteById(primarykey);
        return modelMapper.map(Member, App_UserDTOres.class);
    }

    @Override
    public App_UserDTOres update(App_UserDTOreq DTOreq) {
        App_user member = memberRepository.findById(DTOreq.getNum())
                .orElseThrow(() -> new ResourceNotFoundException("id Member: " + DTOreq.getNum()));
        member.setRole(DTOreq.getRole());
        memberRepository.save(member);
        return modelMapper.map(member, App_UserDTOres.class);
    }

    @Override
    public List<App_UserDTOres> findAll() {
        List<App_user> Members = memberRepository.findAll();
        return Members.stream()
                .map(f -> modelMapper.map(f, App_UserDTOres.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<App_UserDTOres> findMembersNotexistInComp(String competitionCode) {
        List<App_user> Members = memberRepository.findMembersNotInCompetition(competitionCode);
        return Members.stream()
                .map(member -> modelMapper.map(member, App_UserDTOres.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<App_UserDTOres> findByNumOrNameOrFamilyName(String codeComp, String index) {
        List<App_user> Members = memberRepository.findByNumOrNameOrFamilyName(index,codeComp);
        return Members.stream()
                .map(member -> modelMapper.map(member, App_UserDTOres.class))
                .collect(Collectors.toList());
    }


}
