package models;

public class Alumno {
    private String name;
    private String id;

    public Alumno(String name, String id){
        this.name   = name;
        this.id     = id;
    }

    public Alumno(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
