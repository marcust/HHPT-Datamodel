/*
 * $ Id $
 * (c) Copyright 2009 freiheit.com technologies gmbh
 *
 * This file contains unpublished, proprietary trade secret information of
 * freiheit.com technologies gmbh. Use, transcription, duplication and
 * modification are strictly prohibited without prior written consent of
 * freiheit.com technologies gmbh.
 *
 * Initial version by Marcus Thiesen (marcus.thiesen@freiheit.com)
 */
package org.thiesen.hhpt.shared.model.station;

import java.io.Serializable;


public class Operator implements Serializable {

    private static final long serialVersionUID = -9178938300687132594L;
    
    private final String _name;
    
    private Operator( final String name ) {
        _name = name;
    }
    
    public static Operator valueOf( final String name ) {
        return new Operator( name == null ? "" : name );
    }

    public void appendWithSep( final StringBuilder retval, final char sep ) {
        retval.append( _name ).append( sep );
    }

    public String stringValue() {
        return _name;
        
    }
    
    
}
