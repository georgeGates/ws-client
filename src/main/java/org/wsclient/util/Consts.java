package org.wsclient.util;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author George Compton - george.compton@hotmail.com
 * @since 2019.08.12
 *
 */
@Getter
@Setter
public final class Consts {
	
	/* Date and Time */
    public static final String TIME = "HH:mm";
    public static final String FULL_TIME = "HH:mm:ss";
    public static final String DATE = "yyyy-MM-dd";
    public static final String FULL_DATE = "yyyy-MM-dd HH:mm:ss";
    
    /* CEP */
    public static final String CEP = "00000000";
    
    /* CPF */
    public static final String CPF = "00000000000";
    
    private Consts() {
    }
}
