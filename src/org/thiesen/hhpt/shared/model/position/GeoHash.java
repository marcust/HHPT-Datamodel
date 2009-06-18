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
package org.thiesen.hhpt.shared.model.position;

import java.io.Serializable;

public class GeoHash implements Serializable {

    private final String _value;
    
    private GeoHash( final String value ) {
        _value = value;
    }
    
    public static GeoHash valueOf( final String value ) {
        return new GeoHash( value );
    }
    
    public void appendWithSep( final StringBuilder builder, final char sep ) {
        builder.append( _value ).append( sep );
    }

    public String getValue() {
        return _value;
        
    }
}
