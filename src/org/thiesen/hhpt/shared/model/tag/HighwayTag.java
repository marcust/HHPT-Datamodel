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
package org.thiesen.hhpt.shared.model.tag;


public class HighwayTag extends Tag {
 
    private final String _value;

    private HighwayTag( final String value ) {
        super( StationTypeTagKey.HIGHWAY );
        _value = value;
    }

    public static HighwayTag withValue( final String value ) {
        return new HighwayTag( value );
        
    }

    @Override
    protected boolean valueEquals( final String value ) {
        return _value.equalsIgnoreCase( value );
    }

    
    
}
