package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import domaine.Memoire;

public interface MemoireRepository extends JpaRepository<Memoire, Integer> {

}
