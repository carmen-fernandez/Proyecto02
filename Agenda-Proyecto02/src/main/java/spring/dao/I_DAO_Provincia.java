package spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.model.Provincia;


/** Interface que incluye los métodos de CRUD*/

@Repository
public interface I_DAO_Provincia extends JpaRepository<Provincia, Integer>  {

}
