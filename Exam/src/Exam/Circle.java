/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exam;

/**
 *
 * @author binh
 */
public class Circle {

    private String ID;
    private float Radius;
    private String Color;

    public Circle() {
    }

    public Circle(String ID, float Radius, String Color) {
        this.ID = ID;
        this.Radius = Radius;
        this.Color = Color;
    }

    public String getID() {
        return ID;
    }

    public float getRadius() {
        return Radius;
    }

    public String getColor() {
        return Color;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setRadius(float Radius) {
        this.Radius = Radius;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }
    
     public float getArea(){
        return (float) (Math.PI * Math.pow(Radius, 2));
    }

    @Override
    public String toString() {
        return "Circle with radius = " + Radius + ", and color = " + Color;
    }
}
