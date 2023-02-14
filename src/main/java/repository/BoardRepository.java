package repository;

import domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em;

    public void save(Board board){
        em.persist(board);
    }

    public Board findById(Long id){
        return em.find(Board.class, id);
    }

    public List<Board> findAll(BoardSearch boardSearch){
        String jpql = "select b from Board b join b.member m";
        return em.createQuery(jpql, Board.class)
                .getResultList();
    }

}
