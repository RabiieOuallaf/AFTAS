package ma.yc.aftas.Mappers;

import ma.yc.aftas.Models.DTO.Impl.MemberDTO;
import ma.yc.aftas.Models.Entity.MemberEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    MemberMapper memberMapper = Mappers.getMapper(MemberMapper.class);

    MemberDTO toDTO(MemberEntity memberEntity);
    MemberEntity toEntity(MemberDTO memberDTO);


}
