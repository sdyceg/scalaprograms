package proxy;

public class Person implements Animal {
    private String name;
    private int age;
    private String gender;

    public Person() {
    }

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void say(String words) {
        System.out.println(name+"talk=======>"+words);
    }

    public void run(int fast) {
        System.out.println(name+"run============>"+fast);
    }

    public void eat(String foods) {
        System.out.println(name+"=============>"+foods);
    }

    public String returnString(String string) {
        return name+":this is PersonAnimalMethod";
    }

    public String PersonOwnMethod(String string){
        return name+":this is PersonOwnMethod";
    }
    public String toString(){
        return name+":"+age+":"+gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
