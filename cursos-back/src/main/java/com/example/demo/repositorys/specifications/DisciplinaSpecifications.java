package com.example.demo.repositorys.specifications;

import com.example.demo.models.Disciplina;
import com.example.demo.models.Disciplina_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaSpecifications {

    public static Specification<Disciplina> nomeLike(String info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Disciplina_.nome), "%"+info+"%");
    }

    public static Specification<Disciplina> cargaLike(Long info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Disciplina_.cargaHoraria), info);
    }

    public static Specification<Disciplina> likeGenericQuery(String queryString) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>(4);
            predicates.add(nomeLike(queryString).toPredicate(root, query, criteriaBuilder));
            return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
        };
    }
    
}
