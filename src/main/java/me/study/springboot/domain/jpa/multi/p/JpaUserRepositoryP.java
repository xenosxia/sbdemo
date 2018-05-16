package me.study.springboot.domain.jpa.multi.p;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
@NoRepositoryBean
public interface JpaUserRepositoryP extends JpaRepository<JpaUserP, Long> {


}
