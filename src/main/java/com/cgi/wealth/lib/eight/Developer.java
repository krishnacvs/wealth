package com.cgi.wealth.lib.eight;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Developer {
    private Integer id;
    private String name;
    private Set<String> book;

    //getters, setters, toString

    public void addBook(String book) {
        if (this.book == null) {
            this.book = new HashSet<>();
        }
        this.book.add(book);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", book=" + book +
                '}';
    }
}
