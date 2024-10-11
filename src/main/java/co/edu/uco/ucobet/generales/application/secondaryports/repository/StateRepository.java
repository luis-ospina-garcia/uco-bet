package co.edu.uco.ucobet.generales.application.secondaryports.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.StateEntiy;

@Repository
public interface StateRepository extends JpaRepository<StateEntiy, UUID> {

}
