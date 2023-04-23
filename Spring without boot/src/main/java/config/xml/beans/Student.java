package config.xml.beans;

import java.util.*;

public class Student {
    private String name;
    private int age;
    private Address address;
    private List<String> friends;

    public Map<String, String> getStacks() {
        return stacks;
    }

    public void setStacks(Map<String, String> stacks) {
        this.stacks = stacks;
    }

    private Map<String,String> stacks;

    Student() {
        System.out.println(this.getClass().getSimpleName()+ " created");
    }

    public void hello() {
        System.out.println("Hello from" + this.getClass());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return String.format("I am %s of age %s, " +
                "My address %s, My friends %s, My stacks %s", this.name,
                this.age, this.address,
                this.friends,this.stacks);
    }


}
