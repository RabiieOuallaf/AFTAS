package ma.yc.aftas.Mappers;

import ma.yc.aftas.DTO.Impl.CompetitionDTO;
import ma.yc.aftas.Entity.CompetitionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.Mapping;

@Mapper(componentModel = "spring")
public interface CompetitionMapper {
    CompetitionMapper competitionMapper = Mappers.getMapper(CompetitionMapper.class);

    CompetitionDTO toDTO(CompetitionEntity competitionEntity);
    CompetitionEntity toEntity(CompetitionDTO competitionDTO);
}
