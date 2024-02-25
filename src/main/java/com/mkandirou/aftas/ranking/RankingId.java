package com.mkandirou.aftas.ranking;


import com.mkandirou.aftas.competition.Competition;
import com.mkandirou.aftas.app_user.App_user;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class RankingId implements Serializable {
    @ManyToOne
    private App_user member;
    @ManyToOne
    private Competition competition;
}
