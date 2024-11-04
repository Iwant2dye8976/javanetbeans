/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLNN;

/**
 *
 * @author binh
 */
public class Language {
    private int ID;
    private String Name;
    private int RealeaseYear;
    private String Author, Usage;

    public Language() {
    }

    public Language(int ID, String Name, int RealeaseYear, String Author, String Usage) {
        this.ID = ID;
        this.Name = Name;
        this.RealeaseYear = RealeaseYear;
        this.Author = Author;
        this.Usage = Usage;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public int getRealeaseYear() {
        return RealeaseYear;
    }

    public String getAuthor() {
        return Author;
    }

    public String getUsage() {
        return Usage;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setRealeaseYear(int RealeaseYear) {
        this.RealeaseYear = RealeaseYear;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public void setUsage(String Usage) {
        this.Usage = Usage;
    }
}
