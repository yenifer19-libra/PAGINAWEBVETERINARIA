package paginawebveterinaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import paginawebveterinaria.repositories.UsuarioRepository;
import paginawebveterinaria.entities.UsuarioEntity;

@Service
@Transactional

public class UsuarioService {
    @Autowired UsuarioRepository usuarioRepository;
    public List<UsuarioEntity> busqueda_tabla_prueba_1(Integer id, String name, String email){
        List<UsuarioEntity> result = new ArrayList<>();
        try 
        {
            result = usuarioRepository.sp_busqueda_tabla_prueba(id,name, email);
            return result;
        } catch (Exception ex)
        {
            throw ex;
        }
    }
}
