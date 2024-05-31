package com.pedro.painelsrv;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**This bean is required to activate JSF 2.3.
 * See https://github.com/eclipse-ee4j/mojarra/blob/2.3/README.md#user-content-activating-cdi-in-jakarta-faces-23
 * 
 * Remove this class if you don't need JSF.
 */
@ApplicationPath("/api")
public class JaxRsActivator extends Application{

}