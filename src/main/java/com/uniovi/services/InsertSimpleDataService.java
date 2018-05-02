package com.uniovi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.uniovi.entities.Incident;
import com.uniovi.entities.Operator;
import com.uniovi.entities.types.OperatorKind;
import com.uniovi.utils.IncidentCreator;

public class InsertSimpleDataService {
	@Autowired
	private OperatorService operatorService;
	
	@Autowired
	private IncidentService incidentService;
	
	@Autowired
	private IncidentCreator incidentCreator;
	
	@PostConstruct
	public void init() {
		List<Operator> operators = new ArrayList<>();
		List<Incident> incidents = new ArrayList<>();
		Random randNum = new Random();
		
		Operator op1 = new Operator("fireman1@gmail.com", "123456", OperatorKind.FIREMAN, "ROLE_ADMIN");
		op1.setMapAccess(true);
		op1.setChartAccess(true);
		op1.setModifyAccess(true);
		operators.add(op1);
		operators.add(new Operator("fireman2@gmail.com", "123456", OperatorKind.FIREMAN, "ROLE_OPERATOR"));
		operators.add(new Operator("fireman3@gmail.com", "123456", OperatorKind.FIREMAN, "ROLE_OPERATOR"));
		operators.add(new Operator("police@gmail.com", "123456", OperatorKind.POLICE, "ROLE_OPERATOR"));
		operators.add(new Operator("medic@gmail.com", "123456", OperatorKind.MEDIC, "ROLE_OPERATOR"));
		operators.add(new Operator("rescue@gmail.com", "123456", OperatorKind.RESCUE, "ROLE_OPERATOR"));
		
		for(Operator op: operators) {
			operatorService.addOperator(op);
		}
		
		for(int i=0; i<10; i++) {
			Incident randIncident = incidentCreator.createIncident();
			randIncident.setOperator(operators.get(randNum.nextInt(operators.size())));
			incidents.add(randIncident);
			incidentService.addIncident(randIncident);			
		}
	}
}
