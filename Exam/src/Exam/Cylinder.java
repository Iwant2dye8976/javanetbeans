/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exam;

/**
 *
 * @author binh
 */
public class Cylinder extends Circle {

    private float Height;

    public Cylinder() {
    }

    public Cylinder(float Height) {
        this.Height = Height;
    }

    public Cylinder(float Height, String ID, float Radius, String Color) {
        super(ID, Radius, Color);
        this.Height = Height;
    }

    public float getHeight() {
        return Height;
    }

    public void setHeight(float Height) {
        this.Height = Height;
    }

    @Override
    public float getArea() {
        return (float) (2 * Math.PI * this.getRadius() * this.getHeight() + 2 * super.getArea());
    }

    public float getVolume() {
        return (float) (getArea() * Height);
    }
}
