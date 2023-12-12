package com.example.samspringboot3appjoin.respository;

import com.example.samspringboot3appjoin.model.MyUser;
import com.example.samspringboot3appjoin.model.QMyUser;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <pre>
 * User: clean_brain
 * Date: 2023-12-12
 * Comments:
 * </pre>
 */
@Repository
public class MyUserRepository {
    private final EntityManager em;
    private final JPAQueryFactory jpaQueryFactory;
    private final QMyUser qUser = new QMyUser("myuser");

    public MyUserRepository(EntityManager em) {
        this.em = em;
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Transactional
    public void create(MyUser myUser) {
        this.em.persist(myUser);
    }

    public List<MyUser> getUserList() {
        return this.jpaQueryFactory.selectFrom(qUser)
                .fetch();
    }
}
