package com.em.utils;

import com.em.utils.entity.positionsDefinition;
import com.em.utils.entity.basketPosition;
import com.em.utils.entity.handBallPossition;

import java.util.ArrayList;
import java.util.List;

public class positionScores {
    public static final List<positionsDefinition>  BASKET_POSITIONS_DEFINITION_LIST = new ArrayList<positionsDefinition>(){
        {
            add(new basketPosition("BASKET", "G",2,3,1));
            add(new basketPosition("BASKET", "F",2,2,2));
            add(new basketPosition("BASKET", "C",2,1,3));
        };
    };
    public static final List<positionsDefinition>  HANDBALL_POSITIONS_DEFINITION_LIST = new ArrayList<positionsDefinition>(){
        {
            add(new handBallPossition("HANDB", "G",50,5,2));
            add(new handBallPossition("HANDB", "F",20,1,1));
        };
    };
}


