package com.example.demo.repositorys.specifications;

import com.example.demo.models.Curso;
import com.example.demo.models.Curso_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class CursoSpecifications {
    public static Specification<Curso> nomeLike(String info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Curso_.nome), "%"+info+"%");
    }

    public static Specification<Curso> descricaoLike(String info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Curso_.descricao), "%"+info+"%");
    }

    public static Specification<Curso> cargaLike(Long info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Curso_.cargaHoraria), info);
    }


    public static Specification<Curso> likeGenericQuery(String queryString) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>(4);
            predicates.add(nomeLike(queryString).toPredicate(root, query, criteriaBuilder));
            predicates.add(descricaoLike(queryString).toPredicate(root, query, criteriaBuilder));
            return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
        };
    }
    
}
