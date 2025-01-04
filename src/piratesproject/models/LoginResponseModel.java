package piratesproject.models;

public class LoginResponseModel extends ResponseModel{
    
    private UserModel userModel ;
    
    public LoginResponseModel() {
    }
  
    public LoginResponseModel(int status, String message , UserModel user) {
        super(status, message);
        this.userModel = user;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
    
}
