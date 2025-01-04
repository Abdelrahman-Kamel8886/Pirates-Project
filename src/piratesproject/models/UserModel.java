package piratesproject.models;

public class UserModel  {
    
   private String firstName; 
    private String lastName;
    private String userName; 
    private String password; 
    private Boolean isOnline; 
    private Boolean isplayingnow; 
    private Integer GamesPlayed; 
    private Integer score;
    
    

    public UserModel() {
    }

    public UserModel(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    public UserModel(String firstName, String lastName, String userName, String password, Boolean isOnline, Boolean isplayingnow, Integer GamesPlayed, Integer score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.isOnline = isOnline;
        this.isplayingnow = isplayingnow;
        this.GamesPlayed = GamesPlayed;
        this.score = score;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Boolean isOnline) {
        this.isOnline = isOnline;
    }

    public Boolean getIsplayingnow() {
        return isplayingnow;
    }

    public void setIsplayingnow(Boolean isplayingnow) {
        this.isplayingnow = isplayingnow;
    }

    public Integer getGamesPlayed() {
        return GamesPlayed;
    }

    public void setGamesPlayed(Integer GamesPlayed) {
        this.GamesPlayed = GamesPlayed;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
    

}
