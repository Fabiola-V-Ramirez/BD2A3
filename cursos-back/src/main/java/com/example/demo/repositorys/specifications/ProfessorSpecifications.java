package com.example.demo.repositorys.specifications;

import com.example.demo.models.Professor;
import com.example.demo.models.Professor_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class ProfessorSpecifications {

    public static Specification<Professor> matriculaLike(Long info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Professor_.matricula), info);
    }

    public static Specification<Professor> nomeLike(String info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Professor_.nome), "%"+info+"%");
    }

    public static Specification<Professor> rgLike(String info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Professor_.rg), "%"+info+"%");
    }

    public static Specification<Professor> cpfLike(String info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Professor_.cpf), "%"+info+"%");
    }

    public static Specification<Professor> emailLike(String info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Professor_.email), "%"+info+"%");
    }

    public static Specification<Professor> likeGenericQuery(String queryString) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>(4);
            predicates.add(nomeLike(queryString).toPredicate(root, query, criteriaBuilder));
            predicates.add(rgLike(queryString).toPredicate(root, query, criteriaBuilder));
            predicates.add(cpfLike(queryString).toPredicate(root, query, criteriaBuilder));
            predicates.add(emailLike(queryString).toPredicate(root, query, criteriaBuilder));
            return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
        };
    }

}
