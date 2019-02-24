package 序列化;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream stream = new ObjectOutputStream(
                new FileOutputStream("D:" + File.separator + "test.txt"));
        Person person = new Person(1, "张三");
        stream.writeObject(person);
        stream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:" + File.separator + "test.txt"));
        Person p = (Person)objectInputStream.readObject();
        System.out.println(p);
    }
}

class Person implements Serializable{

    private  int age;
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
