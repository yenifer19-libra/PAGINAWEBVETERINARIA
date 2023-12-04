package paginawebveterinaria.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import paginawebveterinaria.entity.UsuarioEntity;
import paginawebveterinaria.entity.LoginEntity.UsuariopruebaEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

        // SELECT
        @Transactional
        @Query(nativeQuery = true, value = "CALL sp_ricerca_tabla_prueba(:_id, :_nombre, :_email)")
        List<UsuarioEntity> sp_ricerca_tabla_prueba(
                        @Param("_id") Integer idUser,
                        @Param("_nombre") String nameUser,
                        @Param("_email") String emailUser);

        // INSERT
        @Transactional
        @Modifying
        @Query(nativeQuery = true, value = "CALL sp_insertar_persona(:nombre, :email)")
        void sp_insertar_persona(
                        @Param("nombre") String nombre,
                        @Param("email") String email);

        // UPDATE
        @Transactional
        @Modifying
        @Query(nativeQuery = true, value = "CALL sp_actualizar_persona(:_id, :_nombre, :_email)")
        void sp_actualizar_persona(
                        @Param("_id") Integer idUser,
                        @Param("_nombre") String nameUser,
                        @Param("_email") String emailUser);

        // DELETE
        @Transactional
        @Modifying
        @Query(nativeQuery = true, value = "CALL sp_eliminar_persona(:_id)")
        void sp_eliminar_persona(
                        @Param("_id") Integer id);
}