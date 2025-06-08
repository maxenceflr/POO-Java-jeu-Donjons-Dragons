package jouable;

import partie.De;

import java.util.Optional;

public enum ActionResult {
    SUCCESS,
    OBSTACLE,
    OUT_OF_REACH,
    FAILURE,
    NO_ITEM,
    NO_WEAPON,
    ITEM,
    OCCUPIED_POSITION,
    OUT_OF_BONDS;
}
