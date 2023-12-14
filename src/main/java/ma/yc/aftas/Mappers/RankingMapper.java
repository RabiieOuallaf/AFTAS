package ma.yc.aftas.Mappers;

import ma.yc.aftas.Models.DTO.Impl.RankingDTO;
import ma.yc.aftas.Models.Entity.RankingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RankingMapper {
    RankingMapper rankingMapper = Mappers.getMapper(RankingMapper.class);

    RankingDTO toDTO(RankingEntity rankingEntity);
    RankingEntity toEntity(RankingDTO rankingDTO);

}
