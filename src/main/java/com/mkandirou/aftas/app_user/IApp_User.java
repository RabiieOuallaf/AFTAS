package com.mkandirou.aftas.app_user;

import com.mkandirou.aftas.helpers.IData;

import java.util.List;

public interface IApp_User extends IData<App_UserDTOreq, App_UserDTOres,Integer> {
    List<App_UserDTOres> findAll();
    List<App_UserDTOres> findMembersNotexistInComp(String competitionCode);
    List<App_UserDTOres> findByNumOrNameOrFamilyName(String codeComp, String index);
}
