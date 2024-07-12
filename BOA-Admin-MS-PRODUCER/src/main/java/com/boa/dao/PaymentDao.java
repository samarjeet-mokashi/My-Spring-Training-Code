/**
 * 
 */
package com.boa.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boa.entity.EnrolledCourse;
import com.boa.entity.Payment;
import com.boa.entity.Student;

/**
 * 
 * @author Naman,Purnima,Radha,Ramit,Sai,Vignesh
 *
 * Interface for paymentdao operations
 */
@Repository
public interface PaymentDao extends CrudRepository<Payment, Serializable> {

	public Payment save(Payment payment);

}
