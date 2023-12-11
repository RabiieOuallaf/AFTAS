package ma.yc.aftas.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity(name = "CompetitionEntity")
@Table(name = "competitions")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "code")
    private String code;

    @Basic
    @Column(name = "date")
    private Date date;

    @Basic
    @Column(name = "start_time")
    private Date startTime;

    @Basic
    @Column(name = "end_time")
    private Date endTime;

    @Basic
    @Column(name = "number_of_participants")
    private Integer numberOfParticipants;

    @Basic
    @Column(name = "location")
    private String location;

    @Basic
    @Column(name = "amount")
    private Integer amount;

    @ManyToMany(mappedBy = "competitions")
    private Set<MemberEntity> members;

    @OneToMany(mappedBy = "competition")
    private List<HuntingEntity> huntings;
}
