package com.pedro.painelsrv.util;

import java.util.Objects;

public class Funcoes {

	public static boolean validateUrlParam( String param) {
		return Objects.isNull(param) || param.equalsIgnoreCase("null") || param.isEmpty(); 
	}

}
