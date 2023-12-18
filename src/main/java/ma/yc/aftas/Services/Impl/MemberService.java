package ma.yc.aftas.Services.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.yc.aftas.Models.DTO.Impl.MemberDTO;
import ma.yc.aftas.Models.Entity.MemberEntity;
import ma.yc.aftas.Mappers.MemberMapper;
import ma.yc.aftas.Models.Repositories.MemberRepository;
import ma.yc.aftas.Services.Interface.MemberServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService implements MemberServiceInterface {
    @Autowired
    private MemberRepository memberRepository;

    /**
     *
     * @param memberDTO
     * @return MemberDTO
     * @description Create a member
     */
    @Override
    public MemberDTO create(MemberDTO memberDTO) {
        MemberEntity foundMemberEntity = memberRepository.findByNum(memberDTO.getNum());

        if(foundMemberEntity != null){
            log.info("Member already exists");
            return null;
        }
        MemberEntity toBeCreatedMember = MemberMapper.memberMapper.toEntity(memberDTO);

        MemberEntity createdMember = memberRepository.save(toBeCreatedMember);

        if(createdMember == null){
            log.info("Member can't be inserted to the DB");
            return null;
        }

        return MemberMapper.memberMapper.toDTO(createdMember);

    }

    /**
     * @description Update a member
     * @param memberDTO
     * @return MemberDTO
     */

    @Override
    public MemberDTO update(MemberDTO memberDTO) {
        MemberEntity foundMemberEntity = memberRepository.findByNum(memberDTO.getNum());

        if(foundMemberEntity == null){
            log.info("Member doesn't exist");
            return null;
        }
        MemberEntity toBeCreatedMember = MemberMapper.memberMapper.toEntity(memberDTO);

        MemberEntity createdMember = memberRepository.save(toBeCreatedMember);

        if(createdMember == null){
            log.info("Member can't be inserted to the DB");
            return null;
        }

        return MemberMapper.memberMapper.toDTO(createdMember);
    }

    /**
     * @description Delete a member
     * @param num
     * @return boolean
     */
    @Override
    public boolean delete(Integer num) {
        MemberDTO memberToBeDeleted = getByNum(num);

        if(memberToBeDeleted == null){
            log.info("Member not found");
            return false;
        }
        MemberEntity memberToBeDeletedEntity = MemberMapper.memberMapper.toEntity(memberToBeDeleted);
        memberRepository.delete(memberToBeDeletedEntity);
        return true;
    }

    /**
     * @description Get all members
     * @return List<MemberDTO>
     */

    @Override
    public List<MemberDTO> getAll() {
        List<MemberEntity> listOfMembers = memberRepository.findAll();
        List<MemberDTO> listOfMemberDTOs = new ArrayList<>();

        if(listOfMembers == null){
            log.info("No members found");
            return null;
        }

        listOfMembers.forEach(memberEntity -> {
            listOfMemberDTOs.add(MemberMapper.memberMapper.toDTO(memberEntity));
        });

        return listOfMemberDTOs;
    }

    /**
     * @description Get a member
     * @param num
     * @return num
     */

    @Override
    public MemberDTO getByNum(Integer num) {
        MemberEntity foundMemberEntity = memberRepository.findByNum(num);

        if(foundMemberEntity == null){
            log.info("Member not found");
            return null;
        }

        return MemberMapper.memberMapper.toDTO(foundMemberEntity);
    }
}
