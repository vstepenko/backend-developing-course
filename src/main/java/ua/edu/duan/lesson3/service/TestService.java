package ua.edu.duan.lesson3.service;

public class TestService {

    protected TestServiceTwo getTestServiceTwo() {
        return null;
    }

    public String helloWorld(){
        return getTestServiceTwo().getReference();
    }
}
