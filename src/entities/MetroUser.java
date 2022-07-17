package entities;

public abstract class MetroUser{

    private String name,username,email,password,dob,nid, mobNo, gender;
    int id;

    public MetroUser(){}
    public MetroUser(String name, String username, String email, String password, String dob, String nid, String mobNo, String gender){
        this.name=name;
        this.username=username;
        this.email=email;
        this.password=password;
        this.dob=dob;
        this.nid=nid;
        this.mobNo = mobNo;
        this.gender=gender;
    }



    //setters
    public void setId(int id) {
        this.id = id;
    } 

    public void setName(String name) {
        this.name = name;
    } 

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setnid(String nid) {
        this.nid = nid;
    }

    public void setMobNo(String mobNo){
        this.mobNo = mobNo;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    //getters
    public int getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDob() {
        return dob;
    }

    public String getnid() {
        return nid;
    }

    public String getMobNo(){
        return mobNo;
    }

    public String getGender() {
        return gender;
    }
}

