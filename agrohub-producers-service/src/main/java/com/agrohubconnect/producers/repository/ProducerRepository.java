package com.agrohubconnect.producers.repository;

import com.agrohubconnect.producers.model.Producer;
import com.agrohubconnect.producers.model.ProducerStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProducerRepository extends JpaRepository<Producer, UUID> {

    // --- Búsquedas por campos exactos ---

    /**
     * Busca un productor por su nombre.
     * @param name El nombre exacto del productor.
     * @return Un Optional que contiene el productor si se encuentra, o vacío si no.
     */
    Optional<Producer> findByName(String name);

    /**
     * Busca un productor por su CIF/NIF.
     * Como el CIF/NIF es único (@Column(unique=true)), esperamos a lo sumo un resultado.
     * @param cifNif El CIF/NIF exacto del productor.
     * @return Un Optional que contiene el productor si se encuentra, o vacío si no.
     */
    Optional<Producer> findByCifNif(String cifNif);

    /**
     * Busca un productor por su dirección de correo electrónico.
     * Como el email es único (@Column(unique=true)), esperamos a lo sumo un resultado.
     * @param email La dirección de correo electrónico exacta del productor.
     * @return Un Optional que contiene el productor si se encuentra, o vacío si no.
     */
    Optional<Producer> findByEmail(String email);

    /**
     * Busca productores por su número de teléfono.
     * Puede haber varios productores con el mismo número, por eso devuelve una lista.
     * @param phone El número de teléfono exacto.
     * @return Una lista de productores que coinciden con el número de teléfono.
     */
    List<Producer> findByPhone(String phone);

    // --- Búsquedas por estado ---

    /**
     * Busca todos los productores que tienen un estado específico.
     * @param status El estado del productor (ej. ACTIVE, INACTIVE).
     * @return Una lista de productores que coinciden con el estado.
     */
    List<Producer> findByStatus(ProducerStatus status);

    /**
     * Busca todos los productores que tienen un estado específico, con paginación y ordenación.
     * Esto es útil si esperas muchos resultados.
     * @param status El estado del productor.
     * @param pageable Objeto Pageable para definir la página, tamaño y ordenación.
     * @return Una página de productores que coinciden con el estado.
     */
    Page<Producer> findByStatus(ProducerStatus status, Pageable pageable);

    // --- Búsquedas parciales (LIKE) ---

    /**
     * Busca productores cuyo nombre contiene una cadena específica (búsqueda parcial).
     * La búsqueda no distingue entre mayúsculas y minúsculas.
     * @param name La cadena a buscar en el nombre del productor.
     * @param pageable Objeto Pageable para paginación y ordenación.
     * @return Una página de productores que coinciden con la búsqueda parcial del nombre.
     */
    Page<Producer> findByNameContainingIgnoreCase(String name, Pageable pageable);

    /**
     * Busca productores cuya dirección contiene una cadena específica (búsqueda parcial).
     * La búsqueda no distingue entre mayúsculas y minúsculas.
     * @param address La cadena a buscar en la dirección del productor.
     * @param pageable Objeto Pageable para paginación y ordenación.
     * @return Una página de productores que coinciden con la búsqueda parcial de la dirección.
     */
    Page<Producer> findByAddressContainingIgnoreCase(String address, Pageable pageable);

    // --- Combinación de búsquedas ---

    /**
     * Busca productores por estado y cuyo nombre contiene una cadena específica.
     * @param status El estado del productor.
     * @param name La cadena a buscar en el nombre del productor.
     * @param pageable Objeto Pageable para paginación y ordenación.
     * @return Una página de productores que coinciden con el estado y el nombre parcial.
     */
    Page<Producer> findByStatusAndNameContainingIgnoreCase(ProducerStatus status, String name, Pageable pageable);

    // --- Comprobación de existencia ---

    /**
     * Comprueba si ya existe un productor con un CIF/NIF dado, excluyendo el ID actual (para actualizaciones).
     * Útil para validaciones antes de guardar o actualizar.
     * @param cifNif El CIF/NIF a comprobar.
     * @param id El ID del productor actual (para excluirlo de la comprobación).
     * @return True si existe otro productor con ese CIF/NIF, false en caso contrario.
     */
    boolean existsByCifNifAndIdNot(String cifNif, UUID id);

    /**
     * Comprueba si ya existe un productor con un CIF/NIF dado.
     * Útil para validaciones al crear un nuevo productor.
     * @param cifNif El CIF/NIF a comprobar.
     * @return True si existe un productor con ese CIF/NIF, false en caso contrario.
     */
    boolean existsByCifNif(String cifNif);

    /**
     * Comprueba si ya existe un productor con un email dado, excluyendo el ID actual (para actualizaciones).
     * @param email El email a comprobar.
     * @param id El ID del productor actual (para excluirlo de la comprobación).
     * @return True si existe otro productor con ese email, false en caso contrario.
     */
    boolean existsByEmailAndIdNot(String email, UUID id);

    /**
     * Comprueba si ya existe un productor con un email dado.
     * @param email El email a comprobar.
     * @return True si existe un productor con ese email, false en caso contrario.
     */
    boolean existsByEmail(String email);
}