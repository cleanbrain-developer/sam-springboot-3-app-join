package com.example.samspringboot3appjoin.respository;

import com.example.samspringboot3appjoin.model.MyGroup;
import com.example.samspringboot3appjoin.model.QMyGroup;
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
public class MyGroupRepository {
    private final EntityManager em;
    private final JPAQueryFactory jpaQueryFactory;
    private final QMyGroup qGroup = new QMyGroup("mygroup");

    public MyGroupRepository(EntityManager em) {
        this.em = em;
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Transactional
    public void create(MyGroup myGroup) {
        this.em.persist(myGroup);
    }

    public List<MyGroup> getGroupList() {
        return this.jpaQueryFactory.selectFrom(qGroup)
                .fetch();
    }
}
