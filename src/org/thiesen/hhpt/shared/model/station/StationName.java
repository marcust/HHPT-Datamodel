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


public class StationName implements Serializable {

    private static final long serialVersionUID = 4509557855817257433L;
    
    private final String _name;
    
    private StationName( final String name ) {
        _name = name;
    }
    
    public static StationName valueOf( final String name ) {
        return new StationName( name == null ? "" : name );
    }

    public void appendWithSep( final StringBuilder retval, final char sep ) {
        retval.append( _name ).append( sep );
    }

    public String asString() {
        return _name;
        
    }
    
}
