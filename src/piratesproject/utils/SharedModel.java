package piratesproject.utils;

import java.util.ArrayList;
import piratesproject.enums.LevelTypesEnum;
import piratesproject.enums.SoundTrackStateEnum;
import piratesproject.models.RecordModel;
import piratesproject.models.UserModel;

public class SharedModel {
    private static LevelTypesEnum selectedLevel=LevelTypesEnum.Normal;
    private static UserModel user;
    private static SoundTrackStateEnum soundTrackState;
    private static RecordModel selectedRecord;
    private static String playerName1 = "abdo";
    private static String playerName2 = "tag";
    private static String OponnentName = "nono";
    public static UserModel getUser() {
        return user;
    }

    public static String getOponnentName() {
        return OponnentName;
    }

    public static void setOponnentName(String OponnentName) {
        SharedModel.OponnentName = OponnentName;
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

    public static String getPlayerName1() {
        return playerName1;
    }

    public static void setPlayerName1(String playerName1) {
        SharedModel.playerName1 = playerName1;
    }

    public static String getPlayerName2() {
        return playerName2;
    }

    public static void setPlayerName2(String playerName2) {
        SharedModel.playerName2 = playerName2;
    }

    public static RecordModel getSelectedRecord() {
        return selectedRecord;
    }

    public static void setSelectedRecord(RecordModel selectedRecord) {
        SharedModel.selectedRecord = selectedRecord;
    }
    
    
    
    
    
    
    
}
