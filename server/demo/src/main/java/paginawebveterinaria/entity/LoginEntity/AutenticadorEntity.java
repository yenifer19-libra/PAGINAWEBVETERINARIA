package paginawebveterinaria.entity.LoginEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AutenticadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;
    private String nombres;
    private String apellidos;
    private String email;
    private String password;

    // GETTERS SETTERS
    // ID
    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    // NOMBRES
    public String getnombres() {
        return nombres;
    }

    public void setnombres(String nombres) {
        this.nombres = nombres;
    }

    // APELLIDOS
    public String getapellidos() {
        return apellidos;
    }

    public void setapellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    // EMAIL
    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    // PASSWORD
    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }
}