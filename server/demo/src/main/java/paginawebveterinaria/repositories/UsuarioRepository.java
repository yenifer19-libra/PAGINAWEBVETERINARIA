package paginawebveterinaria.repositories;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.hibernate.procedure.ParameterRegistration;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import paginawebveterinaria.entities.UsuarioEntity;
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    //SELECT
    @Transactional
    @Query(nativeQuery = true, value = "CALL sp_busqueda_tabla_prueba(:_id, :_nombre, :_email)")
    List<UsuarioEntity> sp_busqueda_tabla_prueba(
        @Param("_id") Integer idUser,
        @Param("_nombre") String nameUser,
        @Param("_email") String emailUser
    );
}