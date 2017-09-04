package dev.paie.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dev.paie.util.PaieUtils;

public class PaieUtilsTest {

private PaieUtils paieUtils;
private ClassPathXmlApplicationContext context;

@Before
public void onSetup() {
	//code executé à chaque test
	context= new ClassPathXmlApplicationContext("app-config.xml");
	paieUtils=context.getBean(PaieUtils.class);
}

@Test
public void test_formaterBigDecimal_entier_positif() {
	
	String resultat = paieUtils.formaterBigDecimal(new BigDecimal("2"));
	assertThat(resultat, equalTo("2.00"));
	
}

@Test 
public void test_formaterBigDecimal_arrondi_sup() {
	
	String resultat = paieUtils.formaterBigDecimal (new BigDecimal("20.1994"));
	assertThat(resultat, equalTo("20.20"));
}


@After
public void onExit() {
	// code exécuté après chaque test
	context.close();
}











/**
 * @return the paieUtils
 */
public PaieUtils getPaieUtils() {
	return paieUtils;
}


/**
 * @param paieUtils the paieUtils to set
 */
public void setPaieUtils(PaieUtils paieUtils) {
	this.paieUtils = paieUtils;
}

/**
 * @return the context
 */
public ClassPathXmlApplicationContext getContext() {
	return context;
}

/**
 * @param context the context to set
 */
public void setContext(ClassPathXmlApplicationContext context) {
	this.context = context;
}


}
