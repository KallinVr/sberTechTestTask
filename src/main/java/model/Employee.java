package model;

import java.util.UUID;

public class Employee {
    private UUID id;
    private String name;
    private String post;
    private String company;
    private String email;
    private String phones;

    public Employee(UUID id, String name, String post, String company, String email, String phones) {
        this.id = id;
        this.name = name;
        this.post = post;
        this.company = company;
        this.email = email;
        this.phones = phones;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }
}
