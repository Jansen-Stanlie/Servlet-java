package exam06.model;

public class User {
    int id;
    String name;
    String email;
    String password;
    String status;
    String Address;
    int physics,calculus,biologi;
    public User() {
    }

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(int ID, String email, String password) {
        this.id = ID;
        this.email = email;
        this.password = password;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public User(String name, String address,String status, int physics,int calculus, int biologi) {
        this.Address = address;
        this.name = name;
        this.status = status;
        this.physics = physics;
        this.calculus = calculus;
        this.biologi = biologi;
    }
    public User(int ID, String name, String status, int physics,int calculus, int biologi) {
        this.id = ID;
        this.name = name;
        this.status = status;
        this.physics = physics;
        this.calculus = calculus;
        this.biologi = biologi;
    }
    public User(int ID, String name,String address, String status, int physics,int calculus, int biologi) {
        this.id = ID;
        this.Address = address;
        this.name = name;
        this.status = status;
        this.physics = physics;
        this.calculus = calculus;
        this.biologi = biologi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public int getPhysics() {
        return physics;
    }
    public void setPhysics(int Physics) {
        this.physics = Physics;
    }
    public int getCalculus() {
        return calculus;
    }
    public void setCalculus(int Calculus) {
        this.calculus = Calculus;
    }
    public int getBiologi() {
        return biologi;
    }
    public void setBiologi(int Biologi) {
        this.biologi = Biologi;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAddress(String address){
        this.Address = address;
    }
    public String getAddress(){
         return Address;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", Address='" + Address + '\'' +
                ", physics=" + physics +
                ", calculus=" + calculus +
                ", biologi=" + biologi +
                '}';
    }
}
