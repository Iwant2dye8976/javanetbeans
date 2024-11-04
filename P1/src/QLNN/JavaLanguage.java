/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLNN;

/**
 *
 * @author binh
 */
public class JavaLanguage extends Language {

    private String JdkVersion;

    public JavaLanguage() {
    }

    public JavaLanguage(String JdkVersion, int ID, String Name, int RealeaseYear, String Author, String Usage) {
        super(ID, Name, RealeaseYear, Author, Usage);
        this.JdkVersion = JdkVersion;
    }

    public String getJdkVersion() {
        return JdkVersion;
    }

    public void setJdkVersion(String JdkVersion) {
        this.JdkVersion = JdkVersion;
    }
}
