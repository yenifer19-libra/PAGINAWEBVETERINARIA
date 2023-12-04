package paginawebveterinaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;
import paginawebveterinaria.entity.UsuarioEntity;
import paginawebveterinaria.entity.LoginEntity.AutenticadorEntity;
import paginawebveterinaria.entity.LoginEntity.ObtenerAutenticadorEntity;

import paginawebveterinaria.repository.LoginRepository.ObtenerCredenciales;
import paginawebveterinaria.repository.LoginRepository.ObtenerAutenticador;

@Service
@Transactional
public class LoginService {
    @Autowired
    ObtenerCredenciales credenciales;
    @Autowired
    ObtenerAutenticador autenticador;

    public List<AutenticadorEntity> obtener_usuarios(String email) {
        List<AutenticadorEntity> result = new ArrayList<>();
        try {
            result = credenciales.sp_obtener_credenciales(email);

        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

    public boolean autenticador(String password_de_evaluar, String password_verdadera) {
        boolean result = false;
        result = password_de_evaluar.equals(password_verdadera);
        return result;
    }

    public ObtenerAutenticadorEntity obtener_autenticador(Integer id) {
        List<ObtenerAutenticadorEntity> list_result = new ArrayList<>(); // lista de resultados
        ObtenerAutenticadorEntity result = new ObtenerAutenticadorEntity(); // obtener el resultado
        try {
            // Por fuerza obtiene solo un valor porque es la primary key
            list_result = autenticador.sp_obtener_autenticador(id);
            result = list_result.get(0);
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }
}