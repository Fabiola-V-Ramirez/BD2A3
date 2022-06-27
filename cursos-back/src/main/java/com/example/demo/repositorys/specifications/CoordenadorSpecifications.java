package com.example.demo.repositorys.specifications;

import com.example.demo.models.Coordenador;
import com.example.demo.models.Coordenador_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class CoordenadorSpecifications {

    public static Specification<Coordenador> areaConhecimentoLike(String info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Coordenador_.areaConhecimento), "%"+info+"%");
    }

    public static Specification<Coordenador> professorLike(String info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Coordenador_.professor), "%"+info+"%");
    }

    public static Specification<Coordenador> likeGenericQuery(String queryString) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>(4);
            predicates.add(areaConhecimentoLike(queryString).toPredicate(root, query, criteriaBuilder));
            predicates.add(professorLike(queryString).toPredicate(root, query, criteriaBuilder));
            return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
        };
    }

}
