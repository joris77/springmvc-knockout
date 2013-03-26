package nl.smartworkx.springmvc.infra.repository;

import nl.smartworkx.springmvc.infra.validation.ValidationException;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashSet;

/**
 * User: joris
 * Date: 3/21/13
 * Time: 8:55 AM
 */
public abstract class BaseRepository<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    public abstract Class<T> getDomainClass();

    public T findById(Long id) {
        return entityManager.find(getDomainClass(), id);
    }

    public void update(T object) throws ValidationException {
        entityManager.merge(object);
        entityManager.flush();

    }


    public void create(T object) {
        entityManager.persist(object);
        entityManager.flush();
    }
}
