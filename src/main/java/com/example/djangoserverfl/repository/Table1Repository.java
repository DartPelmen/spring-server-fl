package com.example.djangoserverfl.repository;

import com.example.djangoserverfl.entity.Table1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Repository
public interface Table1Repository extends JpaRepository<Table1, Long> {

}
