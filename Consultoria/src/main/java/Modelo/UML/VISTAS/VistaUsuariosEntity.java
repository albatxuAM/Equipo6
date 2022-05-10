package Modelo.UML.VISTAS;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "VISTA_USUARIOS", schema = "SYSTEM", catalog = "")
public class VistaUsuariosEntity {
    @Basic
    @Column(name = "COD_USUARIO")
    private byte codUsuario;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic
    @Column(name = "FECHA_NACIMIENTO")
    private Date fechaNacimiento;
    @Basic
    @Column(name = "PASSWORD_")
    private String password;
    @Basic
    @Column(name = "EMAIL")
    private String email;
    @Basic
    @Column(name = "COD_ROL")
    private byte codRol;
    @Basic
    @Column(name = "NOM_ROL")
    private String nomRol;

    public byte getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(byte codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte getCodRol() {
        return codRol;
    }

    public void setCodRol(byte codRol) {
        this.codRol = codRol;
    }

    public String getNomRol() {
        return nomRol;
    }

    public void setNomRol(String nomRol) {
        this.nomRol = nomRol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VistaUsuariosEntity that = (VistaUsuariosEntity) o;
        return codUsuario == that.codUsuario && codRol == that.codRol && Objects.equals(nombre, that.nombre) && Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(password, that.password) && Objects.equals(email, that.email) && Objects.equals(nomRol, that.nomRol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codUsuario, nombre, fechaNacimiento, password, email, codRol, nomRol);
    }
}
