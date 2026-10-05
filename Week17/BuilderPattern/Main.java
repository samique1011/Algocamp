
public class Main {
    public static void main(String args[]){
        try{
            User finalUser = new User.UserBuilder().setFirstName("samique").setLastName("hossain").setAge(180).build();
            System.out.println("User created successfully");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
}
