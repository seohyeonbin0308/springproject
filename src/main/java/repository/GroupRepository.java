package repository;

import domain.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class GroupRepository {

    private final EntityManager em;

    public void save(Group group){
        em.persist(group);
    }

    public void findById(Long id){
        em.find(Group.class, id);
    }

    public List<Group> findAll(GroupSearch groupSearch){
        String jpql = "select g from Group g join g.member m";
        return em.createQuery(jpql, Group.class)
                .getResultList();
    }

}
