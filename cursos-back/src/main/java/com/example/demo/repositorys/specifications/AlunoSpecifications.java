package com.example.demo.repositorys.specifications;

import com.example.demo.models.Aluno;
import com.example.demo.models.Aluno_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class AlunoSpecifications {

    public static Specification<Aluno> matriculaLike(Long info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Aluno_.matricula), info);
    }

    public static Specification<Aluno> nomeLike(String info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Aluno_.nome), "%"+info+"%");
    }

    public static Specification<Aluno> rgLike(String info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Aluno_.rg), "%"+info+"%");
    }

    public static Specification<Aluno> cpfLike(String info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Aluno_.cpf), "%"+info+"%");
    }

    public static Specification<Aluno> emailLike(String info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Aluno_.email), "%"+info+"%");
    }

    public static Specification<Aluno> likeGenericQuery(String queryString) {
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
