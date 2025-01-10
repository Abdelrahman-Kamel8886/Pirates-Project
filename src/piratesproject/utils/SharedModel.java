package piratesproject.utils;

import java.util.ArrayList;
import piratesproject.enums.LevelTypesEnum;
import piratesproject.enums.SoundTrackStateEnum;
import piratesproject.models.UserModel;

public class SharedModel {
    private static LevelTypesEnum selectedLevel=LevelTypesEnum.Normal;
    private static UserModel user;
    private static SoundTrackStateEnum soundTrackState;

    public static UserModel getUser() {
        return user;
    }

    public static void setUser(UserModel user) {
        SharedModel.user = user;
    }

    public static SoundTrackStateEnum getSoundTrackState() {
        return soundTrackState;
    }

    public static void setSoundTrackState(SoundTrackStateEnum soundTrackState) {
        SharedModel.soundTrackState = soundTrackState;
    }

    public static LevelTypesEnum getSelectedLevel() {
        return selectedLevel;
    }

    public static void setSelectedLevel(LevelTypesEnum selectedLevel) {
        SharedModel.selectedLevel = selectedLevel;
    }
    
    
    
    
    
}
