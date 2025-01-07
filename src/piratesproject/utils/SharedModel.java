package piratesproject.utils;

import piratesproject.models.UserModel;

public class SharedModel {
    
    private static UserModel user;

    public static UserModel getUser() {
        return user;
    }

    public static void setUser(UserModel user) {
        SharedModel.user = user;
    }
    
    
    
}
