package ma.yc.aftas.DTO.Impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionDTO {
    int id;
    String code;
    Date date;
    Time startTime;
    Time endTime;
    Integer numberOfParticipants;
    String location;
    Integer amount;
}
