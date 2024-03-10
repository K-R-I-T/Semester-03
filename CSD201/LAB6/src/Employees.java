/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Employees implements Comparable<Employees> {

    private String id;
    private String name;
    private int level;

    public Employees(String id, String name, int level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Employees{" + "id=" + id + ", name=" + name + ", level=" + level + '}';
    }

    @Override
    public int compareTo(Employees o) {
        return this.id.compareTo(o.getId());
    }

}
