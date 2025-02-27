/**
 * 
 */
package com.boa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boa.entity.Professor;

/**
 * @author Naman, Radha, Ramit, Purnima, Sai, Vignesh
 *
 */
@Repository
public interface ProfessorDao extends CrudRepository<Professor, Integer>  {

}
