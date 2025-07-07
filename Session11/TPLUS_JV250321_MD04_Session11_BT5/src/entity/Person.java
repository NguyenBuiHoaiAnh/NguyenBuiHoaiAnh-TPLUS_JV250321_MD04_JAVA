package entity;

public class Person<T> {
    private T name;
    private T email;
    private T phone;

    public Person() {
    }

    public Person(T name, T email, T phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public T getEmail() {
        return email;
    }

    public void setEmail(T email) {
        this.email = email;
    }

    public T getPhone() {
        return phone;
    }

    public void setPhone(T phone) {
        this.phone = phone;
    }

    public void display(){
        System.out.printf("Name: %s\nEmail: %s\nPhone: %s\n", this.name, this.email, this.phone);
    }
}
