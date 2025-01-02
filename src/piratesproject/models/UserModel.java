package piratesproject.models;

public class UserModel {
    
    private String userFirstName; 
    private String userLastName;
    private String userName; 
    private String userPassword; 
    private Boolean userIsOnline; 
    private Boolean userIsplayingnow; 
    private int userTotalGamePlayed; 
    private int userTotalScore;
    
    
    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    
    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Boolean getUserIsOnline() {
        return userIsOnline;
    }

    public void setUserIsOnline(Boolean userIsOnline) {
        this.userIsOnline = userIsOnline;
    }
    public int getUserTotalScore() {
        return userTotalScore;
    }

    public void setUserTotalScore(int userTotalScore) {
        this.userTotalScore = userTotalScore;
    }

    public Boolean getUserIsplayingnow() {
        return userIsplayingnow;
    }

    public void setUserIsplayingnow(Boolean userIsplayingnow) {
        this.userIsplayingnow = userIsplayingnow;
    }

    public int getUserTotalGamePlayed() {
        return userTotalGamePlayed;
    }

    public void setUserTotalGamePlayed(int userTotalGamePlayed) {
        this.userTotalGamePlayed = userTotalGamePlayed;
    }
     
    
    public UserModel(String Fname , String username , String password ){
        this.userFirstName = Fname ; 
        this.userName = username ; 
        this.userPassword = password; 
    }
    
    public UserModel(String userFirstName  , String userLastName  , String userName,String userPasswor ){
     
        this.userFirstName = userFirstName; 
        this.userLastName = userLastName;
        this.userName = userName; 
        this.userPassword = userPassword; 
    }    
    

}
