import java.io.IOException;

public class User {
    private String firstName , lastName;
    private int age;

    private User(UserBuilder ub){
        this.firstName = ub.firstName;
        this.lastName = ub.lastName;
        this.age = ub.age;
    }

    static class UserBuilder {
        String firstName , lastName;
        int age;

        UserBuilder(){}

        UserBuilder setFirstName(String x) throws IOException{
            if(x != ""){
                this.firstName = x;
                return this;
            }
            else     throw new IOException("invalid firstname");
        }

        UserBuilder setLastName(String x) throws IOException{
            if(x != ""){
                this.lastName = x;
                return this;
            }
            else    throw new IOException("Invalid last name");
        }

        UserBuilder setAge(int age) throws IOException{
            if(age > 0 && age < 100){
                this.age = age;
                return this;
            }
            else    throw new IOException("Invalid age");
        }

        User build(){
            return new User(this);
        }
    }
}
