package com.uniovi.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Operator;
import com.uniovi.entities.types.OperatorKind;
import com.uniovi.repositories.OperatorRepository;

@Service
public class OperatorService {
	
	@Autowired
	private OperatorRepository operatorRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void addOperator(Operator operator) {
		operator.setPassword(bCryptPasswordEncoder.encode(operator.getPassword()));
		this.operatorRepository.save(operator);
	}
	
	public Operator getOperatorByEmail(String email) {
		return operatorRepository.findByEmail(email);
	}
	
	public Operator getRandomOperatorOfKind(OperatorKind kind) {
		List<Operator> operators = operatorRepository.findAllByKind(kind);
		Random randNum = new Random();
		return operators.get(randNum.nextInt(operators.size()));
	}
}
