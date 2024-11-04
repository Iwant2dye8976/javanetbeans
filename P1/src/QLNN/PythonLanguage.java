/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLNN;

/**
 *
 * @author binh
 */
public class PythonLanguage extends Language {

    private Boolean DynamicTyped;

    public PythonLanguage() {
    }

    public PythonLanguage(Boolean DynamicTyped, int ID, String Name, int RealeaseYear, String Author, String Usage) {
        super(ID, Name, RealeaseYear, Author, Usage);
        this.DynamicTyped = DynamicTyped;
    }

    public Boolean getDynamicTyped() {
        return DynamicTyped;
    }

    public void setDynamicTyped(Boolean DynamicTyped) {
        this.DynamicTyped = DynamicTyped;
    }

}
