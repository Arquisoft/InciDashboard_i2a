package com.uniovi.tests_domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import com.uniovi.entities.Operator;
import com.uniovi.entities.types.OperatorKind;

public class OperatorTest {
	private Operator op1;
	private Operator op2;

	@Before
	public void setUp() {
		op1 = new Operator("fireman@gmail.com", "123456", OperatorKind.FIREMAN, "ROLE_OPERATOR");
		op2 = new Operator("policeman@gmail.com", "123456", OperatorKind.POLICE, "ROLE_OPERATOR");
	}
	
	@Test
	public void opToStringTest() {
		String op1ToString = "Operator [id=" + op1.getId() + 
				", email=" + op1.getEmail() + ", password=" + op1.getPassword() + 
				", kind=" + op1.getKind() + ", role=" + op1.getRole() + 
				", mapAccess=" + op1.hasMapAccess() + ", chartAccess=" + op1.hasChartAccess() + ", modifyAccess=" + op1.hasModifyAccess()+
				"]";
		
		String op2ToString = "Operator [id=" + op2.getId() + 
				", email=" + op2.getEmail() + ", password=" + op2.getPassword() + 
				", kind=" + op2.getKind() + ", role=" + op2.getRole() + 
				", mapAccess=" + op2.hasMapAccess() + ", chartAccess=" + op2.hasChartAccess() + ", modifyAccess=" + op2.hasModifyAccess()+
				"]";
		
		Assert.assertEquals(op1ToString, op1.toString());
		Assert.assertEquals(op2ToString, op2.toString());
	}
	
	@Test
	public void opEmailPasswordTest() {
		Assert.assertEquals("fireman@gmail.com", op1.getEmail());
		Assert.assertEquals("policeman@gmail.com", op2.getEmail());
		
		op1.setEmail(op2.getEmail());
		Assert.assertEquals("policeman@gmail.com", op1.getEmail());
		
		op2.setEmail("fireman@gmail.com");
		Assert.assertEquals("fireman@gmail.com", op2.getEmail());
	}
	
	@Test
	public void opKindTest() {
		Assert.assertEquals(OperatorKind.FIREMAN, op1.getKind());
		Assert.assertEquals(OperatorKind.POLICE, op2.getKind());
		
		op1.setKind(op2.getKind());
		Assert.assertEquals(OperatorKind.POLICE, op1.getKind());
		
		op2.setKind(OperatorKind.RESCUE);
		Assert.assertEquals(OperatorKind.RESCUE, op2.getKind());
	}
	
	@Test
	public void opRoleTest() {
		Assert.assertEquals(false, op1.isAdmin());
		Assert.assertEquals(false, op2.isAdmin());
		
		op1.modifyOperatorRole(true);
		op2.modifyOperatorRole(false);
		Assert.assertEquals(true, op1.isAdmin());
		Assert.assertEquals(false, op2.isAdmin());
	}
	
	@Test
	public void opAccessTest() {
		Assert.assertEquals(false, op1.hasMapAccess());
		Assert.assertEquals(false, op1.hasChartAccess());
		Assert.assertEquals(false, op1.hasModifyAccess());
		
		Assert.assertEquals(false, op2.hasMapAccess());
		Assert.assertEquals(false, op2.hasChartAccess());
		Assert.assertEquals(false, op2.hasModifyAccess());
		
		op1.setMapAccess(true);
		op1.setChartAccess(true);
		Assert.assertEquals(true, op1.hasMapAccess());
		Assert.assertEquals(true, op1.hasChartAccess());
		Assert.assertEquals(false, op1.hasModifyAccess());
		
		op2.setMapAccess(true);
		op2.setModifyAccess(true);
		Assert.assertEquals(true, op2.hasMapAccess());
		Assert.assertEquals(false, op2.hasChartAccess());
		Assert.assertEquals(true, op2.hasModifyAccess());
	}

}
