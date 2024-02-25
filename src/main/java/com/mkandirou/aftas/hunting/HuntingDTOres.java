package com.mkandirou.aftas.hunting;

import com.mkandirou.aftas.competition.Competition;
import com.mkandirou.aftas.fish.Fish;
import com.mkandirou.aftas.app_user.App_user;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HuntingDTOres {
    private Integer id;
    private Integer numberOfFish;
    private Fish fish;
    private App_user member;
    private Competition competition;
}
