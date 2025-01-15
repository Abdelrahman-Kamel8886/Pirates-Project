package piratesproject.utils;

import java.util.ArrayList;
import piratesproject.enums.LevelTypesEnum;
import piratesproject.enums.SoundTrackStateEnum;
import piratesproject.models.RecordModel;
import piratesproject.models.UserModel;

public class SharedModel {

    private static LevelTypesEnum selectedLevel = LevelTypesEnum.Normal;
    private static UserModel user;
    private static UserModel selectedUser;
    private static SoundTrackStateEnum soundTrackState;
    private static RecordModel selectedRecord;
    private static String playerName1 = "abdo";
    private static String playerName2 = "tag";
<<<<<<< HEAD
    private static String OponnentName = "nono";
=======

    private static String challenger;

    public static String getChallenger() {
        return challenger;
    }

    public static void setChallenger(String challenger) {
        SharedModel.challenger = challenger;
    }

>>>>>>> 03f0ddf0c1647090456c30098709cc49843289f4
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

    public static UserModel getSelectedUser() {
        return selectedUser;
    }

    public static void setSelectedUser(UserModel selectedUser) {
        SharedModel.selectedUser = selectedUser;
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
