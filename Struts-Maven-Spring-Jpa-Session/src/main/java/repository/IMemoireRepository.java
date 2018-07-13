package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import domaine.Memoire;

public interface IMemoireRepository extends JpaRepository <Memoire, Integer> {

}
