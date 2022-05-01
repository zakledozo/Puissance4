package puissance_4;

public class Player {
    private int Id;
    private String Username;
    private String Email;
    private String Password;
    private int Permission;

    public Player(int _id, String _username, String _email, String _password, int _permission) {
        Id = _id;
        Username = _username;
        Email = _email;
        Password = _password;
        Permission = _permission;
    }


    public int GetId() {
        return Id;
    }

    public int GetPermission() {
        return Permission;
    }

    public String GetUsername() {
        return Username;
    }

    public String GetEmail() {
        return Email;
    }

    public String GetPassword() {
        return Password;
    }
}



