/*
 * generated by Xtext
 */
package org.xtext.java;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class JavaStandaloneSetup extends JavaStandaloneSetupGenerated{

	public static void doSetup() {
		new JavaStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
